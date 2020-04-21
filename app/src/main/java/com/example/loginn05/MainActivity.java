package com.example.loginn05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText edt_username,edt_password;
    private Button btn_login,btn_reset,btn_help;
    private TextView tv_result;
    private int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);

        btn_login = findViewById(R.id.btn_login);
        btn_reset = findViewById(R.id.btn_reset);
        btn_help = findViewById(R.id.btn_help);
        tv_result = findViewById(R.id.tv_result);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String user = edt_username.getText().toString().trim();
               String pass = edt_password.getText().toString().trim();

                if(user.equals("sa") && pass.equals("sa")){
                    Intent intent = new Intent(MainActivity.this,WellcomeActivity.class);
                    startActivityForResult(intent,REQUEST_CODE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
//
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_username.setText("");
                edt_password.setText("");
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            String s = data.getStringExtra("result");
            tv_result.setText(s);
        }
    }
}
