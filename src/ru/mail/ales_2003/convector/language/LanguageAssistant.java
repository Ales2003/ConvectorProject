
package ru.mail.ales_2003.convector.language;

import java.util.Locale;
import java.util.PropertyResourceBundle;

/**
 *
 * @author admin
 */
public class LanguageAssistant {
    // Загружаем данные из ресурса, устанавливаем локаль вручную
    public static PropertyResourceBundle pr = (PropertyResourceBundle) PropertyResourceBundle.getBundle("ru.mail.ales_2003.convector.language.languageSelection", new Locale("ru_RU"));    
    
    //названия кнопок для класса ConvectorFrame
    public static String loadLoadButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Обновить", LOAD));
        //Загружаем название кнопки "Обновить"
        String LoadButtonTitle = pr.getString("load.button.title");
        return LoadButtonTitle;
    }
        
    public static String loadAddButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Добавить", ADD));
        //Загружаем название кнопки "Добавить"
        String AddButtonTitle = pr.getString("add.button.title");
        return AddButtonTitle;
    }
    
    public static String loadEditButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Исправить", EDIT));
        //Загружаем название кнопки "Исправить"
        String EditButtonTitle = pr.getString("edit.button.title");
        return EditButtonTitle;
    }
    
    public static String loadDeleteButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Удалить", DELETE));
        //Загружаем название кнопки "Удалить"
        String DeleteButtonTitle = pr.getString("delete.button.title");
        return DeleteButtonTitle;
    }
    
    
    //названия кнопок для класса EditConvectorDialog
    public static String loadSaveButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JButton btnSave = new JButton("СОХРАНИТЬ");
        //Загружаем название кнопки "СОХРАНИТЬ"
        String SaveButtonTitle = pr.getString("save.button.title");
        return SaveButtonTitle;
    }
    
    public static String loadCancelButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JButton btnCancel = new JButton("ОТМЕНА");
        //Загружаем название кнопки "ОТМЕНА"
        String CancelButtonTitle = pr.getString("cancel.button.title");
        return CancelButtonTitle;
    }
    
    
        //названия столбцов для класса ConvectorModel
     public static String loadLengthRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Длина"
        String LengthRowTitle = pr.getString("length.row.title");
        return LengthRowTitle;
    }
     
     public static String loadWidthhRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Ширина"
        String WidthhRowTitle = pr.getString("width.row.title");
        return WidthhRowTitle;
    }
     
     public static String loadDepthRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Глубина"
        String DepthRowTitle = pr.getString("depth.row.title");
        return DepthRowTitle;
    }
    
     public static String loadPriceRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Цена"
        String PriceRowTitle = pr.getString("price.row.title");
        return PriceRowTitle;
    }
     
     public static String loadPowerRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Мощность"
        String PowerRowTitle = pr.getString("power.row.title");
        return PowerRowTitle;
    }  
     
     
        //названия меток для класса EditConvectorDialog
     public static String loadLengthLabelTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JLabel lblLength = new JLabel("Длина:");
        //Загружаем название метки "Длина:"
        String LengthRowTitle = pr.getString("length.label.title");
        return LengthRowTitle;
    }
     
     public static String loadWidthhLabelTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JLabel lblWidth = new JLabel("Ширина:");
        //Загружаем название метки "Ширина:"
        String WidthhRowTitle = pr.getString("width.label.title");
        return WidthhRowTitle;
    }
     
     public static String loadDepthLabelTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JLabel lblDepth = new JLabel("Глубина:");
        //Загружаем название метки "Глубина:"
        String DepthRowTitle = pr.getString("depth.label.title");
        return DepthRowTitle;
    }
    
     public static String loadPriceLabelTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //JLabel lblPrice = new JLabel("Цена:");
        //Загружаем название метки "Цена:"
        String PriceRowTitle = pr.getString("price.label.title");
        return PriceRowTitle;
    }
     
     public static String loadPowerLabelTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JLabel lblPower = new JLabel("Мощность:");
        //Загружаем название метки "Мощность:"
        String PowerRowTitle = pr.getString("power.label.title");
        return PowerRowTitle;
    }
    
    
        //сообщения о некорректном способе редактирования или удаления для класса ConvectorFrame
     public static String loadIncorrectEditMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования");
        //Загружаем текст сообщения "Вы должны выделить строку для редактирования"
        String IncorrectEditMessage = pr.getString("incorrect.edit.message");
        return IncorrectEditMessage;
    }
     
     public static String loadIncorrectDeleteMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления");
        //Загружаем текст сообщения "Вы должны выделить строку для удаления"
        String IncorrectDeleteMessage = pr.getString("incorrect.delete.message");
        return IncorrectDeleteMessage;
    }
     
     
     
        //сообщения о некорректном вводе параметров для класса EditConvectorDialog
     public static String loadIncorrectInputLengthMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JOptionPane.showMessageDialog(this, "Вы ввели длину в неправильном формате, пожалуста, исправьте");
        //Загружаем текст сообщения "Вы ввели длину в неправильном формате, пожалуста, исправьте"
        String IncorrectInputLengthMessage = pr.getString("incorrect.input.length.message");
        return IncorrectInputLengthMessage;
    }
     
     public static String loadIncorrectInputWidthMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JOptionPane.showMessageDialog(this, "Вы ввели ширину в неправильном формате, пожалуста, исправьте");
        //Загружаем текст сообщения "Вы ввели ширину в неправильном формате, пожалуста, исправьте"
        String IncorrectInputWidthMessage = pr.getString("incorrect.input.width.message");
        return IncorrectInputWidthMessage;
    }
     
     public static String loadIncorrectInputDepthMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JOptionPane.showMessageDialog(this, "Вы ввели глубину в неправильном формате, пожалуста, исправьте");
        //Загружаем текст сообщения "Вы ввели глубину в неправильном формате, пожалуста, исправьте"
        String IncorrectInputDepthMessage = pr.getString("incorrect.input.depth.message");
        return IncorrectInputDepthMessage;
    }
    
      public static String loadIncorrectInputPriceMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JOptionPane.showMessageDialog(this, "Вы ввели цену в неправильном формате, пожалуста, исправьте");
        //Загружаем текст сообщения "Вы ввели цену в неправильном формате, пожалуста, исправьте"
        String IncorrectInputPriceMessage = pr.getString("incorrect.input.price.message");
        return IncorrectInputPriceMessage;
    }
    
     public static String loadIncorrectInputPowerMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.EditConvectorDialog
        //вместо: JOptionPane.showMessageDialog(this, "Вы ввели мощность в неправильном формате, пожалуста, исправьте");
        //Загружаем текст сообщения "Вы ввели мощность в неправильном формате, пожалуста, исправьте"
        String loadIncorrectInputPowerMessage = pr.getString("incorrect.input.power.message");
        return loadIncorrectInputPowerMessage;
    }
    
    
}
