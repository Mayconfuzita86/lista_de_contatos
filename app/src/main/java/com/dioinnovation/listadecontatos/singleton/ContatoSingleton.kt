package com.dioinnovation.listadecontatos.singleton

import com.dioinnovation.listadecontatos.feature.listacontatos.model.ContatosVO

object ContatoSingleton {
    var lista: MutableList<ContatosVO> = mutableListOf()
}