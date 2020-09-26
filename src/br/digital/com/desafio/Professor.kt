package br.digital.com.desafio

class Professor (var codProfessor: Int, var nome: String, var sobrenome: String) {
    override fun equals(other: Any?): Boolean {
        return if (other !is Professor) false
        else (other.codProfessor == this.codProfessor)
    }
}