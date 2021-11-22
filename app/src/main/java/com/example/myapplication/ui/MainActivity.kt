package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.utils.autenticar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        val textViewCriar = findViewById<TextView>(R.id.text_view_criar)
        val buttonEntrar = findViewById<Button>(R.id.button_entrar)

        val editEmail = findViewById<EditText>(R.id.ediText_email)
        val editSenha = findViewById<EditText>(R.id.ediText_senha)

        buttonEntrar.setOnClickListener {
            val autenticou = autenticar(
                    editEmail.text.toString(),
                    editSenha.text.toString(),
                    this)

            if (autenticou) {
                val intent = Intent(
                        this,
                        DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario ou senha incorreta", Toast.LENGTH_SHORT).show()
            }
        }

       textViewCriar.setOnClickListener{
           val abrirNovoUsuarioActivity =
                   Intent(this, NovoUsuarioActivity::class.java)
           startActivity((abrirNovoUsuarioActivity))
       }

    }


}