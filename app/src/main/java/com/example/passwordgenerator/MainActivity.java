package com.example.passwordgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    EditText n,shwpassword;
    TextView label;
    RecyclerView recyclerView;
    myAdapter adapter;
    String password="";

    Button  generate,save;
    


    String[] genpassword=new String[20];
    ArrayList<String> iteams=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initxml();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter=new myAdapter(fg);
//        recyclerView.setAdapter(adapter);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(n.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter length", Toast.LENGTH_SHORT).show();

                }
                else {
                    passGen();
                    password = stringBuilder().toString();
                    shwpassword.setText(password);
                    label.setVisibility(View.VISIBLE);
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iteams.add(shwpassword.getText().toString());
                adapter=new myAdapter(iteams);
                recyclerView.setAdapter(adapter);


            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selected = item.getItemId();
        if(selected==R.id.settingmenu){
            Toast.makeText(this, "selectMenu is selected", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    private void passGen() {



            Integer value=Integer.parseInt(n.getText().toString());
            int count = 0;
            genpassword = new String[value];
            Random r = new Random();
            for (int i = 0; i < value / 2; i++) {
                String N = Integer.toString(r.nextInt(10));
                genpassword[count++] = N;
                String C = Character.toString((char) (r.nextInt(20) + 'a'));
                genpassword[count++] = C;

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
        shwpassword=findViewById(R.id.password);
        label=findViewById(R.id.textView);
        generate=findViewById(R.id.btngenerate);
        recyclerView=findViewById(R.id.recyclerView);
        save=findViewById(R.id.save);

    }
}