package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.madpossystem.R;

public class ThirdActivity extends AppCompatActivity {

    /**
     *on create method with showing string received with intent.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent=getIntent();
        String message=intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.text_message);
        textView.setText(message);
        textView.setBackgroundColor(getResources().getColor(R.color.light_yellow));
    }
}
