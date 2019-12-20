package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.madpossystem.R;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="com.example.android.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessageEditText=findViewById(R.id.editText_second);
    }


    public void launchThirdActivity(View view) {
        Intent intent=new Intent(this,ThirdActivity.class);
        String message=mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }
}
