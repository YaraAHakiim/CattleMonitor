package com.example.yara.cattlemonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
public class AddUserActivity extends AppCompatActivity {

    EditText editTextName ;
    EditText editTextEmail ;
    EditText editTextPassword ;
    EditText editTextConfirmPassword ;
    EditText editTextPhoneNumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        initializeViews();

        validate();

    }

    public void initializeViews()
    {
        editTextName =(EditText) findViewById(R.id.editTextName);
        editTextEmail =(EditText) findViewById(R.id.editTextEmail);
        editTextPassword =(EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword =(EditText) findViewById(R.id.editTextConfirmPassword);
        editTextPhoneNumber =(EditText) findViewById(R.id.editTextPhoneNumber);
    }

    boolean validate ()
    {
        boolean isValid = true;

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();

        if(name.isEmpty())
        {
            editTextName.setError("Please enter your name");
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email address");
            isValid = false;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Please enter a password");
            isValid = false;
        }

        if(confirmPassword.isEmpty() || !confirmPassword.equals(password))
        {
            editTextConfirmPassword.setError("Passwords must match");
            isValid = false;
        }

        if(phoneNumber.isEmpty() || !Patterns.PHONE.matcher(phoneNumber).matches())
        {
            editTextPhoneNumber.setError("Please enter a valid phone number");
            isValid = false;
        }



        return isValid;
    }


}
