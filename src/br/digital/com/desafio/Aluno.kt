package br.digital.com.desafio

class Aluno (var nome: String, var sobrenome: String){

    var codAluno: Int

    companion object{
        var codigo = 1000
    }

    init{
        codAluno = codigo++
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is Aluno) false
               else (other.codAluno == this.codAluno)
    }
}