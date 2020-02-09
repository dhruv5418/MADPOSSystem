package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpossystem.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    private double firstNumber = Double.MIN_VALUE;
    private double secondNumber = Double.MIN_VALUE;
    private String operator = "";
    private TextView screen;
   /* private String str1,str2,str3,result,str,sign;
    private Double a,b;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen = (TextView) findViewById(R.id.result_screen);
        int[] ids = {R.id.button14, R.id.button15,R.id.button16, R.id.button17,R.id.button18, R.id.button19,R.id.button20,
                R.id.button21,R.id.button22, R.id.button23,R.id.button24,R.id.button25,R.id.button26,R.id.button27,
                R.id.button28,R.id.button29,R.id.button30, R.id.button31,R.id.button32,R.id.button33};
        for (int id:ids) {
            Button b = (Button) findViewById(id);
            b.setOnClickListener(this);
        }


      /* ViewGroup rootView = (ViewGroup) findViewById(R.id.rootlayout);
        View v;
        for (int i = 0; i < rootView.getChildCount(); i++) {
            v = rootView.getChildAt(i);
            if (v instanceof Button)
            {v.setOnClickListener(this);
            }

        }*/
    }



    public void onClick(View view) {
        if(view instanceof Button) {

            Button button = (Button)view;
            String buttonValue = button.getText().toString();

            // Check whether the button's text is a number or not.
            int buttonNumber = isInteger(buttonValue);

            if(buttonNumber != -1||".".equals(buttonValue))
            {
                // Get current edit text box value.
                String currentValue = screen.getText().toString();

                if(isInteger(currentValue) > 0||".".equals(buttonValue))
                {
                    // If current value is a number then append new number to the end.
                    currentValue += buttonValue;
                    screen.setText(currentValue);
                }
                else
                {
                    // Append the button number to edit text box.
                    screen.setText(buttonValue);
                }

            } else
            {
                // If the button is operator button.
                if("+".equals(buttonValue) || "-".equals(buttonValue) || "×".equals(buttonValue) || "÷".equals(buttonValue))
                {
                    // Get current number.
                    String currentValue = screen.getText().toString();
                    if(isInteger(currentValue) > -1)
                    {
                        // Save it's value in firstNumber if the value is a number.
                        firstNumber = Double.parseDouble(currentValue);
                    }else
                    {
                        // Reset firstNumber value.
                        firstNumber = Double.MIN_VALUE;
                    }

                    // Save the operator.
                    operator = buttonValue;
                    // Show operator in edit text box.
                    screen.setText(buttonValue);
                }else if("C".equals(buttonValue))
                {
                    // If user click c button then reset all value.
                    firstNumber = Double.MIN_VALUE;
                    secondNumber = Double.MIN_VALUE;
                    // Display empty string in edit text box.
                    screen.setText("");
                }else if("⌫".equals(buttonValue)) {
                    if (screen.getText().length() > 0) {
                        String currentValue = screen.getText().toString();
                        if (currentValue.length() > 1) {
                            currentValue = currentValue.substring(0, currentValue.length() - 1);
                            screen.setText(currentValue);
                        } else if (currentValue.length() <= 1) {
                            screen.setText("0");
                        }

                    }
                }
                else if("=".equals(buttonValue))
                {
                    // Get current number.
                    String currentValue = screen.getText().toString();
                    if(isInteger(currentValue) > -1)
                    {
                        // Save it's value in secondNumber if the value is a number.
                        secondNumber = Double.parseDouble(currentValue);
                    }else
                    {
                        // Reset firstNumber value.
                        secondNumber = Double.MIN_VALUE;
                    }

                    // If the button is equal button.
                    if(firstNumber > Long.MIN_VALUE && secondNumber > Long.MIN_VALUE) {

                        double resultNumber = 0;

                        // Calculate the result number.
                        if ("+".equals(operator)) {
                            resultNumber = firstNumber + secondNumber;
                        }else if("-".equals(operator))
                        {
                            resultNumber = firstNumber - secondNumber;
                        }else if("×".equals(operator))
                        {
                            resultNumber = firstNumber * secondNumber;
                        }else if("÷".equals(operator))
                        {
                            resultNumber = firstNumber / secondNumber;
                        }

                        // Show the result number.
                        screen.setText(String.valueOf(resultNumber));
                        // Save the result number as second result number.
                        secondNumber = resultNumber;
                        // Reset first number.
                        firstNumber = Double.MIN_VALUE;
                    }
                }
            }

        }
        }


      /*  button = (Button)view;
        str += button.getText().toString();
        screen.setText(str);
        a = Double.parseDouble(str);*/


   /* public void onClickSigns(View view) {
        Button button = (Button) view;
        sign = ((Button) view).getText().toString();
        screen.setText(sign);
        str="";
    }

    public void calculate(View view) {
        Button button = (Button) view;
        str2 = screen.getText().toString();
        b = Double.parseDouble(str2);
        if (sign .equals("+")){
            result = a+b+"";
        }
        else if (sign .equals("-")){
            result = a-b+"";
        }
        else if (sign .equals("X")){
            result = a*b+"";
        }
        else if (sign .equals("÷")){
            result = a/b+"";
        }
        else{
            result = "Something went wrong";
        }
        screen.setText(result);
    }

    public void clear(View view) {

        a=Double.MIN_VALUE;
        b=Double.MIN_VALUE;
        screen.setText("");

    }

    public void backspace(View view) {
        if(screen.getText().length()>0){
            str.replace(str.substring(str.length()-1), "");
            screen.setText(str);

        }

    }*/
    private int isInteger(String value)
    {
        int ret = -1;
        try {
            ret = Integer.parseInt(value);
        }catch(NumberFormatException ex)
        {

        }finally {
            return ret;
        }
    }
}
