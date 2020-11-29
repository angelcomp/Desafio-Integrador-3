package com.example.desafiointegrador3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiointegrador3.R
import com.example.desafiointegrador3.utils.Usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuario = intent.getSerializableExtra("user") as? Usuario

        if (usuario != null) {
            if (usuario.nome != null) {
                showToast("Bem-Vindo(a) ${usuario!!.nome}")
            } else {
                showToast("Bem-Vindo(a)")
            }
        }
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}