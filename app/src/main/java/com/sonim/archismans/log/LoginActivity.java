package com.sonim.archismans.log;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Activity {
    EditText memail;
    EditText mpassword;
    Button login;
    String mpname ,mpemail ,mppassword;
    String  email =" ";
    String password= " ";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login);

        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
        login = (Button) findViewById(R.id.btnLogin);
        memail=(EditText)findViewById(R.id.email);
        mpassword=(EditText)findViewById(R.id.pwd);
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        mpname= prefs.getString("name", null);
        mpemail = prefs.getString("ename", null);
        mppassword = prefs.getString("pname", null);
        Log.d("Archisman login "  ," name--"+ mpname + "ename-- " +mpemail +"pname " +mppassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            email=memail.getText().toString();
            password=mpassword.getText().toString().trim();
                Log.d("Archisaman login "  ," name--"+ mpname + "ename-- " +mpemail +"pname " +mppassword);
            Log.d("Archisaman click "  ," email--"+ email + "password-- " +password);
            if(mpemail.equals(email) && mppassword.equals(password) )
            {
              Log.d("Archisman" ,"success");
                Toast.makeText(getApplicationContext(), "Welcome to Music App", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
               else
            {
                Log.d("Archisman" ,"fail");
                Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
            }
            }
        });


        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}