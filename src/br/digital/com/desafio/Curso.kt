package br.digital.com.desafio

class Curso (var codCurso: Int, var nome: String){
    override fun equals(other: Any?): Boolean {
        return if (other !is Curso) false
        else (other.codCurso == this.codCurso)
    }
}