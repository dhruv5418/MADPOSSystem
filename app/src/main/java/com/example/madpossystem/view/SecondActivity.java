package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madpossystem.R;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="com.example.android.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessageEditText=findViewById(R.id.editText_second);
    }

    /**
     *
     * @param view
     */
    public void launchThirdActivity(View view) {
        if(mMessageEditText.length()==0){
            Toast.makeText(getApplicationContext(),"Please enter message",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(this,ThirdActivity.class);
            String message=mMessageEditText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);

        }

    }
}
