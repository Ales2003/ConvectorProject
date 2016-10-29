
package ru.mail.ales_2003.convector.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
// класс для хранения данных о конвекторах

public class Convector //implements Comparable <Convector> 
    {
    // идентификатор конвектора
    private Long convectorId;
    // длина
    private Integer length;
    // ширина
    private Integer width;
    // глубина
    private Integer depth;
    // цена
    private Integer price;
    //мощность
    private Integer power;
     //мощность
    
    /*
    @Override
    public int compareTo(Convector c) {
    return length.compareTo(c.getLength());
    }
    */
    
    
    public Convector() {
    }

    public Convector(Long convectorId, Integer length, Integer width, Integer depth, Integer price, Integer power) {
        this.convectorId = convectorId;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.price = price;
        this.power = power;
    }

    public Convector(Integer length, Integer width, Integer depth, Integer price, Integer power) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.price = price;
        this.power = power;
    }

    public Convector(ResultSet rs) throws SQLException {
        setConvectorId(rs.getLong(1));
        setLength(rs.getInt(2));
        setWidth(rs.getInt(3));
        setDepth(rs.getInt(4));
        setPrice(rs.getInt(5));
        setPower(rs.getInt(6));
    }
    
    
    public Long getConvectorId() {
        return convectorId;
    }

    public void setConvectorId(Long convectorId) {
        this.convectorId = convectorId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    

    
    
    @Override
    public String toString() {
        return "Convector{" + "convectorId=" + convectorId + ", length=" + length + " мм, width=" + width + " мм, depth=" + depth + " мм, price=" + price + " евро, power=" + power + " Вт}";
    }
   
 
    
}
