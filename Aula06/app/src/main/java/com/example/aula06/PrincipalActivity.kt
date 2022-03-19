package com.example.aula06

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import com.example.aula06.databinding.ActivityDetalhe2Binding
import com.example.aula06.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {

    lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        // tem que trocar para binding.root por que ja foi inflado no codigo acima, e abaixo temos que inflar em ambos
        setContentView(binding.root)


        binding.buttonirdetalhe.setOnClickListener{
            //pra chamar outra tela, usamos o metodo Intent, passando como paramentro a atividade atual, e a que vc quer colocando ::class.java
            val i = Intent(this, DetalheActivity::class.java)
            //Passa um valor para a outra atividade, sendo o primeiro paramentro um nome pra chave, e o valor da chave
            i.putExtra("nome",binding.editNome.text.toString())
            startActivity(i)
        }
        /*intents implicito : nao ha uma classe da função ( por exemplo para abrir sites e tals)
          */
        binding.buttonAbrir.setOnClickListener{
            var endereco = binding.editNome.text.toString()
            // tambem tem esse metodo que verifica se a URL é aceitavel ou não
            //URLUtil.isValidUrl()
            //Daria para usar o contains tambem, mas a busca seria na string inteira
            if(endereco.startsWith("http")){
                val uri = Uri.parse(endereco)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
//            else{
//                endereco = "http://${endereco}"
//                val uri = Uri.parse(endereco)
//                val i = Intent(Intent.ACTION_VIEW, uri)
//                startActivity(i)
//            }

        }


    }
}