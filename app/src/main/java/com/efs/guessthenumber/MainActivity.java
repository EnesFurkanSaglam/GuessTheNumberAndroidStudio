package com.efs.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRemainingRight;
    private TextView textViewConclusion;
    private EditText editTextNumber;
    private String value;
    private int remainingRight = 3;
    private int randomNumber;
    private Random random;
    private boolean isTrueGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewRemainingRight = (TextView)findViewById(R.id.textViewRemainingRight);
        textViewConclusion = (TextView) findViewById(R.id.textViewConclusion);
        editTextNumber = (EditText) findViewById(R.id.editTextEnter);
        random = new Random();
        randomNumber = random.nextInt(5);
        System.out.println("Random Number : " + randomNumber); // I can see the number value in logcat
    }

    public void btnGuess(View view){
        value = editTextNumber.getText().toString();
        if (!TextUtils.isEmpty(value)){
            if (remainingRight>0 && isTrueGuess == false){
                if (value.equals(String.valueOf(randomNumber))){
                    Conclusion("Congratulations");
                    isTrueGuess = true;
                }
                else{

                    textViewConclusion.setText("Your guess is false.");
                    editTextNumber.setText("");
                }
                remainingRight--;
                textViewRemainingRight.setText("Remaining Right : " + remainingRight);
                if (remainingRight == 0 && isTrueGuess == false){
                    Conclusion("Your right to guess is over");
                    editTextNumber.setText(" ");
                }

            }
            else {
                textViewConclusion.setText("Game over!");
            }
        }
        else{
            textViewConclusion.setText("Entered value can not be empty");
        }

    }

    private void Conclusion(String s) {
        editTextNumber.setEnabled(false);
        textViewConclusion.setText(s);
    }
}