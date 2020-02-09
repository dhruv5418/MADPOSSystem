package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.madpossystem.R;
import com.example.madpossystem.controller.ControlCalculate;
import com.example.madpossystem.model.calculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

double priceBeforeTaxes;

    /**
     *
     * @param view
     */
    public void radioCheckedChanged(View view) {
        RadioButton r4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton r = (RadioButton) findViewById(R.id.radioButton);
        EditText editText = (EditText)findViewById(R.id.editText6);
        EditText editText1=(EditText)findViewById(R.id.editText7);
        editText1.setFocusableInTouchMode(true);
        if(r4.isChecked())
        {
            editText.setText("25000$");
            priceBeforeTaxes=25000;


        }
        if(r3.isChecked())
        {
            editText.setText("10000$");
            priceBeforeTaxes=10000;

        }
        if(r2.isChecked())
        {
            editText.setText("9500000$");
            priceBeforeTaxes=9500000;
        }
        if(r.isChecked())
        {
            editText.setText("145500$");
            priceBeforeTaxes=145500;
        }


    }

    /**
     *
     * @param view
     */
    public void calculation(View view) {
        EditText editText1=(EditText)findViewById(R.id.editText7);
        EditText editText2=(EditText)findViewById(R.id.editText10);
        EditText editText3=(EditText)findViewById(R.id.editText12);

        if (editText1.length() ==0) {
            Toast.makeText(getApplicationContext(),"Please enter quantity",Toast.LENGTH_LONG).show();
        }
        else{
            Integer quantity=Integer.parseInt(editText1.getText().toString());
            if(quantity>0){ControlCalculate controlCalculate=new ControlCalculate();
                controlCalculate.crateObject(priceBeforeTaxes,quantity);
                controlCalculate.total();
                double taxes=controlCalculate.getTaxes();
                double total=controlCalculate.getTotal();
                editText2.setText(BigDecimal.valueOf(taxes).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
                editText2.setFocusable(false);
                editText3.setText(BigDecimal.valueOf(total).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
                editText3.setFocusable(false);
            }
            else{
                Toast.makeText(getApplicationContext(),"Please enter valid quantity",Toast.LENGTH_LONG).show();

            }
        }


    }

    /**
     *
     * @param view
     */
    public void launchSecondActivity(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void launchCalculatorActivity(View view) {
        Intent intent=new Intent(this,CalculatorActivity.class);
        startActivity(intent);
    }
}
