package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp_Form extends AppCompatActivity {

    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form);
    }

    public void btnsignup(View view) {
        Intent intent = new Intent(this,VarificationCode_Form.class);
        intent.putExtra("mode",st);
        startActivity(intent);
    }

    public void btn_Login(View view){
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

    public void btn_user(View view) {
        st = "user";

    }

    public void btn_Admin(View view) {
        st = "admin";
    }
}
