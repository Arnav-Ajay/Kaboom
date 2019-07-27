package com.example.msarn.operatingsystems.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openOptions(View view)
    {
        Intent i= new Intent(this,OptionsActivity.class);
        startActivity(i);
    }

    public void openEnter(View view)
    {
        Intent i= new Intent(this,EnterActivity.class);
        startActivity(i);

    }
    public void back(View view)
    {
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
