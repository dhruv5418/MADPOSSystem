package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.madpossystem.R;
import com.example.madpossystem.controller.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
double pricebeforetaxes;

    public void radioCheckedChanged(View view) {
        RadioButton r4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton r = (RadioButton) findViewById(R.id.radioButton);
        if(r4.isChecked())
        {
            EditText editText = (EditText)findViewById(R.id.editText6);
            editText.setText("25000$");
            pricebeforetaxes=25000;
            editText.setFocusable(false);
        }
        if(r3.isChecked())
        {
            EditText editText = (EditText)findViewById(R.id.editText6);
            editText.setText("10000$");
            pricebeforetaxes=10000;
            editText.setFocusable(false);
        }
        if(r2.isChecked())
        {
            EditText editText = (EditText)findViewById(R.id.editText6);
            editText.setText("9500000$");
            pricebeforetaxes=9500000;
            editText.setFocusable(false);
        }
        if(r.isChecked())
        {
            EditText editText = (EditText)findViewById(R.id.editText6);
            editText.setText("145500$");
            pricebeforetaxes=145500;
            editText.setFocusable(false);
        }


    }

    public void calculation(View view) {

        EditText editText1=(EditText)findViewById(R.id.editText7);
        EditText editText2=(EditText)findViewById(R.id.editText10);
        EditText editText3=(EditText)findViewById(R.id.editText12);
        Integer quantity=Integer.parseInt(editText1.getText().toString());;
        calculate calculate=new calculate(pricebeforetaxes,quantity);
        calculate.total();
        double taxes=calculate.getTaxes();
        double total=calculate.getTotal();
        editText2.setText(BigDecimal.valueOf(taxes).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
        editText2.setFocusable(false);
        editText3.setText(BigDecimal.valueOf(total).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
        editText3.setFocusable(false);

    }

    public void launchSecondActivity(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
