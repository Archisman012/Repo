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

public class RegisterActivity extends Activity {
    String  mFullName;
    String  mEmail;
    String  mEpassword;
    EditText ename ,email ,password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);

        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        ename=(EditText)findViewById(R.id.reg_fullname);
        email=(EditText)findViewById(R.id.reg_email);
        password=(EditText)findViewById(R.id.reg_password);
        Button regDone=(Button) findViewById(R.id.btnRegister);

        regDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFullName=ename.getText().toString();
                mEmail=email.getText().toString();
                mEpassword=password.getText().toString().trim();
                SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                editor.putString("name", mFullName);
                editor.putString("ename", mEmail);
                editor.putString("pname", mEpassword);
                editor.apply();
                Log.d("Archisaman"  ," mFullName--"+ mFullName + "mEmail-- " +mEmail +"mEpassword " +mEpassword);


                Toast.makeText(getApplicationContext(), "Registration Successful login to your account", Toast.LENGTH_LONG).show();


                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });
    }
}