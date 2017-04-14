package com.example.yara.cattlemonitor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btnLogin;
    EditText editTextEmail;
    EditText editTextPassword;

    FirebaseAuth firebaseAuth ;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();




    }

    public void initializeViews ()
    {
        btnLogin =(AppCompatButton) findViewById(R.id.btnLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        btnLogin.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void userLogin ()
    {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                            createUserSession();
                            Intent intent = new Intent(getApplicationContext() , Home.class);
                            startActivity(intent);
                        }
                        else if (!task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

    public void createUserSession ()
    {
        String userId = firebaseAuth.getCurrentUser().getUid() ;

        SharedPreferences preferences =  getApplicationContext().getSharedPreferences("Login session" , 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("Current user id" , userId);
        editor.commit();
    }



    @Override
    public void onClick(View v) {
        userLogin();
    }
}
