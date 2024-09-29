package com.example.layoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    private EditText password;

    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        initViews();

        initListeners();

        Log.d("MainActivity", "onCreate() called");
    }

    private void initListeners(){

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emailValidator(email.getText().toString())){

                }else {
                    email.setError("Invalid email");
                }
                if (!validatePassword(password.getText().toString())){

                    password.setError("Invalid password");
                }
                

                startActivity(new Intent(getApplicationContext(), UserDetailActivity.class));

                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();



            }
        });

    }


    private boolean validatePassword(String password) {

        return password.length() >= 8;

    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private void initViews() {

        email = findViewById(R.id.et_emailAdd);

        password = findViewById(R.id.et_password);

        login = findViewById(R.id.btn_login);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy() called");
    }
}