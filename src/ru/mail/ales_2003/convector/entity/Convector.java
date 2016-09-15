
package ru.mail.ales_2003.convector.entity;

/**
 *
 * @author admin
 */
// класс для хранения данных о конвекторах

public class Convector //implements Comparable <Convector> 
    {
    // идентификатор конвектора
    private long convectorId;
    // длина
    private int length;
    // ширина
    private int width;
    // глубина
    private int depth;
    // цена
    private int price;
    //мощность
    private int power;
     //мощность
    
    /*
    @Override
    public int compareTo(Convector c) {
    return length.compareTo(c.getLength());
    }
    */
    
    
    public Convector() {
    }

    public Convector(long convectorId, int length, int width, int depth, int price, int power) {
        this.convectorId = convectorId;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.price = price;
        this.power = power;
    }

    public Convector(int length, int width, int depth, int price, int power) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.price = price;
        this.power = power;
    }

    public long getConvectorId() {
        return convectorId;
    }

    public void setConvectorId(long convectorId) {
        this.convectorId = convectorId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    

    
    
    @Override
    public String toString() {
        return "Convector{" + "convectorId=" + convectorId + ", length=" + length + " мм, width=" + width + " мм, depth=" + depth + " мм, price=" + price + " евро, power=" + power + " Вт}";
    }
   
 
    
}
