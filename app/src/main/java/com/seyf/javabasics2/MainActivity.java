package com.seyf.javabasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int age;
    TextView textView;
    EditText enterAge;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.seyf.javabasics2" , Context.MODE_PRIVATE);

        textView = findViewById(R.id.textView);
        enterAge = findViewById(R.id.enterAge);

        int storeAge = sharedPreferences.getInt("storedAge", 0);
        textView.setText("Your Age: " + storeAge);
    }

    public void ageCalc(View view){
        if (enterAge.getText().toString().matches("")){

        } else {
            age = Integer.parseInt(enterAge.getText().toString());
            textView.setText("Your Age: " + age);
        }
        sharedPreferences.edit().putInt("storedAge", age).apply();
    }
    public void delete(View view){

        int storedData = sharedPreferences.getInt("storedAge",0);
        if (storedData != 0) {
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age: ");
        }
    }
}