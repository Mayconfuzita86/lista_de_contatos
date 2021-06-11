package com.dioinnovation.listadecontatos.feature.contato

import android.os.Bundle
import android.view.View
import com.dioinnovation.listadecontatos.R
import com.dioinnovation.listadecontatos.application.ContatoApplication
import com.dioinnovation.listadecontatos.bases.BaseActivity
import com.dioinnovation.listadecontatos.feature.listacontatos.model.ContatosVO
import kotlinx.android.synthetic.main.activity_contato.*
import kotlinx.android.synthetic.main.activity_contato.toolBar

class ContatoActivity : BaseActivity() {

    private var idContato: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        setupToolBar(toolBar, "Contato", true)
        setupContato()
        btnSalvarContato.setOnClickListener { onClickSalvarContato() }
    }


    private fun setupContato() {
        idContato = intent.getIntExtra("index", -1)
        if (idContato == -1) {
            btnExcluirContato.visibility = View.GONE
            return
        }
        var lista = ContatoApplication.instance.helperDB?.buscarContatos("$idContato",true) ?: return
        var contato = lista.getOrNull(0) ?: return
        etNome.setText(contato.nome)
        etTelefone.setText(contato.telefone)

//        etNome.setText(ContatoSingleton.lista[index].nome)
//        etTelefone.setText(ContatoSingleton.lista[index].telefone)
    }

    private fun onClickSalvarContato() {
        val nome = etNome.text.toString()
        val telefone = etTelefone.text.toString()
        val contato = ContatosVO(
            idContato,
            nome,
            telefone
        )
        if (idContato == -1) {
//            ContatoSingleton.lista.add(contato)
            ContatoApplication.instance.helperDB?.salvarContato(contato)
        } else {
            ContatoApplication.instance.helperDB?.updateContato(contato)
//            ContatoSingleton.lista.set(index, contato)
        }
        finish()
    }

    fun onClickExcluirContato(view: View) {
        if (idContato > -1) {
//            ContatoSingleton.lista.removeAt(index)
              ContatoApplication.instance.helperDB?.deletarContato(idContato)
            finish()
        }
    }
}
