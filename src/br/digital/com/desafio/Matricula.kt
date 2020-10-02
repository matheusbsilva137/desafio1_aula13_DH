package br.digital.com.desafio

import java.util.*

class Matricula {

    var rm: Int
    var aluno: Aluno
    var curso: Curso
    var dataMatricula: Date

    companion object{
        var codigo = 1000000
    }

    constructor(alunoMat: Aluno, cursoMat: Curso) {
        aluno = alunoMat
        curso = cursoMat
        dataMatricula = Date()
        rm = codigo++
    }
}