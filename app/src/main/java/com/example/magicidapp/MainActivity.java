package com.example.magicidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                if(etID.getText().toString().isEmpty() || etID.getText().toString().length() != 13){
                    Toast.makeText(MainActivity.this, "Please enter valid id number", Toast.LENGTH_SHORT).show();
                }
                else{
//                    trim will delete any whitespaces leading and trailing
                    String idNumber =  etID.getText().toString().trim();

                    int month = Integer.parseInt(idNumber.substring(2,4));
                    int day = Integer.parseInt(idNumber.substring(4,6));
                    int nationality = Integer.parseInt(idNumber.substring(10,11));

                    if((month>12) || (day>31) || !(nationality==0 || nationality==1)) {
                        Toast.makeText(MainActivity.this, "Please enter valid id number", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String dob = idNumber.substring(4,6) + "/" + idNumber.substring(2,4)+"/"+idNumber.substring(0,2);

//                String gender = idNumber.substring(6,10);
                        int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                        String sGender;
                        if(gender < 5){
                            sGender = getString(R.string.female);
                        }
                        else{
                            sGender = getString(R.string.male);
                        }

//                String citizenship = idNumber.substring(10,11);
                        int citizenship = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                        String sCitizenship;
                        if(citizenship == 1){
                            sCitizenship = getString(R.string.pr);
                        }
                        else{
                            sCitizenship = getString(R.string.sac);
                        }

                        String txt = getString(R.string.dob)+ dob+ getString(R.string.newline)+getString(R.string.gender)+sGender + getString(R.string.newline)+ getString(R.string.citizenship)+sCitizenship;

                        tvResults.setText(txt);
                    }

                }


            }
        });

    }
}