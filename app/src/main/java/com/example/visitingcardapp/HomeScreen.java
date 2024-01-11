package com.example.visitingcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class HomeScreen extends AppCompatActivity {
    Button button;
    int SELECT_PICTURE = 200;
    ImageView img;

    TextInputEditText txtName;
    TextInputEditText txtBusinessName;
    TextInputEditText txtPhone;
    TextInputEditText txtEmail;
    TextInputEditText txtAddress;

    String name;
    String business;
    String phone;
    String email;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        button = (Button) findViewById(R.id.button);
        txtName = findViewById(R.id.name);
        txtBusinessName =  findViewById(R.id.business_name);
        txtPhone =  findViewById(R.id.phone);
        txtEmail =  findViewById(R.id.email);
        txtAddress =  findViewById(R.id.address);



        Intent sendDetail = new Intent(this, CardScreen.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = txtName.getText().toString();
                business = txtBusinessName.getText().toString();
                phone = txtPhone.getText().toString();
                email = txtEmail.getText().toString();
                address = txtAddress.getText().toString();

                /// error for ton send image in next screen

//                sendDetail.putExtra("MyImagePath", img.getAbsoluteFile());
                sendDetail.putExtra("name",name);
                sendDetail.putExtra("business",business);
                sendDetail.putExtra("phone",phone);
                sendDetail.putExtra("email",email);
                sendDetail.putExtra("address",address);
                startActivity(sendDetail);
                openNewActivity();
                Toast.makeText(getBaseContext(), "Detail Submitted !" , Toast.LENGTH_SHORT ).show();
            }
        });

        img = (ImageView) findViewById(R.id.uploadImageButton);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageSelect();
                sendDetail.putExtra("img", img.getDrawableState());
            }
        });
    }

    void imageSelect()
    {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"),SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    img.setImageURI(selectedImageUri);
                    img.setClipToOutline(true);
                }
            }
        }
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, CardScreen.class);
        startActivity(intent);
    }
}