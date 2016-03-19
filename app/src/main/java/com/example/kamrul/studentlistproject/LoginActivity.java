package com.example.kamrul.studentlistproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,password;
    StudentListManager manager;
    String userName,userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.userPassword);
        manager=new StudentListManager(this);
    }
    public void login(View view){
       // Toast.makeText(LoginActivity.this,"ok",Toast.LENGTH_LONG).show();
        userName=user.getText().toString();
        userPassword=password.getText().toString();
        boolean b=manager.loginChq(userName,userPassword);
      //  Toast.makeText(LoginActivity.this," message "+b,Toast.LENGTH_LONG).show();
        if(b){
            Intent intent=new Intent(LoginActivity.this,LoginSuccessActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(LoginActivity.this,"User name or password Wrong",Toast.LENGTH_LONG).show();
        }


    }
    public void goSignup(View view){
        Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
