package com.example.yara.cattlemonitor;

import java.security.PublicKey;

/**
 * Created by YaRa on 4/9/2017.
 */

public class User
{
    String name;
    String email;
    String phoneNumber;
    String farmName;
    String type;

    public User(){}

    public User(String name, String email, String phoneNumber , String farmName , String type)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.farmName = farmName;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }
}
