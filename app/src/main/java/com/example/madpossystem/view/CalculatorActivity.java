package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpossystem.R;

public class CalculatorActivity extends AppCompatActivity {

    /**
     * Type TextView to store screen view
     */
    private TextView screen;
    /**
     * Strings for store calculation
     */
   private String str2,result,str,sign,dot,signReviser,check;
    /**
     * To store user input for calculation
     */
    private Double a,b;
    /**
     * Array to store ButtonID
     */
    int[] ids;

    /**
     * on create method
     * contains all code for calculator functionality.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen = (TextView) findViewById(R.id.result_screen);
        str = "";
        result = "";
        check = "";
        dot = "";
        signReviser = "";
        int[] ids = {R.id.button15,R.id.button14, R.id.button17, R.id.button18, R.id.button19, R.id.button20,
                R.id.button21, R.id.button22, R.id.button24, R.id.button25, R.id.button26, R.id.button32};
        int[] ids1 = {R.id.button31, R.id.button16, R.id.button23, R.id.button27,};
        int[] ids2 = {R.id.button33};
        int[] ids3 = {R.id.button28, R.id.button32};
        int[] ids4 = {R.id.button30,R.id.button29};
        for (int id : ids1) {
            Button b = (Button) findViewById(id);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    sign = ((Button) v).getText().toString();
                    screen.setText(sign);

                    if (signReviser.equals("")) {
                        if (str.equals("")) {
                            a = Double.parseDouble(result);
                        } else {
                            a = Double.parseDouble(str);
                            str = "";
                            dot = "";

                        }
                    }
                }
            });

        }
        for (int id : ids) {
            Button b = (Button) findViewById(id);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    result = "";
                    check = ((Button) v).getText().toString();
                    if (check.equals(".") && dot.equals("")) {

                        dot = ".";
                        str += button.getText().toString();
                    } else if (!check.equals(".")) {
                        str += button.getText().toString();
                    }
                    screen.setText(str);
                }


            });

        }
        for (int id : ids2) {
            Button b1 = (Button) findViewById(id);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    str = screen.getText().toString();
                    b = Double.parseDouble(str);
                    if (sign.equals("+")) {
                        result = a + b + "";
                    } else if (sign.equals("-")) {
                        result = a - b + "";
                    } else if (sign.equals("×")) {
                        result = a * b + "";
                    } else if (sign.equals("÷")) {
                        result = a / b + "";
                    } else {
                        result = "Something went wrong";
                    }
                    screen.setText(result);
                    str = "";
                    signReviser = "";
                }
            });
        }
        for (int id : ids3) {
            Button b1 = (Button) findViewById(id);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    String buttonValue = button.getText().toString();
                    if ("C".equals(buttonValue)) {
                        a = 0.0;
                        b = 0.0;
                        str = "";
                        result = "";
                        screen.setText("0");

                    } else {
                        if (screen.getText().length() > 0) {
                            str=str.substring(0,str.length() - 1);
                            screen.setText(str);
                        }
                    }

                }
            });
        }
        for (int id : ids4) {
            Button b = (Button) findViewById(id);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button=((Button)v);
                    String buttonValue = button.getText().toString();
                    if(buttonValue.equals("M"))
                    {
                        if (result.length()>0){
                            str2=result;
                            Toast.makeText(getApplicationContext(),"Saved in memory",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{

                    if(str2.length()>0){
                        str=str2;
                        screen.setText(str);
                    }
                    }

                }
            });

        }

    }
}
