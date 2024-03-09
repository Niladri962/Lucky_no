package com.example.luckyno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    Button share;
    TextView luckyno, wel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //creating the obj of the entitity
        share = findViewById(R.id.share);
        luckyno = findViewById(R.id.luckyno);
        wel=findViewById(R.id.wel);

        //Receiving data from main activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int random_num = Randomnuber();
        luckyno.setText(""+ random_num);

        //sharing data using of the app via share button
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedata(userName, random_num);
            }
        });

    }

    //generating random no function
    public int Randomnuber(){
        Random random = new Random();
        //upper limit
        int upper_limit=100;

        int generatedrandom = random.nextInt(upper_limit);
        return generatedrandom;
    }

    //used for sharing no 
    public void sharedata(String username, int generaterandom ){
        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, username + "got lucky no");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky no" + generaterandom);

        startActivity(Intent.createChooser(i, "Choose Platform"));
    }
}