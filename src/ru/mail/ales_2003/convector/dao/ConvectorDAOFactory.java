
package ru.mail.ales_2003.convector.dao;

/**
 *
 * @author admin
 */
//Фабрика для создания экземпляра ConvectorDAO

public class ConvectorDAOFactory {
       
    public static ConvectorDAO getConvectorDAO() throws Exception {
        return new ConvectorSimpleDAO();
        //return new ConvectorDBDao();
    }
}
