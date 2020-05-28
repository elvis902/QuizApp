package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup q1RadioGroup, q4RadioGroup;
    RadioButton q1RadioButton,q4RadioButton;
    CheckBox q2CheckBox1, q2CheckBox2, q2CheckBox3, q5CheckBox1, q5CheckBox2, q5CheckBox3;
    EditText q3EditText, q6EditText;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1RadioGroup = (RadioGroup)findViewById(R.id.q1RadioGroup);
        q4RadioGroup = (RadioGroup)findViewById(R.id.q4RadioGroup);

        q3EditText = (EditText)findViewById(R.id.q3EditText);
        q6EditText = (EditText)findViewById(R.id.q6EditText);

        q2CheckBox1 = (CheckBox)findViewById(R.id.q2CheckBox1);
        q2CheckBox2 = (CheckBox)findViewById(R.id.q2CheckBox2);
        q2CheckBox3 = (CheckBox)findViewById(R.id.q2CheckBox3);
        q5CheckBox1 = (CheckBox)findViewById(R.id.q5CheckBox1);
        q5CheckBox2 = (CheckBox)findViewById(R.id.q5CheckBox2);
        q5CheckBox3 = (CheckBox)findViewById(R.id.q5CheckBox3);


    }

    public String question1()
    {
        int selectedId = q1RadioGroup.getCheckedRadioButtonId();
        q1RadioButton = (RadioButton)findViewById(selectedId);
        return q1RadioButton.getText().toString();
    }

    public String question3()
    {
        return q3EditText.getText().toString();
    }
    public String question4()
    {
        int selectedId = q4RadioGroup.getCheckedRadioButtonId();
        q4RadioButton = (RadioButton)findViewById(selectedId);
        return q4RadioButton.getText().toString();
    }
    public String question6()
    {
        return q6EditText.getText().toString();
    }



    //Function for submit button
    public void submitAnswer(View view)
    {
        //For Question1: Answer is Mercury
        String q1Answer = question1();
        if(q1Answer.equals("Mercury"))
            score += 1;
        else
            score += 0;

        //For Question2: Answer is Propane & Butane
        if(q2CheckBox1.isChecked() && !q2CheckBox2.isChecked() && q2CheckBox3.isChecked())
            score += 1;
        else
            score += 0;

        //For Question3: Answer is Anemometer
        String q3Answer = question3();
        if(q3Answer.equals("ANEMOMETER") || q3Answer.equals("anemometer") || q3Answer.equals("Anemometer") )
            score += 1;
        else
            score += 0;


        //For Question4: Answer is 12
        String q4Answer = question4();
        if(q4Answer.equals("12"))
            score += 1;
        else
            score += 0;

        //For Question5: Answer is Pineapple & Ham
        if(q5CheckBox1.isChecked() && q5CheckBox2.isChecked() && !q5CheckBox3.isChecked())
            score += 1;
        else
            score += 0;

        //For Question6: Answer is Blue
        String q6Answer = question6();
        if(q6Answer.equals("BLUE") || q6Answer.equals("blue") || q6Answer.equals("Blue"))
            score += 1;
        else
            score += 0;


       Toast.makeText(this, "You have scored "+String.valueOf(score)+"\nThank You!", Toast.LENGTH_LONG).show();
       score = 0;
    }
}
