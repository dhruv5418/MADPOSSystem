package com.example.madpossystem.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import android.widget.Toast;

import com.example.madpossystem.R;

public class CallActivity extends AppCompatActivity {


    /**
     * final int variable call request
     */
    private final int CALL_REQUEST = 100;
    /**
     * edit text field for mobileNO
     */
    EditText mobileNoEt;
    /**
     * Button for calling
     */
    Button callBt;

    /**
     * on create method
     * contains onClickListener for call button.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        mobileNoEt = (EditText) findViewById(R.id.editText1);
        callBt = (Button) findViewById(R.id.button1);
        callBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    dialCall();
            }
        });
    }

    /**
     * contains code for call permission and call intent.
     */
    public void dialCall() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling

                    ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST);

                    return;
                }
            }

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + mobileNoEt.getText().toString().trim()));
            startActivity(callIntent);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * after giving permission request check for condition.
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        if(requestCode == CALL_REQUEST)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                dialCall();
            }
            else
            {
                Toast.makeText(CallActivity.this, getResources().getString(R.string.call_permission_denied_message), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
