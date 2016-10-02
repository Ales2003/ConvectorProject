/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mail.ales_2003.convector.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import ru.mail.ales_2003.convector.entity.Convector;
import ru.mail.ales_2003.convector.language.LanguageAssistant;

/**
 *
 * @author admin
 */
public class EditConvectorDialog extends JDialog implements ActionListener
{
    // Заголовки кнопок
    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";

    // Размер отступа
    private static final int PAD = 10;
    // Ширина метки
    private static final int W_L = 100;
    //Ширина поля для ввода
    private static final int W_T = 300;
    // Ширина кнопки
    private static final int W_B = 120;
    // высота элемента - общая для всех
    private static final int H_B = 25;

    // Поле для ввода Длины 
    private final JTextPane txtLength = new JTextPane();
    // Поле для ввода Ширины
    private final JTextPane txtWidth = new JTextPane();
    // Поле для ввода Глубины
    private final JTextPane txtDepth = new JTextPane();
    // Поле для ввода Цены
    private final JTextPane txtPrice = new JTextPane();
    // Поле для ввода Мощности
    private final JTextPane txtPower = new JTextPane();

    // Поле для хранения ID конвектора, если мы собираемся редактировать
    // Если это новый конвектор - convectorId == null
    private Long convectorId = null;
    // Надо ли записывать изменения после закрытия диалога
    private boolean save = false;

    public EditConvectorDialog() {
        this(null);
    }

    public EditConvectorDialog(Convector convector) {
        // Убираем layout - будем использовать абсолютные координаты
        setLayout(null);

        // Выстраиваем метки и поля для ввода
        buildFields();
        // Если нам передали конвектор - заполняем поля формы
        initFields(convector);
        // выстариваем кнопки
        buildButtons();

        // Диалог в модальном режиме - только он активен
        setModal(true);
        // Запрещаем изменение размеров
        setResizable(false);
        // Выставляем размеры формы
        setBounds(300, 300, 450, 230);
        // Делаем форму видимой
        setVisible(true);
    }

    // Размещаем метки и поля ввода на форме
    private void buildFields() {
        // Набор метки и поля для Длины
        JLabel lblLength = new JLabel(LanguageAssistant.loadLengthLabelTitle());
        // Выравнивание текста с правой стороны
        lblLength.setHorizontalAlignment(SwingConstants.RIGHT);
        // Выставляем координаты метки
        lblLength.setBounds(new Rectangle(PAD, 0 * H_B + PAD, W_L, H_B));
        // Кладем метку на форму
        add(lblLength);
        // Выставляем координаты поля
        txtLength.setBounds(new Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B));
        // Делаем "бордюр" для поля
        txtLength.setBorder(BorderFactory.createEtchedBorder());
        // Кладем поле на форму
        add(txtLength);

