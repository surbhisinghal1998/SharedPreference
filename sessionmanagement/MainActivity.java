package com.solution.sessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailedit,nameedit;
    Button submitbutton;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="surbhi";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailedit=findViewById(R.id.emailedit);
        nameedit=findViewById(R.id.nameedit);
        submitbutton=findViewById(R.id.submitbutton);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);
        if(name !=null && email !=null)
        {
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,nameedit.getText().toString());
                editor.putString(KEY_EMAIL,emailedit.getText().toString());
                editor.apply();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Succeessfull", Toast.LENGTH_SHORT).show();
            }
        });
    }
}