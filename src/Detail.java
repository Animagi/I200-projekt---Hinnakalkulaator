/**
 * Created by Anto on 02/01/2016.
 */
public class Detail {

    private String name;
    private double material;
    private int laser;
    private int bending;
    private int welding;
    private int grinding;
    private int machining;
    private double yield;
    private double VAT;

    public Detail(){
        this.name = "0";
        this.material = 0;
        this.laser = 0;
        this.bending = 0;
        this.welding = 0;
        this.grinding = 0;
        this.machining = 0;
        this.yield = 0;
        this.VAT = 0;




    }

    public Detail(String name, double material, int laser, int bending, int welding, int grinding, int machining, int yield, double VAT){
        this.name = name;
        this.material = material;
        this.laser = laser;
        this.bending = bending;
        this.welding = welding;
        this.grinding = grinding;
        this.machining = machining;
        this.yield = yield;
        this.VAT = VAT;
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

    public int getLaser() {
        return laser;
    }

    public void setLaser(int laser) {
        this.laser = laser;
    }

    public int getBending() {
        return bending;
    }

    public void setBending(int bending) {
        this.bending = bending;
    }

    public int getWelding() {
        return welding;
    }

    public void setWelding(int welding) {
        this.welding = welding;
    }

    public int getGrinding() {
        return grinding;
    }

    public void setGrinding(int grinding) {
        this.grinding = grinding;
    }

    public int getMachining() {
        return machining;
    }

    public void setMachining(int machining) {
        this.machining = machining;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }
}
