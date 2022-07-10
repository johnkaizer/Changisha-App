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

public class SignUpActivity extends AppCompatActivity {
    Button login, signup;
    EditText username, password,re_password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.user_txt);
        password = findViewById(R.id.pass_txt);
        re_password = findViewById(R.id.re_pass_txt);
        login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.btn_SignUp);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= re_password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass))
                    Toast.makeText(SignUpActivity.this,"All field are required",Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkUser= DB.checkUsername(user);
                        if (checkUser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(SignUpActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(SignUpActivity.this, AccountActivity.class);
                                startActivity(intent);
                                finish();

                            }else{
                                Toast.makeText(SignUpActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this,"You already have an account",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpActivity.this,"passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}