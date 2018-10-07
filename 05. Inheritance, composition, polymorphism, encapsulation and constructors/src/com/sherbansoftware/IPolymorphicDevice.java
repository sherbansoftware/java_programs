package com.sherbansoftware;

/*
- contains only abstract methods
- contain only constant variables
- no need to use public abstract for methods
 */
public interface IPolymorphicDevice {
    // what contract
    String showPolymorphism();

    static Device getFactoryInstance(){ //for java 8
        return new Device("200 Ghz Factory", "On");
    }

    default Device getDefaultImplementation(){ //for java 8
        return getPrivateDevice();
    }

    private Device getPrivateDevice(){ //for java 9
        return new Device("200 Ghz by default", "On");
    }

}
