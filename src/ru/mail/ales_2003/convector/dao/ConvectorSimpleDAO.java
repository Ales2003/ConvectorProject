
package ru.mail.ales_2003.convector.dao;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */


public class ConvectorSimpleDAO implements ConvectorDAO {
    
    private final List<Convector> convectors = new ArrayList<Convector>();
    
    @Override
   // добавляем созданный без Id конвектор в метод add
    public Long addConvector(Convector convector) {
        //генерация Id
        Long id = generateConvectorId();
        //добавление Id конвектору
        convector.setConvectorId(id);
        //добавление конветкора в коллекцию
        convectors.add(convector);
        //возвращение Id
        return id;
    }

    @Override
    public void updateConvector(Convector convector) {
        Convector oldConvector = getConvector(convector.getConvectorId());
        if(oldConvector != null) {
            oldConvector.setLength(convector.getLength());
            oldConvector.setWidth(convector.getWidth());
            oldConvector.setDepth(convector.getDepth());
            oldConvector.setPrice(convector.getPrice());
            oldConvector.setPower(convector.getPower());
        }
    }

    @Override
    public void deleteConvector(Long convectorId) {
        //запрашиваем у коллекции итератор "it"; сразу же проверка на наличие следующего (1-го) элемента
        for(Iterator<Convector> it = convectors.iterator(); it.hasNext();) {
            //получаем следующий элемент и записываем в ссылку "cnv"
            Convector cnv = it.next();
            //проверка на идентичность (тот ли Id, что мы ищем), если да, то ...
            if(convectorId.equals(cnv.getConvectorId())) {
            //if(cnv.getConvectorId().equals(convectorId)) {
                //удаляем этот элемент
                it.remove();
            }
        }
    }

    @Override
    public Convector getConvector(Long convectorId) {
        for(Convector convector : convectors) {
            if(convectorId.equals(convector.getConvectorId())) {
                return convector;
            }
        }
        return null;
    }
    
    @Override
    public List<Convector> findConvectors() {
        return convectors;
    }

    private Long generateConvectorId() {
        //генерируем Id
        Long convectorId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        //проверяем, закреплен ли за данным Id некий конвектор(т.е. м.б. данный Id уже занят)
        //т.е. если(цикл while) по Id можно получить конвектор...
        while(getConvector(convectorId) != null) {
        //... генерируем новый Id.
            convectorId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return convectorId;
    }
}
