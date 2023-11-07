package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText felhasznalonevRegister;
    private EditText emailRegister;
    private EditText jelszoRegister;
    private EditText teljesNevRegister;
    private Button registerBtn;
    private Button registerVisszaBtn;

    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Pattern.matches("[a-zA-Z0-9]++@[a-z]++.[a-z]++",emailRegister.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Hibás e-mail cím", Toast.LENGTH_SHORT).show();
                }
                else if(!Pattern.matches("[A-Z][a-z]++ [A-Z][a-z]++",teljesNevRegister.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Hibás teljes név", Toast.LENGTH_SHORT).show();
                }
                else if(emailRegister.getText().toString().trim().isEmpty() ||
                felhasznalonevRegister.getText().toString().trim().isEmpty() ||
                jelszoRegister.getText().toString().trim().isEmpty() ||
                teljesNevRegister.getText().toString().trim().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Hiányos kitöltés!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(adatbazis.rogzites(emailRegister.getText().toString(),
                            felhasznalonevRegister.getText().toString(),
                            jelszoRegister.getText().toString(),
                            teljesNevRegister.getText().toString())){
                        Toast.makeText(RegisterActivity.this, "Sikeres adatfelvétel", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Sikertelen adatfelvétel", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        registerVisszaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        felhasznalonevRegister = findViewById(R.id.felhasznalonevRegister);
        emailRegister = findViewById(R.id.emailRegister);
        jelszoRegister = findViewById(R.id.jelszoRegister);
        teljesNevRegister = findViewById(R.id.teljesNevRegister);

        registerBtn = findViewById(R.id.registerBtn);
        registerVisszaBtn = findViewById(R.id.registerVisszaBtn);

        adatbazis = new DBHelper(RegisterActivity.this);
    }
}