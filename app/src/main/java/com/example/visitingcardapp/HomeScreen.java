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

public class HomeScreen extends AppCompatActivity {
    Button button;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_screen);
        button = (Button) findViewById(R.id.button);
        EditText txtName = findViewById(R.id.name);
        EditText txtBusinessName = findViewById(R.id.business_name);
        EditText txtPhone = findViewById(R.id.phone);
        EditText txtEmail = findViewById(R.id.email);
        EditText txtAddress = findViewById(R.id.address);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String business = txtBusinessName.getText().toString();
                String phone = txtPhone.getText().toString();
                String email = txtEmail.getText().toString();
                String address = txtAddress.getText().toString();

                Intent sendDetail = new Intent(getApplicationContext(), CardScreen.class);
                sendDetail.putExtra("name",name);
                sendDetail.putExtra("business",business);
                sendDetail.putExtra("phone",phone);
                sendDetail.putExtra("email",email);
                sendDetail.putExtra("address",address);
                openNewActivity();
                Toast.makeText(getBaseContext(), "Detail Submitted !" , Toast.LENGTH_SHORT ).show();
            }
        });

        img = (ImageView) findViewById(R.id.uploadImageButton);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageSelect();

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