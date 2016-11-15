package com.mysamples.basiclogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText editTextUsername;
    private static EditText editTextPassword;
    private static TextView textView5;
    int attempts_number = 5;

    DatabaseHelper mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
        onButtonLogInClicked();
        onButtonSignUpClicked();

    }


    public void onButtonLogInClicked(){
        Button buttonLogIn;
        editTextUsername = (EditText)findViewById(R.id.editTextUsername );
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        buttonLogIn = (Button)findViewById(R.id.buttonLogIn);

        textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setText(String.valueOf(attempts_number));


        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //NEED TO RESEARCH ABOUT HOW WE CAN VALIDATE THE USER TO SQLite DATABASE
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String str = mydb.searchPassword(username);


                if (password.equals(str)){
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    //PASSING THE USERNAME.TEXT TO SECONDACTIVITY.CLASS
                    Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                    intent1.putExtra("Username", username);
                    startActivity(intent1);

                }
                else{
                    attempts_number --;
                    textView5.setText(String.valueOf(attempts_number));
                    if (attempts_number==0){
                        finish();
                    }
                    Toast.makeText(MainActivity.this, "Your username and password are incorrect",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onButtonSignUpClicked(){
        Button buttonSignUp;
        buttonSignUp = (Button)findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent iSignUp = new Intent(MainActivity.this,UserSignUp.class);
                        startActivity(iSignUp);
                    }
                }
        );
    }
}
