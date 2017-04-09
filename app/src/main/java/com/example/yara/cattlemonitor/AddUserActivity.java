package com.example.yara.cattlemonitor;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName ;
    EditText editTextEmail ;
    EditText editTextPassword ;
    EditText editTextConfirmPassword ;
    EditText editTextPhoneNumber ;
    AppCompatButton register;

    User user;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        initializeViews();



    }

    public void registerUser()
    {
        firebaseAuth = FirebaseAuth.getInstance();

        if(validate()) {

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                            else if (!task.isSuccessful())
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    public void initializeViews()
    {
        editTextName =(EditText) findViewById(R.id.editTextName);
        editTextEmail =(EditText) findViewById(R.id.editTextEmail);
        editTextPassword =(EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword =(EditText) findViewById(R.id.editTextConfirmPassword);
        editTextPhoneNumber =(EditText) findViewById(R.id.editTextPhoneNumber);

        register = (AppCompatButton) findViewById(R.id.btn_signup);
        register.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
    }

    public void fillUserInfo()
    {
        user = new User();
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

        if (password.length()<6)
        {
            editTextPassword.setError("Password must be at least 6 chars");
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

    @Override
    public void onClick(View view) {
        //calling register method on click
        registerUser();
    }


}
