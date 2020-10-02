package br.digital.com.desafio

import java.util.*

class Matricula {

    var aluno: Aluno
    var curso: Curso
    var dataMatricula: Date

    constructor(alunoMat: Aluno, cursoMat: Curso) {
        aluno = alunoMat
        curso = cursoMat
        dataMatricula = Date()
    }
}