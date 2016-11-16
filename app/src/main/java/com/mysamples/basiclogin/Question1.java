package com.mysamples.basiclogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {
        private static RadioGroup radioGroupQ1;
        private static RadioButton radioButtonSelected, radioButton61;
        int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        onButtonSelectClicked();

    }


    public void onButtonSelectClicked(){
        radioGroupQ1 = (RadioGroup)findViewById(R.id.radioGroupQ1);
        Button buttonSelect = (Button)findViewById(R.id.buttonSelectQ1);

        buttonSelect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int selected_radioButton = radioGroupQ1.getCheckedRadioButtonId();
                        radioButtonSelected = (RadioButton)findViewById(selected_radioButton);
                        radioButton61 = (RadioButton) findViewById(R.id.radioButton61);

                        if(radioButtonSelected == radioButton61 ){
                            x++;
                            Toast.makeText(Question1.this,"You selected " +
                                    radioButtonSelected.getText().toString(),Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent1 = new Intent(Question1.this, Question2.class);
                            intent1.putExtra("correct_answer", x);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(Question1.this,"You selected " +
                                    radioButtonSelected.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(Question1.this, Question2.class);
                            intent1.putExtra("correct_answer", x);
                            startActivity(intent1);
                        }
                    }
                }
        );
    }
}
