package com.example.luckyno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editt;
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editt= findViewById(R.id.editt);
        textView=findViewById(R.id.textView);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editt.getText().toString();

                //explicit intent
                Intent i = new Intent(
                        getApplicationContext(),
                        SecondActivity.class);

                //passing the value to other activities
                i.putExtra("name", username);

                startActivity(i);
            }
        });
    }

}