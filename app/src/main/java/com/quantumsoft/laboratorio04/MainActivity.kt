package com.quantumsoft.laboratorio04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var txtName:TextView
    private lateinit var txtLastName:TextView
    private lateinit var txtEmail:TextView
    private lateinit var txtPhone:TextView
    private lateinit var txtUsername:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtName=findViewById<TextView>(R.id.txtName)
        txtLastName=findViewById<TextView>(R.id.txtLastName)
        txtEmail=findViewById<TextView>(R.id.txtEmail)
        txtPhone=findViewById<TextView>(R.id.txtPhone)
        txtUsername=findViewById<TextView>(R.id.txtUsername)

        val blankFragment=BlankFragment.newInstance(response)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, blankFragment)
        }
    }


    val response:(AccountEntity)->Unit={account->
        txtName.text=account.firstname
        txtLastName.text=account.lastname
        txtEmail.text=account.email
        txtPhone.text=account.phone
        txtUsername.text=account.username
    }

}