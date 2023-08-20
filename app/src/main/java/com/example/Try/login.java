package com.example.Try;

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
import android.app.Activity;

public class login extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initViews();

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                RegisterAcc = (String) getIntent().getExtras().getString("Acc");
                RegisterPw = (String) getIntent().getExtras().getString("Pw");
                if (Acc.getText().toString().matches(""))
                {Toast.makeText(login.this,"請輸入帳號",Toast.LENGTH_SHORT).show();}
                else if (Pw.getText().toString().matches(""))
                {Toast.makeText(login.this,"請輸入密碼",Toast.LENGTH_SHORT).show();}

                //else if ((Acc.getText().toString() != RegisterAcc)||(Pw.getText().toString() != RegisterPw))
                //{Toast.makeText(login.this,"帳號或密碼有誤",Toast.LENGTH_SHORT).show();}

                else if ((Acc.getText().toString().matches(RegisterAcc))&&(Pw.getText().toString().matches(RegisterPw)))
                {
                    Toast.makeText(login.this, "歡迎您，使用者"+Acc.getText().toString(), Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("ACC", Acc.getText().toString());
                    bundle.putString("PW", Pw.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtras(bundle); //bundle綁入intent
                    intent.setClass(login.this, upload.class);
                    startActivity(intent);
                }
            }
        });

        Register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent register_start = new Intent();
                register_start.setClass(login.this, register.class);
                startActivity(register_start);
            }
        });



    }

    private EditText Acc;
    private EditText Pw;
    private Button Login;
    private Button Register;

    private String RegisterAcc = "BingCho";
    private String RegisterPw = "IM24";

    private void initViews()
    {
        Acc = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Pw = (EditText) findViewById(R.id.editTextTextPassword);
        Login = (Button) findViewById(R.id.button3);
        Register = (Button) findViewById(R.id.button4);
    }

}
