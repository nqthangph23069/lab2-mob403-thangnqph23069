package com.example.lab2.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edtSoA, edtSoB, edtSoC;
    Button btnSendBai4;
    TextView tvKqBai4;
    public static final String link_api_bai4 = "http://192.168.56.1/api_android/giaiptbac2.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        edtSoC = findViewById(R.id.edtSoC);
        btnSendBai4 = findViewById(R.id.btnSendBai4);
        tvKqBai4 = findViewById(R.id.tvKqBai4);
        btnSendBai4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String a = edtSoA.getText().toString();
            String b = edtSoB.getText().toString();
            String c = edtSoC.getText().toString();
            BackGroundTask_Bai4 backGroundTask_bai4 = new BackGroundTask_Bai4(this, tvKqBai4);
            backGroundTask_bai4.execute(a, b, c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}