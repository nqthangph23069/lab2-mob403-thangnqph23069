package com.example.lab2.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtname, edtscore;
    private Button btnOK;
    private TextView tvResult;
    public static final String link_api = "http://192.168.56.1/api_android/student_api.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        edtname = findViewById(R.id.edtName);
        edtscore = findViewById(R.id.edtScore);
        btnOK = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSubmit){
            String name = edtname.getText().toString();
            String score = edtscore.getText().toString();
            BackGroundTask_GET backGroundTask_get = new BackGroundTask_GET(tvResult, name, score, this);
            backGroundTask_get.execute();

        }
    }
}