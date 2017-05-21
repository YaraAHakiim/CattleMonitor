package com.example.yara.cattlemonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddEmployee extends AppCompatActivity implements ValueEventListener {

    AppCompatButton addEmployee ;
    EditText empName ;
    EditText empEmail ;
    EditText empPassword ;
    EditText empConfirmPassword ;
    EditText empPhoneNumber ;

    String managerId;
    String farmName ;

    User user ;
    User manager ;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();

        SharedPreferences preferences = getSharedPreferences("Login session", Context.MODE_PRIVATE);
         managerId = preferences.getString("Current user id", null) ;

        databaseReference = FirebaseDatabase.getInstance().getReference("Users") ;
        databaseReference.equalTo(managerId).addListenerForSingleValueEvent(this);

        Toast.makeText(getApplicationContext(), managerId , Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), farmName , Toast.LENGTH_LONG).show();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void initializeViews ()
    {
        empName = (EditText) findViewById(R.id.empName);
        empEmail = (EditText) findViewById(R.id.empEmail);
        empPassword = (EditText) findViewById(R.id.empPassword);
        empConfirmPassword = (EditText) findViewById(R.id.empConfirmPassword);
        empPhoneNumber = (EditText) findViewById(R.id.empPhoneNumber);
    }

    private void addEmp ()
    {
        String name = empName.getText().toString();
        String email = empEmail.getText().toString();

        String phoneNumber = empPhoneNumber.getText().toString();
        String userId = firebaseAuth.getCurrentUser().getUid() ;




        databaseReference = FirebaseDatabase.getInstance().getReference("Users") ;
        databaseReference.equalTo(managerId).addListenerForSingleValueEvent(this);






        //user = new User(name,email,phoneNumber,farmName,"Farmer");
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        /*if (dataSnapshot.exists())
        {
           Toast.makeText(getApplicationContext() , "Found" , Toast.LENGTH_LONG).show();

            manager = dataSnapshot.getValue(User.class);
            farmName = manager.getFarmName();
        }*/
        //System.out.println("ay7aga" + dataSnapshot.getValue());

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
