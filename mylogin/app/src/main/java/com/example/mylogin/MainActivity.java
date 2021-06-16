package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Janhaviii";
    private String Password = "12345";

    boolean isvalid= false;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText)findViewById(R.id.etName);
        ePassword = (EditText)findViewById(R.id.etPassword);
        eLogin = (Button) findViewById(R.id.btnLogin);
        eAttemptsInfo = (TextView) findViewById(R.id.tvAttemptsInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName= eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter all the credentials correctly", Toast.LENGTH_SHORT);
                }else{

                    isvalid=validate (inputName,inputPassword);

                    if(!isvalid){
                        counter--;
                        Toast.makeText(MainActivity.this,"incorrect credentials enytered!",Toast.LENGTH_SHORT);

                        eAttemptsInfo.setText("number of attempts remaining :"+counter);
                        if(counter==0){
                            eLogin.setEnabled(false);
                        }

                    }else{
                        Toast.makeText(MainActivity.this,"login successful!",Toast.LENGTH_LONG).show();;

                        Intent intent= new Intent(MainActivity.this,HomePageActivity.class);
                        startActivity(intent);
                }
            }
        });


    }

    private boolean validate(String Username, String Password){

            if(Username.equals(Username) && Password.equals(Password)){
                return true;

            }

            return false;
        }
    }
}