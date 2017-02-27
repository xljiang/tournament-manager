package com.instinctcoder.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetail extends AppCompatActivity implements android.view.View.OnClickListener{

    Button buttonRegister ,  buttonDelete;
    Button buttonClear;
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);


        buttonRegister.setOnClickListener(this);
        //btnDelete.setOnClickListener(this);
        buttonClear.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);

        editTextUsername.setText(String.valueOf(student.username));
        editTextName.setText(student.name);
        editTextPhone.setText(String.valueOf(student.phone));
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.buttonRegister)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.username=editTextUsername.getText().toString();
            student.phone = editTextPhone.getText().toString();
            student.name=editTextName.getText().toString();
            student.student_ID=_Student_Id;

            if (_Student_Id==0){
                _Student_Id = repo.insert(student);

                Toast.makeText(this,"New Player Added",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(student);
                Toast.makeText(this,"Player Record updated",Toast.LENGTH_SHORT).show();
            }
        }
        else if (view== findViewById(R.id.buttonDelete)){
            Toast.makeText(this, "clicked delete", Toast.LENGTH_SHORT);
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_Student_Id);
            Toast.makeText(this, "Player Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.buttonClear)){
            finish();
        }


    }

}
