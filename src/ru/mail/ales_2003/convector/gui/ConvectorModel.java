
package ru.mail.ales_2003.convector.gui;

import static java.lang.Integer.valueOf;
import static java.lang.Long.valueOf;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * Model
 */
public class ConvectorModel extends AbstractTableModel
{
    // Список загловков для колонок в таблице
    private static final String[] headers = {"ID", "Длина", "Ширина", "Глубина", "Цена", "Мощность"};
    
    // Здесь мы храним список конвекторов, которые будем отображать в таблице
    private final List<Convector> convectors;

    public ConvectorModel(List<Convector> convectors) {
        this.convectors = convectors;
    }
    
    @Override
    // Получить количество строк в таблице - у нас это размер коллекции
    public int getRowCount() {
        return convectors.size();
    }

    @Override
    // Получить количество столбцов - их у нас стольк же, сколько полей
    // у класса Convector - всего шесть, можно сослаться на длину массива headers
    public int getColumnCount() {
        //return 6;
        return headers.length;
        
    }

    @Override
    // Вернуть загловок колонки - мы его берем из массива headers
    public String getColumnName(int col) {
        return headers[col];
    }
    
    @Override
    // Получить объект для тображения в кокнретной ячейке таблицы
    // В данном случае мы отдаем строковое представление поля
    public Object getValueAt(int row, int col) {
        Convector convector = convectors.get(row);
        // В зависимости от номера колонки возвращаем то или иное поле конвектора
        switch (col) {
            case 0:
                return Long.valueOf(convector.getConvectorId());
            case 1:
                return Integer.toString(convector.getLength());
            case 2:
                return Integer.toString(convector.getWidth());
            case 3:
                return Integer.toString(convector.getDepth());
            case 4:
                return Integer.toString(convector.getPrice());
            default:
                return Integer.toString(convector.getPower());
        }
    }
}
