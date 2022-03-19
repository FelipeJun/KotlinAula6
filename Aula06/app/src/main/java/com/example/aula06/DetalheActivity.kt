package com.example.aula06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula06.databinding.ActivityDetalhe2Binding

class DetalheActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetalhe2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhe2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //atribuiu o valor do intent criado na atividae principal
        val nome = intent.getStringExtra("nome")
        //colocou no textview
        binding.textViewNome.text = nome
        binding.buttonIrPrincipal.setOnClickListener{
            val i = Intent(this, PrincipalActivity::class.java)
            startActivity(i)
        }
    }
}