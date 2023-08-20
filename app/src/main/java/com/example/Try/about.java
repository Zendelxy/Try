package com.example.Try;

import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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

public class about extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        initViews();

        sv.post(new Runnable() {
            @Override
            public void run() {
            sv.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent main = new Intent();
                main.setClass(about.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        });
    }


    private ScrollView sv;
    private ImageButton back;

    private void initViews()
    {

        sv = (ScrollView) findViewById(R.id.SV);
        back = (ImageButton) findViewById(R.id.imageButton);
    }

}
