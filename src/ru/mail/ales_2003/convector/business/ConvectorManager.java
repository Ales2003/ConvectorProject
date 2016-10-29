
package ru.mail.ales_2003.convector.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.mail.ales_2003.convector.dao.ConvectorDAO;
import ru.mail.ales_2003.convector.dao.ConvectorDAOFactory;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */

//Класс для реализации функций над классом Convector

public class ConvectorManager {
     private ConvectorDAO dao;
    
    public ConvectorManager()  {
         try {
             dao = ConvectorDAOFactory.getConvectorDAO();
         } catch (Exception ex) {
             Logger.getLogger(ConvectorManager.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    // Добавление конвектора - возвращает ID добавленного конвектора
    public Long addConvector(Convector convector) {
        return dao.addConvector(convector);
    }
    
    // Редактирование конвектора
    public void updateConvector(Convector convector) {
        dao.updateConvector(convector);
    }

    // Удаление конвектора по его ID
    public void deleteConvector(Long convectorId) {
        dao.deleteConvector(convectorId);
    }

    // Получение одного конвектора
    public Convector getConvector(Long convectorId) {
        return dao.getConvector(convectorId);
    }
    
    // Получение списка конвекторов
    public List<Convector> findConvectors() {
        return dao.findConvectors();
    }
    
    
    
}
