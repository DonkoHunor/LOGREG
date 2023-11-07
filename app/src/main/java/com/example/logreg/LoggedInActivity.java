package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private TextView tv;
    private DBHelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();
        Cursor adatok = adatbazis.adatLekerdezes();
        tv.setText("Üdv " + adatok.getString(5));
    }

    public void init(){
        tv = findViewById(R.id.megjelenitesEditText);
    }
}