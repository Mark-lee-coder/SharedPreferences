package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcome;
    EditText etName;
    Button submit;

    public static final String MY_PREFS_FILENAME = "com.example.sharedpreferences.Names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        submit = findViewById(R.id.btnSubmit);

        /*missing .edit() method means we are not changing the name provided*/
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        tvWelcome.setText("Welcome to my app " + user + "!");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                tvWelcome.setText("Welcome to my app " + name + "!");

                /*.edit() method means we are may change the name provided*/
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.apply();
            }
        });
    }
}