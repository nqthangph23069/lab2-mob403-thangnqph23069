package com.example.lab2.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String link_api_bai3 = "http://192.168.56.1/api_android/thetich_api.php";
    private EditText edtC;
    private Button btnSendBai3;
    private TextView tvKqBai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        edtC = findViewById(R.id.edtCanh);
        btnSendBai3 = findViewById(R.id.btnSendBai3);
        tvKqBai3 = findViewById(R.id.tvKetquaBai3);
        btnSendBai3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String canh = edtC.getText().toString();
        BackGroundTask_Bai3 backGroundTask_bai3 = new BackGroundTask_Bai3(tvKqBai3, this);
        backGroundTask_bai3.execute(canh);
    }
}