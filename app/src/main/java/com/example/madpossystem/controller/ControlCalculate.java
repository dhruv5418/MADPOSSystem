package com.example.madpossystem.controller;

import com.example.madpossystem.model.calculate;

public class ControlCalculate {
    private com.example.madpossystem.model.calculate calculate;

    /**
     *constructor.
     */
    public ControlCalculate() {
        super();
    }


    /**
     *create object of calculate class.
     * @param price price of the vehicle
     * @param quantity total quantity.
     */
    public void crateObject(Double price, Integer quantity){

        calculate=new calculate(price,quantity);
    }


    /**
     *call the total method of calculate class
     */
    public void total(){

        calculate.total();
    }

    /**
     * call getTaxes method in calculate class.
     * return tax received from calculate class
     * @return tax
     */
    public Double getTaxes(){

        return calculate.getTaxes();
    }

    /**
     * call getTotal method in calculate class.
     * return total received from calculate class
     * @return
     */
    public Double getTotal(){
        return calculate.getTotal();

    }
}
