package com.example.nestedrv;

public class LocationPojo
{
    String date; //"12 july 19 | 01:28 AM";
    String address; //One Pace Plaza, New York, NY 10038, United States
    //578 Devonshire Rd
    //55 Board St, New York, NY 10004, USA
    //88 Pine St, New York, NY 10005, USA
    String addressNote; //Lorem Ipsum...

    public LocationPojo(String date, String address, String addressNote) {
        this.date = date;
        this.address = address;
        this.addressNote = addressNote;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNote() {
        return addressNote;
    }

    public void setAddressNote(String addressNote) {
        this.addressNote = addressNote;
    }

}
