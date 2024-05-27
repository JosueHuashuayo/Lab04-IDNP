package com.quantumsoft.laboratorio04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
class BlankFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_blank, container, false)
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        val btnEnviarDatos = view.findViewById<Button>(R.id.btnOK)
        val edtFirstName = view.findViewById<EditText>(R.id.edtFirstName)
        val edtLastName = view.findViewById<EditText>(R.id.edtLastName)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtPhone= view.findViewById<EditText>(R.id.edtPhone)
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtPassword = view.findViewById<EditText>(R.id.edtPassword)

        btnEnviarDatos.setOnClickListener{
            val account = AccountEntity()
            account.firstname = edtFirstName.text.toString()
            account.lastname = edtLastName.text.toString()
            account.email = edtEmail.text.toString()
            account.phone = edtPhone.text.toString()
            account.username = edtUsername.text.toString()
            account.password = edtPassword.text.toString()

            clickBtnEnviarCuenta(account)
        }
        return view
    }

    companion object {
        private lateinit var clickBtnEnviarCuenta: (AccountEntity) -> Unit
        @JvmStatic
        fun newInstance(clickBtnEnviarCuenta:(AccountEntity)->Unit):BlankFragment{
            val blankFragment=BlankFragment()
            this.clickBtnEnviarCuenta=clickBtnEnviarCuenta
            return blankFragment
        }
    }
}