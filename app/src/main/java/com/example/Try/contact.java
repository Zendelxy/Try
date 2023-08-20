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

public class contact extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        initViews();

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent back = new Intent();
                back.setClass(contact.this, upload.class);
                startActivity(back);
                finish();
            }
        });
    }

    private ImageButton back;
    private EditText msg;
    private Button send;

    private void initViews()
    {
        msg = (EditText) findViewById(R.id.editTextText);
        send = (Button) findViewById(R.id.button9);
        back = (ImageButton) findViewById(R.id.imageButton6);
    }
}
