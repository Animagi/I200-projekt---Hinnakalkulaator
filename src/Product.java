import javafx.beans.property.SimpleDoubleProperty;

import java.text.DecimalFormat;

/**
 * Created by Anto on 02/01/2016.
 */
public class Product {

    private String name;
    private double material;
    private double laser;
    private double bending;
    private double welding;
    private double assembling;
    private double netPrice;
    private double VAT;
    private double sellPrice;
    //private Config config;

    public Product(/*Config config*/){
        this.name = "";
        this.material = 0;
        this.laser = 0;
        this.bending = 0;
        this.assembling = 0;
        this.netPrice = 0;
        this.VAT = 0;
        this.sellPrice = 0;
        //this.config = config;
    }


    private static String numberFormat(double number) { //Making double to string to show only two decimal places
        return String.format("%.2f", number);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return numberFormat(material*0.8);
    }

    public void setMaterial(double material) {
        this.material = material;
    }

    public String getLaser() {
        return numberFormat(laser*0.05);
    }

    public void setLaser(double laser) {
        this.laser = laser;
    }

    public String getBending() {
        return numberFormat(bending*0.01);
    }

    public void setBending(double bending) {
        this.bending = bending;
    }

    public String getWelding() {
        return numberFormat(welding*0.015);
    }

    public void setWelding(double welding) {
        this.welding = welding;
    }

    public String getAssembling() {
        return numberFormat(assembling*0.06);
    }

    public void setAssembling(double assembling) {
        this.assembling = assembling;
    }

    public String getNetPrice() {
        return numberFormat(material*0.8 + laser*0.05 + bending*0.01 + welding*0.015 + assembling*0.06);
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public String getVAT() {
        return numberFormat((material * 0.8 + laser * 0.05 + bending * 0.01 + welding *0.015 + assembling * 0.06) * 0.2);
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public String getSellPrice() {
        return numberFormat((material * 0.8 + laser * 0.05 + bending *0.01 + welding *0.015 + assembling * 0.06) * 1.2);
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Product(String name, double material, double laser, double netPrice, double bending, double welding, double assembling, double VAT, double sellPrice){
        this.name = name;
        this.material = material;
        this.laser = laser;
        this.netPrice = material + laser + bending + welding + assembling;
        this.bending = bending;
        this.welding = welding;
        this.assembling = assembling;
        this.VAT = VAT;
        this.sellPrice = sellPrice;
    }


}
