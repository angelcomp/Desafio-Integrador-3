package com.example.desafiointegrador3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador3.R
import com.example.desafiointegrador3.utils.Usuario
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Click in button login
        iv_btnLogin.setOnClickListener {

            callMain(getInformationUser())
        }

        //clicando no botão cadastrar
        tv_create.setOnClickListener {
            callCadastro()
        }
    }

    //Pega as informações do usuario
    fun getInformationUser(): Usuario {
        val email = et_emailLogin.text.toString()
        val senha = et_senhaLogin.text.toString()

        return Usuario(null, email, senha)
    }

    //Chamando a MainActivity
    fun callMain(usuario: Usuario) {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", usuario)
        startActivity(intent)
    }

    //Chamando a CadastroActivity
    fun callCadastro() {
        var intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}