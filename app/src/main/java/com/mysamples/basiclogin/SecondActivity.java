package com.mysamples.basiclogin;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
        private static Button buttonSwitchImage, buttonProceed, buttonClose;
        private static ImageView imageView;
        private int current_image_index;
        int []images = {R.mipmap.and_image1,R.mipmap.and_image2,R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //RECEIVING THE USERNAME.TEXT FROM MAINACTIVITY.CLASS
        String username = getIntent().getStringExtra("Username");
        TextView textViewQ2Username = (TextView)findViewById(R.id.textViewQ2Username);
        textViewQ2Username.setText(username);


        onButtonSwitchImageClicked();
        onButtonProceedClicked();
        onButtonCloseClicked();
    }

    public void onButtonSwitchImageClicked(){
        imageView = (ImageView)findViewById(R.id.imageView);
        buttonSwitchImage = (Button)findViewById(R.id.buttonSwitchImage);

        buttonSwitchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_image_index++;
                current_image_index = current_image_index%images.length;
                imageView.setImageResource(images[current_image_index]);
            }
        });
    }

     public void onButtonProceedClicked(){
         buttonProceed = (Button)findViewById(R.id.buttonProceed);

         buttonProceed.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intentQ1 = new Intent("com.mysamples.basiclogin.Question1");
                         startActivity(intentQ1);
                     }
                 }
         );
     }

    public void onButtonCloseClicked(){
        buttonClose = (Button)findViewById(R.id.buttonClose);

        buttonClose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(SecondActivity.this);
                        a_builder.setMessage("Do you really want to close this app?")
                                .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        AlertDialog  alertDialog = a_builder.create();
                        alertDialog.setTitle("Overview");
                        alertDialog.show();
                    }
                }
        );
    }
}
