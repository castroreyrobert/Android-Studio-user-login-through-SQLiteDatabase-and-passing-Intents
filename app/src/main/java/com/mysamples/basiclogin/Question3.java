package com.mysamples.basiclogin;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {
    private static RadioGroup radioGroupQ3;
    private static RadioButton radioButtonSelectedQ3, radioButton49;
    int selected_id_q3, x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        x3 = getIntent().getExtras().getInt("correct_answer2");
        onButtonSelectQ3Clicked();

    }

    public void onButtonSelectQ3Clicked(){

        radioGroupQ3 = (RadioGroup)findViewById(R.id.radioGroupQ3);
        Button buttonSelectQ3 = (Button)findViewById(R.id.buttonSelectQ3);

        buttonSelectQ3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         selected_id_q3 = radioGroupQ3.getCheckedRadioButtonId();
                        radioButtonSelectedQ3 = (RadioButton)findViewById(selected_id_q3);
                        radioButton49 = (RadioButton)findViewById(R.id.radioButton49);


                        if(radioButtonSelectedQ3==radioButton49){
                            x3++;
                            Toast.makeText(Question3.this, "You selected " +
                                    radioButtonSelectedQ3.getText().toString(), Toast.LENGTH_SHORT).show();
                            showMessage();

                        }else{
                            Toast.makeText(Question3.this, "You selected " +
                                    radioButtonSelectedQ3.getText().toString(), Toast.LENGTH_SHORT).show();
                            showMessage();
                        }


                    }
                }
        );
    }

    public void showMessage(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Question3.this);
        alertDialog.setMessage("You have " + x3 + " correct answers");
        alertDialog.setTitle("Overview");
        AlertDialog alert = alertDialog.create();
        alert.show();
    }
}
