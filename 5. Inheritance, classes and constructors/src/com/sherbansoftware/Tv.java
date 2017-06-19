package com.sherbansoftware;

/**
 * Created by Mihai Serban on 6/17/2017.
 * <p>
 * In Java all things are objects.
 * Just looking around I can see that my room contains a lot of real world objects.
 * For example: I can see a: wardrobe, bed, television, laptop, computer, mouse etc.
 * Each object it's defined by 2 major characteristics: actual state and object behavior.
 * I chose to represent in a Java class a Tv which is a television.
 * A Java class is just a template or a blueprint for creating objects.
 * An object store his state in fields.  * An object may have hundred of fields but for simplicity I chose to present only 3 fields.
 * An object expose his behavior with methods
 * Tv extends Device which makes Tv a special object of a Device class
 * A Tv is also a Device.
 */
public class Tv extends Device implements Cloneable {
    //encapsulation hide the fields and methods from public access.
    //The internal representation of an object is hidden from outside
    //State of a Tv object, extra fields
    private String brand = "Samsung";
    private Resolution resolution = new Resolution(1920, 1080); //Early, instance will be created at class load time
    private Screen screen;

    private String location;  //extra object state which does not depend on the creation of object

    //overloading constructors
    // constructor which initializes 3 object's param
    public Tv(String brand, Resolution resolution, Screen screen) {
        super("768 Mhz", "Turned off");
        this.brand = brand;
        this.resolution = resolution;
        this.screen = screen;
        this.location = "Bedroom";
    }

    public Tv(String brand, Resolution resolution, Screen screen, String internalProcessor, String powerStatus) {
        super(internalProcessor, powerStatus);
        this.brand = brand;
        this.resolution = resolution;
        this.screen = screen;
    }

    //constructor calling another constructor using this
    public Tv() {
        this(null, null, null); //must be first line
        System.out.println("Empty constructor called");
    }

    //constructor which initializes 1 object's param
    public Tv(Screen screen) {
        super("768 Mhz", "Turned off"); //call the super constructor
        this.screen = screen;
    }

    //getter for objects
    public String getBrand() {
        return brand;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public Screen getScreen() {
        return screen;
    }

    //setter for objects. Updates the state of an object.
    //the methods are public, can be accessed from outside class
    //these methods updates the object fields with the content of passed parameters
    public void setBrand(String brand) {
        String validBrand = brand.toLowerCase();
        if (validBrand.equals("samsung"))
            this.brand = brand;  //this keyword - current object
        else
            System.out.println("The Tv was not found");
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    //behavior of an object
    //protected method
    // This kind of method can be viewed by:
    // - objects inside this class
    // - objects outside this class but in the same package
    // - objects outside this class, outside this package but only by subclasses through inheritance
    protected void turnOn() {
        super.setPowerStatus("Turned on");
        System.out.println("Tv: " + getBrand() + " with Resolution: " + getResolution().getHeight() + " x " + getResolution().getWeight() + ", Screen size: " + getScreen().getSize() + " Processor: " + super.getInternalProcessor() + " is: " + super.getPowerStatus());
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //default access modifier. visible within the class and inside the package
    void turnOff() {
        System.out.println("Tv: " + getBrand() + " with Resolution: " + getResolution().getHeight() + " x " + getResolution().getWeight() + ", Screen size: " + getScreen().getSize() + " Processor: " + super.getInternalProcessor() + " is: " + super.getPowerStatus());
    }

    @Override
    public String getPowerStatus() {
        return super.getPowerStatus();
    }

    @Override
    public void setPowerStatus(String powerStatus) {
        super.setPowerStatus(powerStatus);
    }

    @Override
    public String getInternalProcessor() {
        return super.getInternalProcessor();
    }

    @Override
    public void setInternalProcessor(String internalProcessor) {
        super.setInternalProcessor(internalProcessor);
    }

    //private access modifier. visible within the class
    private void smartTv() {
        System.out.println("Smart TV enabled");
    }

    //clones the object. super keyword access the parent method
    public Object getClone() throws CloneNotSupportedException {
        smartTv(); //assume we start smartTv when clone (just for exercise)
        setLocation("Living room"); //set another state for this object
        return super.clone();  //call parent method
    }

}
