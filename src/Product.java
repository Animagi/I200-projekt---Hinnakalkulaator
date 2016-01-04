import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by Anto on 02/01/2016.
 */
public class Product {

    private String name;
    private double material;
    private double laser;
    private double netPrice;

    public Product(){
        this.name = "";
        this.material = 0;
        this.laser = 0;
        this.netPrice = getMaterial() + getLaser();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaterial() {
        return material;
    }

    public void setMaterial(double material) {
        this.material = material;
    }

    public double getLaser() {
        return laser;
    }

    public void setLaser(double laser) {
        this.laser = laser;
    }

    public double getNetPrice() {
        return material + laser;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = material + laser;
    }

    public Product(String name, double material, double laser, double netPrice){
        this.name = name;
        this.material = material;
        this.laser = laser;
        this.netPrice = material + laser;
    }


}
