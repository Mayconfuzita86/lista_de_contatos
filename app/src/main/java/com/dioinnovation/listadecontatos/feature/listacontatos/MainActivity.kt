package com.dioinnovation.listadecontatos.feature.listacontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dioinnovation.listadecontatos.R
import com.dioinnovation.listadecontatos.bases.BaseActivity
import com.dioinnovation.listadecontatos.feature.listacontatos.adapter.ContatoAdapter
import com.dioinnovation.listadecontatos.feature.listacontatos.model.ContatosVO
import com.dioinnovation.listadecontatos.singleton.ContatoSingleton

class MainActivity : BaseActivity() {

    private var adapter:ContatoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gerarListaDeContatos()
        setupToolBar(toolBar, "Lista de contatos",false)
        setupLisView()

    }

    private fun gerarListaDeContatos() {
        ContatoSingleton.lista.add(ContatosVO(1, "Paulo", "(12)9999-0000"))
        ContatoSingleton.lista.add(ContatosVO(2, "Pedro", "(12)8888-1234"))
        ContatoSingleton.lista.add(ContatosVO(3, "Marcos", "(12)9898-5678"))
    }

    private fun setupLisView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContatoAdapter(this,ContatoSingleton.lista) {onClickItemRecyclerView(it)}
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }


}