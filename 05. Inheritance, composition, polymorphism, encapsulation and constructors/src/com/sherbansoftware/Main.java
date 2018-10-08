package com.sherbansoftware;

public class Main {

    private static int valueForRaceConditions;

    /**
     * This is the entry point for a Java program.
     * In a Java program, the JVM goes directly and searches for a main method in order to execute it.
     */

    public static synchronized void increment(){
        valueForRaceConditions++;
    }

    public static void main(String[] args) throws InterruptedException {
        //using lambda for functional runnable interface
        Thread thread = new Thread(() -> {
            //simulate Mihai Serban's bedroom
            Room bedroom = new Room("Mihai Serban", new Tv());
            String tv = bedroom.getName();
            System.out.println("TV is: " + tv);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Inside main method we define an original TV object based on a class (template for creating Java objects).
            Tv samsung = new Tv(new Screen("LCD"));
            samsung.turnOn();
            Device device = new Device("2014 Mhz", "Off ");
            samsung = new Tv("Samsung", new Resolution(1920, 1080), new Screen("Ultra HD"));
            samsung.turnOff();
            Resolution resolution = new Resolution(1920, 1080);
            Screen screen = new Screen("HD ready");
            samsung = new Tv("Samsung", resolution, screen, device.getInternalProcessor(), device.getPowerStatus());
            samsung.turnOn();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Device factoryDevice = device.getFactoryInstance();
            System.out.println("Default processor is: " + factoryDevice.getInternalProcessor());
            factoryDevice = factoryDevice.getDeviceDefaultImplementation();
            System.out.println(factoryDevice.getInternalProcessor());

            String type = samsung.getScreen().getType(); //access a particular screen attribute using the Tv object.
            samsung.getScreen().setType("Q" + type); //Method chaining

        /*
        instanceof operator is used to test whether the object is an instance
        of the specified class or subclass or interface
        */
            //polymorphism example
            if (type instanceof String) {
                type = device.showPolymorphism();
                System.out.println(type);
                type = samsung.showPolymorphism();
                System.out.println(type);
            }

            // Tv class implements Cloneable interface to avoid CloneNotSupportedException being thrown
            // define a cloned object
            Tv samsungCloned = null;
            try {
                samsungCloned = (Tv) samsung.getClone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            samsungCloned.turnOff();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Screen fullHd = new Screen("Full HD");
            samsungCloned.setScreen(fullHd);
            System.out.println("Samsung cloned object has a screen with a new type of screen: " + samsungCloned.getScreen().getType() + " ");
            samsungCloned.turnOff();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Engine engine = new Engine("AGH model", "Volkswagen", 1888);
            Door door = new Door(4);
            Car car = new Car("Golf 4", engine, door, 4);
            car.startVehicle();
            car.stopVehicle();

            //handle checkType
            try {
                boolean value = Vehicle.checkType(car, "com.sherbansoftware.Car");
                System.out.println("value is: " + value);
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage() + " " + e.getCause());
            }
        });

        thread.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
                System.out.println("valueForRaceConditions count in " + Thread.currentThread().getName() + " is: " + valueForRaceConditions);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
                System.out.println("valueForRaceConditions count in " + Thread.currentThread().getName() + " is: " + valueForRaceConditions);
            }
        });

        //Java synchronized keyword can be used to avoid race conditions.
        t1.start();
        t2.start();

        //wait for threads to finish
        t1.join();
        t2.join();

        System.out.println("valueForRaceConditions count after join is: " + valueForRaceConditions);
    }


}
