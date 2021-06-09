package com.dioinnovation.listadecontatos.feature.listacontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dioinnovation.listadecontatos.R
import com.dioinnovation.listadecontatos.feature.listacontatos.model.ContatosVO
import com.dioinnovation.listadecontatos.singleton.ContatoSingleton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gerarListaDeContatos()
    }

    private fun gerarListaDeContatos() {
        ContatoSingleton.lista.add(ContatosVO(1, "Paulo", "(12)9999-0000"))
        ContatoSingleton.lista.add(ContatosVO(2, "Pedro", "(12)8888-1234"))
        ContatoSingleton.lista.add(ContatosVO(3, "Marcos", "(12)9898-5678"))
    }
}