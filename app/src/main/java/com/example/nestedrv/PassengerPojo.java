package com.example.nestedrv;

public class PassengerPojo {
    int img;
    String name, email, phone;
    public PassengerPojo()
    {
    }
    public PassengerPojo(int img, String name, String email, String phone) {
        this.img = img;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
