package com.example.Try;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
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

public class knowledge extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knowledge);
        initViews();

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent back = new Intent();
                back.setClass(knowledge.this, upload.class);
                startActivity(back);
                finish();
            }
        });
    }

    private ImageButton back;
    private ImageButton K_1;
    private ImageButton K_2;
    private void initViews()
    {
        back = (ImageButton) findViewById(R.id.imageButton7);
        K_1 = (ImageButton) findViewById(R.id.imageButton8);
        K_2 = (ImageButton) findViewById(R.id.imageButton9);
    }
}
