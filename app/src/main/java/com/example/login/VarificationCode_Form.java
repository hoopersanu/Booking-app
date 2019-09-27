package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VarificationCode_Form extends AppCompatActivity {
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification_code__form);

        st = getIntent().getExtras().getString("mode");

    }

//    public void btnvarification(View view) {
//        Intent intent = new Intent(this,ProductItems.class);
//        startActivity(intent);
//    }


        public void btnvarification (View view) {
            if (st.equals("admin")) {
                Intent intent = new Intent(this, ProductItems.class);
                startActivity(intent);

            } else if (st.equals("user")) {
                Intent intent = new Intent(this, PhonenumberProvide.class);
                startActivity(intent);
            }

              else if (st.equals("login")){
                Intent intent= new Intent(this,HomePage.class);
                startActivity(intent);
            }
        }
}
