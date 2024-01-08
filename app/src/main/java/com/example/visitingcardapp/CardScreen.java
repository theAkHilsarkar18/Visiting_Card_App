package com.example.visitingcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CardScreen extends AppCompatActivity {



   TextView txtName;
    TextView txtBusinessName1;
    TextView txtBusinessName2;
    TextView txtPhone;
    TextView txtEmail;
    TextView txtAddress;

    FrameLayout card1Theme;
    FrameLayout them1;
    FrameLayout them2;
    FrameLayout them3;
    FrameLayout them4;
    FrameLayout them5;
    FrameLayout them6;
    FrameLayout them7;
    FrameLayout them8;
    FrameLayout them9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_screen);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String business = intent.getStringExtra("business");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String address = intent.getStringExtra("address");

        txtName = (TextView ) findViewById(R.id.cardName);
        txtBusinessName1 = (TextView ) findViewById(R.id.card_business_name);
        txtBusinessName2 =(TextView ) findViewById(R.id.card_business_name2);
        txtPhone = (TextView )findViewById(R.id.cardPhone);
        txtAddress = (TextView ) findViewById(R.id.cardAddress);
        txtEmail = (TextView ) findViewById(R.id.cardEmail);

        txtName.setText(name);
        txtEmail.setText(email);
        txtBusinessName1.setText(business);
        txtBusinessName2.setText(business);
        txtPhone.setText(phone);
        txtAddress.setText(address);

        them1 = findViewById(R.id.theme1);
        them2 = findViewById(R.id.theme2);
        them3 = findViewById(R.id.theme3);
        them4 = findViewById(R.id.theme4);
        them5 = findViewById(R.id.theme5);
        them6 = findViewById(R.id.theme6);
        them7 = findViewById(R.id.theme7);
        them8 = findViewById(R.id.theme8);
        them9 = findViewById(R.id.theme9);
        card1Theme = findViewById(R.id.card1Theme);

        them5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1Theme.setBackgroundColor(R.id.theme5);
            }
        });





    }
}