package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText n,password;
    TextView label;

    Button  generate;


    String[] genpassword=new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initxml();
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passGen();
                String show= stringBuilder().toString();
                password.setText(show);
                label.setVisibility(View.VISIBLE);
            }
        });






    }

    private void passGen() {
        int value=Integer.parseInt(n.getText().toString());
        int count=0;
        genpassword=new String[value];
        Random r=new Random();
        for(int i=0;i<value/2;i++){
            String N=Integer.toString(r.nextInt(10));
            genpassword[count++]=N;
            String C=Character.toString((char)(r.nextInt(20)+'a'));
            genpassword[count++]=C;

        }

    }


    private StringBuilder stringBuilder() {

        StringBuilder builder= new StringBuilder();
        for(String value:genpassword){
            builder.append(value);
        }
        return builder;

    }

    private void initxml() {
        n=findViewById(R.id.inputN);
        password=findViewById(R.id.password);
        label=findViewById(R.id.textView);
        generate=findViewById(R.id.btngenerate);
    }
}