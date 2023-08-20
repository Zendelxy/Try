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

public class register extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initViews();

        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle register = new Bundle();
                register.putString("Acc",Acc.getText().toString());
                register.putString("Pw",Pw.getText().toString());
                Toast.makeText(register.this,"將在三秒後跳回登入頁面",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                    final Intent jump = new Intent(register.this, login.class);
                    jump.putExtras(register);
                    startActivity(jump);
                    finish();
                    }
                },3000);
            }
        });

    }

    private Button register;
    private EditText Acc;
    private EditText Pw;

    private void initViews()
    {
        register = (Button) findViewById(R.id.button5);
        Acc = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        Pw = (EditText) findViewById(R.id.editTextTextPassword2);
    }
}