        // Набор метки и поля для Ширины
        JLabel lblWidth = new JLabel(LanguageAssistant.loadWidthhLabelTitle());
        lblWidth.setHorizontalAlignment(SwingConstants.RIGHT);
        lblWidth.setBounds(new Rectangle(PAD, 1 * H_B + PAD, W_L, H_B));
        add(lblWidth);
        txtWidth.setBounds(new Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B));
        txtWidth.setBorder(BorderFactory.createEtchedBorder());
        add(txtWidth);

        // Набор метки и поля для Глубины
        JLabel lblDepth = new JLabel(LanguageAssistant.loadDepthLabelTitle());
        lblDepth.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDepth.setBounds(new Rectangle(PAD, 2 * H_B + PAD, W_L, H_B));
        add(lblDepth);
        txtDepth.setBounds(new Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B));
        txtDepth.setBorder(BorderFactory.createEtchedBorder());
        add(txtDepth);

        // Набор метки и поля для Цены
        JLabel lblPrice = new JLabel(LanguageAssistant.loadPriceLabelTitle());
        lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrice.setBounds(new Rectangle(PAD, 3 * H_B + PAD, W_L, H_B));
        add(lblPrice);
        txtPrice.setBounds(new Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B));
        txtPrice.setBorder(BorderFactory.createEtchedBorder());
        add(txtPrice);
        
        // Набор метки и поля для Мощности
        JLabel lblPower = new JLabel(LanguageAssistant.loadPowerLabelTitle());
        lblPower.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPower.setBounds(new Rectangle(PAD, 4 * H_B + PAD, W_L, H_B));
        add(lblPower);
        txtPower.setBounds(new Rectangle(W_L + 2 * PAD, 4 * H_B + PAD, W_T, H_B));
        txtPower.setBorder(BorderFactory.createEtchedBorder());
        add(txtPower);
    }

    // Если нам передали конвектор - заполняем поля из конвектора
    private void initFields(Convector convector) {
        if (convector != null) {
            convectorId = convector.getConvectorId();
            txtLength.setText(Integer.toString(convector.getLength()));
            txtWidth.setText(Integer.toString(convector.getWidth()));
            txtDepth.setText(Integer.toString(convector.getDepth()));
            txtPrice.setText(Integer.toString(convector.getPrice()));
            txtPower.setText(Integer.toString(convector.getPower()));
        }
    }

    // Размещаем кнопки на форме
    private void buildButtons() {
        JButton btnSave = new JButton(LanguageAssistant.loadSaveButtonTitle());
        btnSave.setActionCommand(SAVE);
        btnSave.addActionListener(this);
        btnSave.setBounds(new Rectangle(PAD, 6 * H_B + PAD, W_B, H_B));
        add(btnSave);

        JButton btnCancel = new JButton(LanguageAssistant.loadCancelButtonTitle());
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setBounds(new Rectangle(W_B + 2 * PAD, 6 * H_B + PAD, W_B, H_B));
        add(btnCancel);
    }

    @Override
    // Обработка нажатий кнопок
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        save = SAVE.equals(action);
        // Закрываем форму
        setVisible(false);
    }

    // Надо ли сохранять изменения
    public boolean isSave() {
        return save;
    }

    // Создаем конвектор из заполенных полей, который можно будет записать
   
    public Convector getConvector() {
        //Обрабвтываем возможные ошибки формата ввода
        // Сразу присваиваем переменным  некорректные значениям, которые будут передаваться в 
        //конструктор конвектора в случае возникновения ошибок
        Integer length = -1;
        Integer width = -1;
        Integer depth = -1;
        Integer price = -1;
        Integer power = -1;
        
        try{
        length = Integer.valueOf(txtLength.getText());
        }
        catch(NumberFormatException n){
        JOptionPane.showMessageDialog(this, LanguageAssistant.loadIncorrectInputLengthMessage());
        }
        try{
        width = Integer.valueOf(txtWidth.getText());
        }
        catch(NumberFormatException n){
        JOptionPane.showMessageDialog(this, LanguageAssistant.loadIncorrectInputWidthMessage());
        }
        try{
        depth = Integer.valueOf(txtDepth.getText());
        }
        catch(NumberFormatException n){
        JOptionPane.showMessageDialog(this, LanguageAssistant.loadIncorrectInputDepthMessage());
        }
        try{
        price = Integer.valueOf(txtPrice.getText());
        }
        catch(NumberFormatException n){
        JOptionPane.showMessageDialog(this, LanguageAssistant.loadIncorrectInputPriceMessage());
        }
        try{
        power = Integer.valueOf(txtPower.getText());
        }
        catch(NumberFormatException n){
        JOptionPane.showMessageDialog(this, LanguageAssistant.loadIncorrectInputPowerMessage());
        }
        
              
               
        Convector convector = new Convector (convectorId, length, width, depth,
        price, power);
        return convector;
        
        // Если код  без исключений 
        /*Convector convector = new Convector (convectorId, Integer.valueOf(txtLength.getText()),
        Integer.valueOf(txtWidth.getText()), Integer.valueOf(txtDepth.getText()),
        Integer.valueOf(txtPrice.getText()), Integer.valueOf(txtPower.getText()));
        return convector;
        */
        }
        
        
    
    
}
