
package ru.mail.ales_2003.convector.dao;

import java.util.List;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */
//Интерфейс для определения функций хранения данных о конвекторах

public interface ConvectorDAO {
    // Добавление конвектора - возвращает ID добавленного конвектора
    public Long addConvector(Convector convector);
    // Редактирование конвектора
    public void updateConvector(Convector convector);
    // Удаление конвектора по его ID
    public void deleteConvector(Long convectorId);
    // Получение конвектора
    public Convector getConvector(Long convectorId);
    // Получение списка конвекторов
    public List<Convector> findConvectors();
    
}
