package com.example.ap4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final  int REQUEST_CODE_MENU = 101;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("data",new SimpleData(100, "hello andorid"));
                startActivityForResult(intent,REQUEST_CODE_MENU );
                //startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        et1 = findViewById(R.id.et1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String data = et1.getText().toString();
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
//                startActivity(intent);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


    }//onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_MENU){
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),"응답으로 전달한 이름 :"+
                        name, Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),
                "화면 전환 onPause", Toast.LENGTH_SHORT).show();

        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),
                "화면 전환 onResum", Toast.LENGTH_SHORT).show();

        restoreState();
    }

    protected void saveState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",et1.getText().toString());
        editor.commit();
    }
    protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref != null) && (pref.contains("name"))){
            Toast.makeText(getApplicationContext(),pref.getString("name",""),
                    Toast.LENGTH_SHORT).show();
        }
    }
}