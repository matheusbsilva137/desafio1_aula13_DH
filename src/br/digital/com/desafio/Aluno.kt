package br.digital.com.desafio

class Aluno (var codAluno: Int, var nome: String, var sobreneome: String){
    override fun equals(other: Any?): Boolean {
        return if (other !is Aluno) false
               else (other.codAluno == this.codAluno)
    }
}