package com.example.visitingcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CardScreen extends AppCompatActivity {

   TextView txtName;
    TextView txtBusinessName1;
    TextView txtBusinessName2;
    TextView txtPhone;
    TextView txtEmail;
    TextView txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_screen);

        txtName = findViewById(R.id.cardName);
        txtBusinessName1 = findViewById(R.id.card_business_name);
        txtBusinessName2 = findViewById(R.id.card_business_name2);
        txtPhone = findViewById(R.id.cardPhone);
        txtAddress = findViewById(R.id.cardAddress);
        txtEmail = findViewById(R.id.cardEmail);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String business = intent.getStringExtra("business");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String address = intent.getStringExtra("address");

        txtName.setText(name);
        txtEmail.setText(email);
        txtBusinessName1.setText(business);
        txtBusinessName2.setText(business);
        txtPhone.setText(phone);
        txtAddress.setText(address);



    }
}