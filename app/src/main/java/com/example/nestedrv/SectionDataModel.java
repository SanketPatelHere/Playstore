package com.example.nestedrv;

import java.util.ArrayList;

public class SectionDataModel {
    String headerTitle;
    ArrayList<LocationPojo> allItemsInLocation;
    ArrayList<SingleItemModel> allItemsInSection;  //name, url, description
    public SectionDataModel()
    {
    }
    public SectionDataModel(String headerTitle, ArrayList<SingleItemModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }

    public SectionDataModel(ArrayList<LocationPojo> allItemsInLocation2) {
        this.allItemsInLocation = allItemsInLocation2;
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
        this.allItemsInSection = allItemsInSection;
    }

    public ArrayList<LocationPojo> getAllItemsInLocation() {
        return allItemsInLocation;
    }

    public void setAllItemsInLocation(ArrayList<LocationPojo> allItemsInLocation) {
        this.allItemsInLocation = allItemsInLocation;
    }
}
