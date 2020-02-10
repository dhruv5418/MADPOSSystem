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

public class CalculatorActivity extends AppCompatActivity {
    Button button;
    private double firstNumber = Double.MIN_VALUE;
    private double secondNumber = Double.MIN_VALUE;
    private String operator = "";
    private TextView screen;
   private String str2,str1,result,str,sign,dot,oper,signReviser,check;
    private Double a,b;
    int[] ids;
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
                            str1 = str;
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

  /*  public void valueEnter(View view) {
        Button button = (Button) view;
        str += button.getText().toString();
        screen.setText(str);
        a = Double.parseDouble(str);
        }
*/

      /*  button = (Button)view;
        str += button.getText().toString();
        screen.setText(str);
        a = Double.parseDouble(str);*/


   /*public void onClickSigns(View view) {
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
    }*/

 /*   public void clear(View view) {

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
  /*  private double isInteger(String value)
    {
        double ret = -1.0;
        try {
            ret = Double.parseDouble(value);
        }catch(NumberFormatException ex)
        {

        }finally {
            return ret;
        }
    }*/

    }
}
