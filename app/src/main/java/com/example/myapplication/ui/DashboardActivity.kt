package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.utils.calcularIdade
import com.example.myapplication.utils.convertBase64ToBitmap

class DashboardActivity : AppCompatActivity() {

    lateinit var  tvNome: TextView
    lateinit var  tvProfissao: TextView
    lateinit var  tvImc: TextView
    lateinit var  tvNcd: TextView
    lateinit var  tvPeso: TextView
    lateinit var  tvIdade: TextView
    lateinit var  tvAltura: TextView
    lateinit var  ivPerfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.dash_nome)
        tvProfissao = findViewById(R.id.dash_profissao)
        tvImc = findViewById(R.id.dash_imc)
        tvNcd = findViewById(R.id.dash_ncd)
        tvPeso = findViewById(R.id.dash_peso)
        tvIdade = findViewById(R.id.dash_idade)
        tvAltura = findViewById(R.id.dash_altura)
        ivPerfil = findViewById(R.id.iv_dash_Perfil)

        carregarDashboard()
    }
    private fun carregarDashboard(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        val bitMap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitMap)
    }
}