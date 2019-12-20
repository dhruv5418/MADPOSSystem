package com.example.madpossystem.controller;

import android.widget.EditText;

import com.example.madpossystem.R;

public class calculate {

private Double price;
private Integer quantity;
private Double taxes;
private Double subtotal;
private Double total;

    public calculate(Double price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
    }
   /* public Double taxes() {
        subtotal=price*quantity;
        taxes=(subtotal)*0.15;
        return taxes;
    }*/

    public Double total(){
        subtotal=price*quantity;
        taxes=(subtotal)*0.15;
        total= subtotal+taxes;
        return total;
    }




    public Double getTaxes() {
        return this.taxes;
    }

    public Double getTotal() {
        return this.total;
    }
}