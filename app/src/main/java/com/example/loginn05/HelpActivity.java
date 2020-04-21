package com.example.loginn05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HelpActivity extends AppCompatActivity {

    EditText edt_result;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        edt_result = findViewById(R.id.editText);

        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = edt_result.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                Log.d("LongDinh",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
