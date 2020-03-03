package com.example.madpossystem.model;


public class calculate {

    /**
     * store the price
     */
    private Double price;
    /**
     * store the quantity
     */
    private Integer quantity;
    /**
     * store the taxes
     */
    private Double taxes;
    /**
     * store the subtotal
     */
    private Double subtotal;
    /**
     * store the total
     */
    private Double total;

    /**
     * constructor
     * @param price
     * @param quantity
     */
    public calculate(Double price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * calculate taxes and total.
     * @return total.
     */
    public Double total(){
        subtotal=price*quantity;
        taxes=(subtotal)*0.15;
        total= subtotal+taxes;
        return total;
    }


    /**
     * return tax.
     * @return
     */
    public Double getTaxes() {
        return this.taxes;
    }

    /**
     * return total.
     * @return
     */
    public Double getTotal() {
        return this.total;
    }
}