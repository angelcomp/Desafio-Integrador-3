package com.example.desafiointegrador3.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador3.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        iv_btnLogin.setOnClickListener {
            callCadastro()
        }
    }

    //Chamando a CadastroActivity
    fun callCadastro(){
        var intent = Intent(this, CadastroActivity::class.java)

        startActivity(intent)
    }
}