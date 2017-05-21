package com.example.yara.cattlemonitor;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Tab2Employees extends Fragment implements View.OnClickListener {

    AppCompatButton addEmployee ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2employees, container, false);

        addEmployee = (AppCompatButton) rootView.findViewById(R.id.addEmployee);
        addEmployee.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), AddEmployee.class);
        startActivity(intent);

    }
}
