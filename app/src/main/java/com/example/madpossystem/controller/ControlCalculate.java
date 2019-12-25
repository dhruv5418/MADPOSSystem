package com.example.madpossystem.controller;

import com.example.madpossystem.model.calculate;

public class ControlCalculate {
    private com.example.madpossystem.model.calculate calculate;

    /**
     *
     */
    public ControlCalculate() {
        super();
    }


    /**
     *
     * @param price
     * @param quantity
     */
    public void crateObject(Double price, Integer quantity){

        calculate=new calculate(price,quantity);
    }


    /**
     *
     */
    public void total(){

        calculate.total();
    }

    /**
     *
     * @return
     */
    public Double getTaxes(){

        return calculate.getTaxes();
    }

    /**
     *
     * @return
     */
    public Double getTotal(){
        return calculate.getTotal();

    }
}
