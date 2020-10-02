package br.digital.com.desafio

import java.util.*

data class Matricula (var aluno: Aluno, var curso: Curso){

    var rm: Int
    var dataMatricula: Date

    companion object{
        var codigo = 1000000
    }

    init {
        dataMatricula = Date()
        rm = codigo++
    }
}