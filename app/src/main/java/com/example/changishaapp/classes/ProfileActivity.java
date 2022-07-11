package com.example.changishaapp.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.changishaapp.model.DBHelper;
import com.example.changishaapp.R;

public class ProfileActivity extends AppCompatActivity {
    Button signup,login;
    EditText username, password;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.user_txt1);
        password = findViewById(R.id.pass_txt1);
        login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.btn_SignUp);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(ProfileActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if (checkUserPass==true){
                        Toast.makeText(ProfileActivity.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfileActivity.this, AccountActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(ProfileActivity.this,"wrong username or password",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}