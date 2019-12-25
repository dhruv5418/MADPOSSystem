package com.example.madpossystem.model;

import com.example.madpossystem.model.calculate;

import org.junit.Test;

import static org.junit.Assert.*;

public class calculateTest {
    com.example.madpossystem.model.calculate calculate=new calculate(10000.0,1);


       private Double total=(Double)11500.0;

    /**
     *
     * @throws Exception
     */
    @Test
    public void total()  throws Exception{
       assertEquals(total,calculate.total());
    }
}