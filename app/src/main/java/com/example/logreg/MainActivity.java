package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText belepesEditText;
    private EditText jelszoEditText;
    private Button belepesBtn;
    private Button regisztracioBtn;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        belepesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(belepesEditText.getText().toString().trim().length() == 0 || jelszoEditText.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Hiányos kitöltés!", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
        regisztracioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    public void init(){
        belepesEditText = findViewById(R.id.belepesEditText);
        jelszoEditText = findViewById(R.id.jelszoEditText);

        belepesBtn = findViewById(R.id.belepesBtn);
        regisztracioBtn = findViewById(R.id.regisztracioBtn);
    }
}