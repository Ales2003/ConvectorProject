
package ru.mail.ales_2003.convector.dao;

import java.util.List;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */
//Интерфейс для определения функций хранения данных о конвекторах

public interface ConvectorDAO {
    // Добавление контакта - возвращает ID добавленного контакта
    public Long addConvector(Convector convector);
    // Редактирование контакта
    public void updateConvector(Convector convector);
    // Удаление контакта по его ID
    public void deleteConvector(Long convectorId);
    // Получение контакта
    public Convector getConvector(Long convectorId);
    // Получение списка контактов
    public List<Convector> findConvectors();
    
}
