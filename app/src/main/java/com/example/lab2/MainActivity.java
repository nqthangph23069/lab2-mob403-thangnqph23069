package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab2.bai1.Bai1Activity;
import com.example.lab2.bai2.Bai2Activity;
import com.example.lab2.bai3.Bai3Activity;
import com.example.lab2.bai4.Bai4Activity;

public class MainActivity extends AppCompatActivity{
    Button btnBai1,btnbai2,btnbai3,btnbai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBai1 = findViewById(R.id.btnbai1);
        btnbai2 = findViewById(R.id.btnbai2);
        btnbai3 = findViewById(R.id.btnbai3);
        btnbai4 = findViewById(R.id.btnbai4);
        btnBai1.setOnClickListener(v -> {
            startActivity(new Intent(this, Bai1Activity.class));
        });
        btnbai2.setOnClickListener(v -> {
            startActivity(new Intent(this, Bai2Activity.class));
        });
        btnbai3.setOnClickListener(v -> {
            startActivity(new Intent(this, Bai3Activity.class));
        });
        btnbai4.setOnClickListener(v -> {
            startActivity(new Intent(this, Bai4Activity.class));
        });
    }
}