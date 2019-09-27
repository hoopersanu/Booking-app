package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  String str;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnlogin(View view) {
    str = "login";
    Intent intent = new Intent(this,VarificationCode_Form.class);
    intent.putExtra("mode",str);
    startActivity(intent);
  }


    public void btn_sign_up(View view) {

    Intent intent = new Intent(this,SignUp_Form.class);
    startActivity(intent);
    }

    public void olololo(View view) {
    Intent intent = new Intent(this,Photography_Scroll_List.class);
    startActivity(intent);
    }
}
