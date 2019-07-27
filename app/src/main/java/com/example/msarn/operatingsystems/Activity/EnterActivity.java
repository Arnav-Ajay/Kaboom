package com.example.msarn.operatingsystems.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.msarn.operatingsystems.R;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void onButtonPressed(View view)
    {
        Intent i= new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
