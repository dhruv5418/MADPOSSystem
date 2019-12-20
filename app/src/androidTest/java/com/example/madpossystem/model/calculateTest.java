package com.example.madpossystem.model;

import com.example.madpossystem.controller.calculate;

import org.junit.Test;

import static org.junit.Assert.*;

public class calculateTest {
    com.example.madpossystem.controller.calculate calculate=new calculate(10000.0,1);

        private Double taxes= (Double) 1500.0;
       private Double total=(Double)11500.0;


/* @Test
    public void taxes()  throws Exception{
        assertEquals(taxes,calculate.taxes(),(double)0.0);
    }*/
    @Test
    public void total()  throws Exception{
       assertEquals(total,calculate.total());
    }
}