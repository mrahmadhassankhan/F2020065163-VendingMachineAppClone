package com.example.f2020065163_ahmadhassankhan_vendingappclone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    EditText usernameEditText;
    EditText passwordEditText;
    Button loginBtn;
    Button signupBtn;

    String username;
    String password;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupandlogin);
        loginBtn = findViewById(R.id.LoginBtn);
        signupBtn = findViewById(R.id.signupButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        // Get a reference to the Shared Preferences
        sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener(){
         @Override
                 public  void  onClick(View v){
             username = usernameEditText.getText().toString();
             password = passwordEditText.getText().toString();
             if (isValidInput()) {
                 // Validate login credentials
                 if (isValidLoginCredentials()) {
                     // Login successful, do something
                     Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(MainActivity.this, CustomList.class);
                     startActivity(intent);
                 } else {
                     // Login failed, display a message
                     Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                 }
             } else {
                 // Input validation failed, display a message
                 Toast.makeText(MainActivity.this, "Please enter a username and password", Toast.LENGTH_SHORT).show();
             }
         }
        });
     signupBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             // Handle signup button click
             username = usernameEditText.getText().toString();
             password = passwordEditText.getText().toString();
             if (isValidInput()) {
                 // Validate signup credentials
                 if (isValidSignupCredentials()) {
                     // Signup successful, store the username and password in shared preferences
                     SharedPreferences.Editor editor = sharedPref.edit();
                     editor.putString(username, password);
                     editor.apply();
                     Toast.makeText(MainActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                 } else {
                     // Signup failed, display a message
                     Toast.makeText(MainActivity.this, "Signup failed. Username already exists", Toast.LENGTH_SHORT).show();
                 }
             } else {
                 // Input validation failed, display a message
                 Toast.makeText(MainActivity.this, "Please enter a username and password", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }
    private boolean isValidInput() {
        // Validate input for username and password
        return !username.isEmpty() && !password.isEmpty();
    }

    private boolean isValidLoginCredentials() {
        // Check if the username and password match the stored credentials in shared preferences
        String storedPassword = sharedPref.getString(username, null);
        return storedPassword != null && storedPassword.equals(password);
    }

    private boolean isValidSignupCredentials() {
        // Check if the username already exists in shared preferences
        String storedPassword = sharedPref.getString(username, null);
        return storedPassword == null;
    }
}
