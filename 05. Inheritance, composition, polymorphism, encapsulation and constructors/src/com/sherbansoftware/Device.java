package com.sherbansoftware;

/**
 * Created by Mihai Serban on 6/18/2017.
 * Generic class Device
 */
public class Device implements IPolymorphicDevice {
    private String internalProcessor;
    private String powerStatus;

    public Device(String internalProcessor, String powerStatus) {
        this.internalProcessor = internalProcessor;
        this.powerStatus = powerStatus;
    }

    @Override
    public String showPolymorphism(){
        return getClass().toString();
    }

    public Device getFactoryInstance(){
        return IPolymorphicDevice.getFactoryInstance();
    }

    public Device getDeviceDefaultImplementation(){
        Device usualDevice = new Device("123 Ghz", "Off");
        Device defaultDevice = usualDevice.getDefaultImplementation();
        return defaultDevice;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public String getInternalProcessor() {
        return internalProcessor;
    }

    public void setInternalProcessor(String internalProcessor) {
        this.internalProcessor = internalProcessor;
    }
}
