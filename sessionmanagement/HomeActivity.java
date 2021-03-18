package com.solution.sessionmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView tvname,tvemail;
    Button Logoutbutton,deletename,deleteemail,deleteboth;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="surbhi";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvname=findViewById(R.id.name);
        tvemail=findViewById(R.id.email);
        Logoutbutton=findViewById(R.id.Logoutbutton);
        deletename=findViewById(R.id.deletename);
        deleteemail=findViewById(R.id.deleteemail);
        deleteboth=findViewById(R.id.deleteboth);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);
        if(name !=null || email !=null)
        {
            tvname.setText("Full Name:"+name);
            tvemail.setText("Email is:"+email);
        }
//remove data from name
        deletename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor2=sharedPreferences.edit();
                editor2.remove(name);
                tvname.setText("");
                editor2.commit();
                Toast.makeText(HomeActivity.this, "Data Deleted from name", Toast.LENGTH_SHORT).show();
            }
        });
        //remove data from name
        deleteemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor2=sharedPreferences.edit();
                editor2.remove(email);
                tvemail.setText("");
                editor2.commit();
                Toast.makeText(HomeActivity.this, "Data Deleted from email", Toast.LENGTH_SHORT).show();
            }
        });
        //remove data from name
        deleteboth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor2=sharedPreferences.edit();
                editor2.clear();
                tvname.setText("");
                tvemail.setText("");
                editor2.commit();
                Toast.makeText(HomeActivity.this, "Data Deleted from both", Toast.LENGTH_SHORT).show();
            }
        });

        Logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                Toast.makeText(HomeActivity.this, "Logout Succeessfull", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}