package com.example.nestedrv;

public class DriverPojo {
    int imgDriver;
    String driverName, businnesType, number;
    public DriverPojo()
    {
    }
    public DriverPojo(int imgDriver, String driverName, String businnesType, String number) {
        this.imgDriver = imgDriver;
        this.driverName = driverName;
        this.businnesType = businnesType;
        this.number = number;
    }

    public int getImgDriver() {
        return imgDriver;
    }

    public void setImgDriver(int imgDriver) {
        this.imgDriver = imgDriver;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusinnesType() {
        return businnesType;
    }

    public void setBusinnesType(String businnesType) {
        this.businnesType = businnesType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
