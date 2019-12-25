package com.example.madpossystem.model;

import android.widget.EditText;

import com.example.madpossystem.R;

public class calculate {

private Double price;
private Integer quantity;
private Double taxes;
private Double subtotal;
private Double total;

    /**
     *
     * @param price
     * @param quantity
     */
    public calculate(Double price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public Double total(){
        subtotal=price*quantity;
        taxes=(subtotal)*0.15;
        total= subtotal+taxes;
        return total;
    }


    /**
     *
     * @return
     */
    public Double getTaxes() {
        return this.taxes;
    }

    /**
     *
     * @return
     */
    public Double getTotal() {
        return this.total;
    }
}