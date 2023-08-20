package com.example.Try;

import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.content.Intent;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Main");
        setContentView(R.layout.main);

        initViews();

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
            Intent I_start = new Intent();
            I_start.setClass(MainActivity.this, login.class);
            startActivity(I_start);
            }
        });
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
            Intent I_about = new Intent();
            I_about.setClass(MainActivity.this, about.class);
            startActivity(I_about);
            }
        });
    }
    private Button start;
    private Button about;

    private void initViews()
    {
        start = (Button) findViewById(R.id.button);
        about = (Button) findViewById(R.id.button2);
    }
}
