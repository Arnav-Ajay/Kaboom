package com.example.msarn.operatingsystems.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.msarn.operatingsystems.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void back(View view)
    {
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
