package com.example.lucthoisang.lotoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtsomin,edtsomax;
    Button btnrandom,btnadd;
    TextView txtketqua;
    ArrayList<Integer> mangso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smin = edtsomin.getText().toString();
                String smax = edtsomax.getText().toString();

                int somin = Integer.parseInt(smin);
                int somax = Integer.parseInt(smax);

                for(int i = somin; i <= somax; i++){
                    mangso.add(i);
                }
                Toast.makeText(MainActivity.this, mangso.size()+"", Toast.LENGTH_SHORT).show();
            }
        });
        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                if(mangso.size() > 0) {
                    int index = random.nextInt(mangso.size());
                    int value = mangso.get(index);
                    txtketqua.append(value + "");
                    mangso.remove(index);
//                    cach 1: kiem tra gia tri cuoi cung
//                    if (mangso.size() == 1){
//                        ketqua += value;
//                    }else {
//                        ketqua += value + " - "
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Het", Toast.LENGTH_SHORT).show();
                }
//cah 2:
//            String dapan = ketqua.substring (0, ketqua.length) - 3);
            }
        });
    }

    private void anhxa() {
        edtsomin = (EditText) findViewById(R.id.edittextsomin);
        edtsomax = (EditText) findViewById(R.id.edittextsomax);
        btnrandom = (Button) findViewById(R.id.buttonrandom);
        txtketqua = (TextView) findViewById(R.id.textviewketqua);
        btnadd = (Button) findViewById(R.id.buttonadd);
        mangso = new ArrayList<>();
    }
}
