
package ru.mail.ales_2003.convector.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import ru.mail.ales_2003.convector.business.ConvectorManager;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */
public class ConvectorFrame extends JFrame implements ActionListener
{
    private static final String LOAD = "LOAD";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";

    private final ConvectorManager convectorManager = new ConvectorManager();
    private final JTable convectorTable = new JTable();

    // В конструкторе мы создаем нужные элементы
    public ConvectorFrame() {
        // Выставляем у таблицы свойство, которое позволяет выделить
        // ТОЛЬКО одну строку в таблице
        convectorTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        // Используем layout GridBagLayout
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        // Каждый элемент является последним в строке
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // Элемент раздвигается на весь размер ячейки
        gbc.fill = GridBagConstraints.BOTH;
        // Но имеет границы - слева, сверху и справа по 5. Снизу - 0
        gbc.insets = new Insets(5, 5, 0, 5);

        // Создаем панель для кнопок
        JPanel btnPanel = new JPanel();
        // усанавливаем у него layout
        btnPanel.setLayout(gridbag);
        // Создаем кнопки и укзаываем их загловок и ActionCommand
        btnPanel.add(createButton(gridbag, gbc, "Обновить", LOAD));
        btnPanel.add(createButton(gridbag, gbc, "Добавить", ADD));
        btnPanel.add(createButton(gridbag, gbc, "Исправить", EDIT));
        btnPanel.add(createButton(gridbag, gbc, "Удалить", DELETE));

        // Создаем панель для левой колокни с кнопками
        JPanel left = new JPanel();
        // Выставляем layout BorderLayout
        left.setLayout(new BorderLayout());
        // Кладем панель с кнопками в верхнюю часть
        left.add(btnPanel, BorderLayout.NORTH);
        // Кладем панель для левой колонки на форму слева - WEST
        add(left, BorderLayout.WEST);

        // Кладем панель со скролингом, внутри которой нахоится наша таблица
        // Теперь таблица может скроллироваться
        add(new JScrollPane(convectorTable), BorderLayout.CENTER);

        // выставляем координаты формы
        setBounds(100, 200, 900, 400);
        // При закрытии формы заканчиваем работу приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загружаем конвекторы
        loadConvector();
    }

    // Метод создает кнопку с заданными харктеристиками - заголовок и действие
    private JButton createButton(GridBagLayout gridbag, GridBagConstraints gbc, String title, String action) {
        // Создаем кнопку с заданным загловком
        JButton button = new JButton(title);
        // Действие будетп роверяться в обработчике и мы будем знать, какую 
        // именно кнопку нажали
        button.setActionCommand(action);
        // Обработчиком события от кнопки являемся сама форма
        button.addActionListener(this);
        // Выставляем свойства для размещения для кнопки
        gridbag.setConstraints(button, gbc);
        return button;
    }

    @Override
    // Обработка нажатий кнопок
    public void actionPerformed(ActionEvent ae) {
        // Получаем команду - ActionCommand
        String action = ae.getActionCommand();
        // В зависимости от команды выполняем действия
        switch (action) {
            // Перегрузка данных
            case LOAD:
                loadConvector();
                break;
            // Добавление записи
            case ADD:
                addConvector();
                break;
            // Исправление записи
            case EDIT:
                editConvector();
                break;
            // Удаление записи
            case DELETE:
                deleteConvector();
                break;
        }
    }

    // Загрузить список конвекторов
    private void loadConvector() {
        // Обращаемся к классу для загрузки списка конвекторов
        List<Convector> convectors = convectorManager.findConvectors();
        // Создаем модель, которой передаем полученный список
        ConvectorModel cm = new ConvectorModel(convectors);
        // Передаем нашу модель таблице - и она может ее отображать
        convectorTable.setModel(cm);
    }

    // Добавление конвектора
    private void addConvector() {
        // Создаем диалог для ввода данных
        EditConvectorDialog ecd = new EditConvectorDialog();
        // Обрабатываем закрытие диалога
        saveConvector(ecd);
    }

    // Редактирование контакта
    private void editConvector() {
        // Получаем выделеннуб строку
        int sr = convectorTable.getSelectedRow();
        // если строка выделена - можно ее редактировать
        if (sr != -1) {
            // Получаем ID контакта
            Long id = Long.parseLong(convectorTable.getModel().getValueAt(sr, 0).toString());
            // получаем данные контакта по его ID
            Convector cnv = convectorManager.getConvector(id);
            // Создаем диалог для ввода данных и передаем туда контакт
            EditConvectorDialog ecd = new EditConvectorDialog(convectorManager.getConvector(id));
            // Обрабатываем закрытие диалога
            saveConvector(ecd);
        } else {
            // Если строка не выделена - сообщаем об этом
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования");
        }
    }

    // Удаление контакта
    private void deleteConvector() {
        // Получаем выделеннуб строку
        int sr = convectorTable.getSelectedRow();
        if (sr != -1) {
            // Получаем ID контакта
            Long id = Long.parseLong(convectorTable.getModel().getValueAt(sr, 0).toString());
            // Удаляем контакт
            convectorManager.deleteConvector(id);
            // перегружаем список контактов
            loadConvector();
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления");
        }
    }

    // Общий метод для добавления и изменения контакта
    private void saveConvector(EditConvectorDialog ecd) {
        // Если мы нажали кнопку SAVE
        if (ecd.isSave()) {
            // Получаем контакт из диалогового окна
            Convector cnv = ecd.getConvector();
            if (((Long)cnv.getConvectorId()) != null) {
                // Если ID у конвектора есть, то мы его обновляем
                convectorManager.updateConvector(cnv);
            } else {
                // Если у конвектора нет ID - значит он новый и мы его добавляем
                convectorManager.addConvector(cnv);
            }
            loadConvector();
        }
    }
}

