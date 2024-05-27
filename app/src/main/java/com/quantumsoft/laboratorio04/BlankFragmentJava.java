package com.quantumsoft.laboratorio04;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class BlankFragmentJava extends Fragment {
    private static ClickBtnEnviarCuenta clickBtnEnviarCuenta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        Button btnEnviarDatos = view.findViewById(R.id.btnOK);
        EditText edtFirstName = view.findViewById(R.id.edtFirstName);
        EditText edtLastName = view.findViewById(R.id.edtLastName);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtPhone = view.findViewById(R.id.edtPhone);
        EditText edtUsername = view.findViewById(R.id.edtUsername);
        EditText edtPassword = view.findViewById(R.id.edtPassword);

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountEntity account = new AccountEntity();
                account.setFirstname(edtFirstName.getText().toString());
                account.setLastname(edtLastName.getText().toString());
                account.setEmail(edtEmail.getText().toString());
                account.setPhone(edtPhone.getText().toString());
                account.setUsername(edtUsername.getText().toString());
                account.setPassword(edtPassword.getText().toString());

                clickBtnEnviarCuenta.onClick(account);
            }
        });

        return view;
    }

    public static void setClickBtnEnviarCuenta(ClickBtnEnviarCuenta listener) {
        clickBtnEnviarCuenta = listener;
    }

    public static BlankFragmentJava newInstance(ClickBtnEnviarCuenta clickBtnEnviarCuenta) {
        BlankFragmentJava blankFragment = new BlankFragmentJava();
        blankFragment.setClickBtnEnviarCuenta(clickBtnEnviarCuenta);
        return blankFragment;
    }
    public interface ClickBtnEnviarCuenta {
        void onClick(AccountEntity account);
    }
}
