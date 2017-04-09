package com.example.yara.cattlemonitor;

/**
 * Created by YaRa on 4/9/2017.
 */

public class Farm {
    String name;
    String address;
    int numberOfnodes ;

    public Farm ()
    {}

    public Farm(String name , String address , int numberOfnodes)
    {
        this.name = name;
        this.address = address;
        this.numberOfnodes = numberOfnodes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumberOfnodes(int numberOfnodes) {
        this.numberOfnodes = numberOfnodes;
    }
}
