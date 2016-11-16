package com.mysamples.basiclogin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {
    private static RadioGroup radioGroupQ2;
    private static RadioButton radioButtonSelectedQ2, radioButton42;
    int selected_id_Q2, x2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        x2 = getIntent().getExtras().getInt("correct_answer");
        onButtonSelectQ2Clicked();
       // sMainActivity.onClickCorrectAnswer(x)
        //Intent mIntent = getIntent();


    }

    public void onButtonSelectQ2Clicked(){

        radioGroupQ2 = (RadioGroup)findViewById(R.id.radioGroup);

        Button  buttonSelectQ2 = (Button)findViewById(R.id.buttonSelectQ2);

        buttonSelectQ2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selected_id_Q2 = radioGroupQ2.getCheckedRadioButtonId();
                        radioButtonSelectedQ2 =(RadioButton)findViewById(selected_id_Q2);
                        radioButton42 = (RadioButton)findViewById(R.id.radioButton42);

                        if(radioButtonSelectedQ2 == radioButton42){
                        // NEED TO RESEARCH ABOUT PASSING THE VALUE INTO ANOTHER CLASS
                            x2++;
                            Toast.makeText(Question2.this,"You selected " +
                                    radioButtonSelectedQ2.getText().toString(),Toast.LENGTH_SHORT)
                                    .show();

                            Intent iQ2 = new Intent(Question2.this,Question3.class);
                            iQ2.putExtra("correct_answer2", x2);
                            startActivity(iQ2);
                        }else {
                            Toast.makeText(Question2.this, "You selected " +
                                    radioButtonSelectedQ2.getText().toString(), Toast.LENGTH_SHORT).show();
                            Intent iQ2 = new Intent(Question2.this,Question3.class);
                            iQ2.putExtra("correct_answer2", x2);
                            startActivity(iQ2);
                        }
                    }
                }
        );
    }
}
