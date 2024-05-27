package com.quantumsoft.laboratorio04;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivityJava extends AppCompatActivity implements BlankFragmentJava.ClickBtnEnviarCuenta {
    private TextView txtName;
    private TextView txtLastName;
    private TextView txtEmail;
    private TextView txtPhone;
    private TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtUsername = findViewById(R.id.txtUsername);

        BlankFragmentJava blankFragment = BlankFragmentJava.newInstance(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, blankFragment);
        transaction.commit();
    }

    @Override
    public void onClick(AccountEntity account) {
        txtName.setText(account.getFirstname());
        txtLastName.setText(account.getLastname());
        txtEmail.setText(account.getEmail());
        txtPhone.setText(account.getPhone());
        txtUsername.setText(account.getUsername());
    }
}