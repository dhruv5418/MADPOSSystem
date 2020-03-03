package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madpossystem.R;
import com.example.madpossystem.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    /**
     * Buttons
     */
    Button b1,b2;
    /**
     * EditText
     */
    EditText ed1,ed2;
    /**
     * TextView
     */
    TextView tx1;
    /**
     * Counter to store total remaining tries
     */
    int counter = 3;

    /**
     * onCreate method
     * finds button and text elements from view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
    }


    /**
     * Check for login credential given by user are valid or not.
     * if valid redirect to main activity.
     * @param view
     */
    public void login(View view) {
        if(ed1.getText().toString().equals("admin") &&
                ed2.getText().toString().equals("password")) {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            // to be continued ...
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.RED);
            counter--;
            tx1.setText(Integer.toString(counter));
            if (counter == 0) {
                b1.setEnabled(false);
            }
        }
    }

    /**
     * exit the application when click on exit button.
     * @param view
     */
    public void exit(View view) {
        finish();
    }
}
