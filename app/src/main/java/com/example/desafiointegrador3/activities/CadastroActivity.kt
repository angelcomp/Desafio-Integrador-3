package com.example.desafiointegrador3.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador3.R
import com.example.desafiointegrador3.utils.Usuario
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        iv_btnCadastro.setOnClickListener {
            callMain(getInformationUser())
        }
    }

    //Pega as informações do usuario
    fun getInformationUser(): Usuario {
        val nome = et_nameCadastro.text.toString()
        val email = et_emailCadastro.text.toString()
        val senha = et_senhaCadastro.text.toString()

        return Usuario(nome, email, senha)
    }

    //Chamando a MainActivity
    fun callMain(usuario: Usuario) {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", usuario)
        startActivity(intent)
    }
}