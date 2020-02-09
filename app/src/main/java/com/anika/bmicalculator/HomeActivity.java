package com.anika.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView txtResult,txtResult2;
    EditText etHeight,etWeight;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtResult=findViewById(R.id.txt_result);
        txtResult2=findViewById(R.id.txt_result2);

        etHeight=findViewById(R.id.et_height);
        etWeight=findViewById(R.id.et_weight);

        btnSubmit=findViewById(R.id.btn_submit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height=etHeight.getText().toString();
                String weight=etWeight.getText().toString();

                if(height.isEmpty() || weight.isEmpty())
                {
                    Toast.makeText(HomeActivity.this, "Plz input height & weight", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Double value1=Double.parseDouble(height);
                    Double value2=Double.parseDouble(weight);

                    double value3=(value1/39.37);

                    double result=value2/((value3)*(value3));

                    txtResult.setText(""+result);
                    if(result<18.5)
                    {
                        txtResult2.setText("Underweight");
                    }
                    else if(result>=18.5 && result<=24.9)
                    {
                        txtResult2.setText("Normal");
                    }
                    else if(result>=25 && result<=29.9)
                    {
                        txtResult2.setText("Overweight");
                    }
                    else if(result>=30 && result<=34.9)
                    {
                        txtResult2.setText("Obesity 1");
                    }
                    else
                    {
                        txtResult2.setText("Obesity 2");
                    }
                }
            }
        });
    }
}
