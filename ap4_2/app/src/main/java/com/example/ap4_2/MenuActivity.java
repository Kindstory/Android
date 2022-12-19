package com.example.ap4_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name","마이크");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            Toast.makeText(getApplicationContext(), data.message+" "+data.number,
                    Toast.LENGTH_SHORT).show();
        }

    }
}
