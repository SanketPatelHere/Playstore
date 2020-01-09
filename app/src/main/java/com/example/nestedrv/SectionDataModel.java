package com.example.nestedrv;

import java.util.ArrayList;

public class SectionDataModel {
    String headerTitle;
    ArrayList<LocationPojo> allItemsInLocation;  //date, address, addressNote
    ArrayList<PassengerPojo> allItemsInPassenger;  //img, name, email, phone
    ArrayList<OtherDetailsPojo> allItemsOtherDetails;  //imgDetail, detailName, detailInfo
    ArrayList<DriverPojo> allItemsInDriver;  //imgDriver, driverName, businessType, number
    ArrayList<SingleItemModel> allItemsInSection;  //name ////, url, description
    public SectionDataModel()
    {
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;  //name set
    }

    public ArrayList<LocationPojo> getAllItemsInLocation() {
        return allItemsInLocation;
    }

    public void setAllItemsInLocation(ArrayList<LocationPojo> allItemsInLocation) {
        this.allItemsInLocation = allItemsInLocation;
    }

    public ArrayList<PassengerPojo> getAllItemsInPassenger() {
        return allItemsInPassenger;
    }

    public void setAllItemsInPassenger(ArrayList<PassengerPojo> allItemsInPassenger) {
        this.allItemsInPassenger = allItemsInPassenger;
    }

    public ArrayList<DriverPojo> getAllItemsInDriver() {
        return allItemsInDriver;
    }

    public void setAllItemsInDriver(ArrayList<DriverPojo> allItemsInDriver) {
        this.allItemsInDriver = allItemsInDriver;
    }

    public ArrayList<OtherDetailsPojo> getAllItemsOtherDetails() {
        return allItemsOtherDetails;
    }

    public void setAllItemsOtherDetails(ArrayList<OtherDetailsPojo> allItemsOtherDetails) {
        this.allItemsOtherDetails = allItemsOtherDetails;
    }
}
