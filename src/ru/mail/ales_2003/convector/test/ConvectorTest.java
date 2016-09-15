
package ru.mail.ales_2003.convector.test;

import java.util.Collections;
import java.util.List;
import ru.mail.ales_2003.convector.business.ConvectorManager;
import ru.mail.ales_2003.convector.entity.Convector;

/**
 *
 * @author admin
 */


public class ConvectorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        ConvectorManager cm = new ConvectorManager();
        
        Convector c1 = new Convector(1000, 280, 75, 100, 200);
        Convector c2 = new Convector(2000, 280, 75, 195, 400);
        Convector c3 = new Convector(3000, 280, 75, 290, 600);
        Convector c4 = new Convector(1000, 220, 75, 95, 105);
        Convector c5 = new Convector(1000, 220, 100, 100, 107);
 
        System.out.println("ADD CONVECTOR ==============");
        Long cId1 = cm.addConvector(c1);
        Long cId2 = cm.addConvector(c2);
        Long cId3 = cm.addConvector(c3);
        Long cId4 = cm.addConvector(c4);
        Long cId5 = cm.addConvector(c5);
        List<Convector> result1 = cm.findConvectors();
        for(Convector c : result1) {
            System.out.println(c);
        }
        
        System.out.println("UPDATE CONVECTOR ==============");
        Convector change = new Convector(cId1, 1000, 280, 100, 120,250);
        cm.updateConvector(change);
        List<Convector> result2 = cm.findConvectors();
        for(Convector c : result2) {
            System.out.println(c);
        }
        
        System.out.println("DELETE CONVECTOR ==============");
        cm.deleteConvector(cId2);
        List<Convector> result3 = cm.findConvectors();
        for(Convector c : result3) {
            System.out.println(c);
        }
     
 
        System.out.println("GET CONVECTOR ==============");
        Convector convector = cm.getConvector(cId5);
        System.out.println(convector);
        
        /*System.out.println("ORDER CONVECTOR ==============");
        Collections.sort(cm.findConvectors());
        List<Convector> result4 = cm.findConvectors();
        for(Convector c : result4) {
        System.out.println(c);*/
        }
        
    }
    

