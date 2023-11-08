package com.example.lab2.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.R;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edtCD, edtCR;
    Button btnSend;
    TextView tvKetqua;
    public static final String link_api_bai2 = "http://192.168.56.1/api_android/tinhtoan_api.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edtCD = findViewById(R.id.edtCD);
        edtCR = findViewById(R.id.edtCR);
        btnSend = findViewById(R.id.btnTinhtoan);
        tvKetqua = findViewById(R.id.tvKetqua);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String cd = edtCD.getText().toString();
        String cr = edtCR.getText().toString();
        if (cd.isEmpty() && cr.isEmpty()){
            Toast.makeText(this, "chua nhap du thong tin", Toast.LENGTH_SHORT).show();
        }else{
            BackGroundTask_POST backGroundTask_post = new BackGroundTask_POST(this, cd, cr,tvKetqua);
            backGroundTask_post.execute();
        }
    }
}