package com.mysamples.basiclogin;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSignUp extends AppCompatActivity {
     EditText editTextUsername, editTextPword, editTextFirstName,
                        editTextLastName, editTextGrade;
     Button buttonCreate, buttonViewAll, buttonUpdate;
    DatabaseHelper mydb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        mydb2 = new DatabaseHelper(this);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPword = (EditText) findViewById(R.id.editTextPWord);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextGrade = (EditText) findViewById(R.id.editTextGradeLevel);
        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonViewAll = (Button)findViewById(R.id.buttonViewAll);
        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        onButtonCreateClicked();
        onButtonViewAll();
        onButtonUpdateClicked();
        //onButtonDeleteClicked();
    }


    public void onButtonCreateClicked(){
        buttonCreate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     Students students = new Students(editTextUsername.getText().toString(),
                            editTextPword.getText().toString(),editTextFirstName.getText().toString(),
                            editTextLastName.getText().toString(),editTextGrade.getText().toString());
                        mydb2.insertData(students);
                        Toast.makeText(UserSignUp.this, "Data is created", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void onButtonViewAll(){
        buttonViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Displaying the data from the database to Alert Dialog
                    Cursor res = mydb2.viewAllData();

                        if (res.getCount() == 0){
                            showMessage("Error", "No Data Found");
                            return;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        while (res.moveToNext()){
                            //stringBuffer.append("ID "+ res.getString(0) + "\n");
                            stringBuffer.append("Username: " + res.getString(1) + "\n");
                            stringBuffer.append("Password: " + res.getString(2) + "\n");
                            stringBuffer.append("First name: " + res.getString(3) + "\n");
                            stringBuffer.append("Last name: " + res.getString(4) + "\n");
                            stringBuffer.append("Grade: " + res.getString(5) + "\n\n");
                        }
                        showMessage("Data",stringBuffer.toString());
                    }
                }
        );
    }


    //Building the alert dialog to the button ViewAllData
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onButtonUpdateClicked(){
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Students students = new Students(editTextUsername.getText().toString(),
                    editTextPword.getText().toString(), editTextFirstName.getText().toString(),
                    editTextLastName.getText().toString(), editTextGrade.getText().toString());
                mydb2.updateData(students);
                Toast.makeText(UserSignUp.this, "Data is updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*public void onButtonDeleteClicked(){
        Button buttonDelete = (Button)findViewById(R.id.buttonDelete);

        buttonDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Students students = new Students(editTextUsername.getText().toString(),
                                editTextPword.getText().toString(),
                                editTextFirstName.getText().toString(),
                                editTextLastName.getText().toString(), editTextGrade.getText().toString());
                        mydb2.deleteData(students);
                    }
                }
        );
    }*/
}
