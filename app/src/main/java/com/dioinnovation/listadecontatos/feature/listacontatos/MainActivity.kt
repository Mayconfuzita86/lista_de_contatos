package com.dioinnovation.listadecontatos.feature.listacontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dioinnovation.listadecontatos.R
import com.dioinnovation.listadecontatos.bases.BaseActivity
import com.dioinnovation.listadecontatos.feature.contato.ContatoActivity
import com.dioinnovation.listadecontatos.feature.listacontatos.adapter.ContatoAdapter
import com.dioinnovation.listadecontatos.feature.listacontatos.model.ContatosVO
import com.dioinnovation.listadecontatos.singleton.ContatoSingleton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private var adapter:ContatoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gerarListaDeContatos()
        setupToolBar(toolBar, "Lista de contatos",false)
        setupListView()
        setupOnClicks()
    }

    private fun setupOnClicks() {
        fab.setOnClickListener { onClickAdd() }
        ivBuscar.setOnClickListener { onClickBuscar() }
    }

    private fun onClickBuscar() {
        val busca = etBuscar.text.toString()
        var listaFiltrada: List<ContatosVO> = ContatoSingleton.lista
        if(!busca.isNullOrEmpty()){
            listaFiltrada = ContatoSingleton.lista.filter { contato ->
                if (contato.nome.lowercase(Locale.getDefault()).contains(busca.lowercase(Locale.getDefault()))){
                    return@filter true
                }
                return@filter false
            }
        }
        adapter = ContatoAdapter(this,listaFiltrada) {onClickItemRecyclerView(it)}
        recyclerView.adapter = adapter
        Toast.makeText(this,"Buscando por $busca", Toast.LENGTH_SHORT).show()
    }

    private fun onClickItemRecyclerView(index: Int) {
        val intent = Intent(this,ContatoActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
    }

    private fun onClickAdd() {
        val intent = Intent(this, ContatoActivity::class.java)
        startActivity(intent)
    }

    private fun gerarListaDeContatos() {
        ContatoSingleton.lista.add(ContatosVO(1, "Paulo", "(12)9999-0000"))
        ContatoSingleton.lista.add(ContatosVO(2, "Pedro", "(12)8888-1234"))
        ContatoSingleton.lista.add(ContatosVO(3, "Marcos", "(12)9898-5678"))
    }

    private fun setupListView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContatoAdapter(this,ContatoSingleton.lista) {onClickItemRecyclerView(it)}
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }
}