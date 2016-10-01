
package ru.mail.ales_2003.convector.propertys;

import java.util.Locale;
import java.util.PropertyResourceBundle;

/**
 *
 * @author admin
 */
public class LanguageSelection {
    // Загружаем данные из ресурса
    public static PropertyResourceBundle pr = (PropertyResourceBundle) PropertyResourceBundle.getBundle("ru.mail.ales_2003.convector.propertys.languageSelection", new Locale("ru_RU"));
    
    //для класса ConvectorFrame
    public static String loadGuiCfLoadButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Обновить", LOAD));
        //Загружаем название кнопки "Обновить"
        String LoadButtonTitle = pr.getString("gui.cf.load.button.title");
        return LoadButtonTitle;
    }
        
    public static String loadGuiCfAddButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Добавить", ADD));
        //Загружаем название кнопки "Добавить"
        String AddButtonTitle = pr.getString("gui.cf.add.button.title");
        return AddButtonTitle;
    }
    
    public static String loadGuiCfEditButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Исправить", EDIT));
        //Загружаем название кнопки "Исправить"
        String EditButtonTitle = pr.getString("gui.cf.edit.button.title");
        return EditButtonTitle;
    }
    
    public static String loadGuiCfDeleteButtonTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: btnPanel.add(createButton(gridbag, gbc, "Удалить", DELETE));
        //Загружаем название кнопки "Удалить"
        String DeleteButtonTitle = pr.getString("gui.cf.delete.button.title");
        return DeleteButtonTitle;
    }
    
     public static String loadGuiCfWrongEditMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования");
        //Загружаем текст сообщения "Вы должны выделить строку для редактирования"
        String WrongEditMessageText = pr.getString("gui.cf.wrong.edit.message");
        return WrongEditMessageText;
    }
     
     public static String loadGuiCfWrongDeleteMessage () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ConvectorFrame
        //вместо: JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления");
        //Загружаем текст сообщения "Вы должны выделить строку для удаления"
        String WrongeleteMessageText = pr.getString("gui.cf.wrong.delete.message");
        return WrongeleteMessageText;
    }
     
     //для класса ContactModel
     public static String loadGuiCmLengthRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ContactModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Длина"
        String LengthRowTitle = pr.getString("gui.cm.length.row.title");
        return LengthRowTitle;
    }
     
     public static String loadGuiCmWidthRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ContactModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Ширина"
        String WidthhRowTitle = pr.getString("gui.cm.width.row.title");
        return WidthhRowTitle;
    }
     
     public static String loadGuiCmDepthRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ContactModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Глубина"
        String DepthRowTitle = pr.getString("gui.cm.depth.row.title");
        return DepthRowTitle;
    }
    
     public static String loadGuiCmPriceRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ContactModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Цена"
        String PriceRowTitle = pr.getString("gui.cm.price.row.title");
        return PriceRowTitle;
    }
     
     public static String loadGuiCmPowerRowTitle () {
        //место использования метода: package ru.mail.ales_2003.convector.gui.ContactModel
        //вместо: private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
        //Загружаем название столбца "Мощность"
        String PowerRowTitle = pr.getString("gui.cm.power.row.title");
        return PowerRowTitle;
    }
     
     
     //для класса EditConvectorDialog
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
