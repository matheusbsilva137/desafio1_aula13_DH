package br.digital.com.desafio

import java.lang.Exception
import java.lang.IllegalStateException

class DigitalHouseManager {
    val listaAlunos = mutableMapOf<Int, Aluno>()
    val listaProfessores = mutableMapOf<Int, Professor>()
    val listaCursos = mutableMapOf<Int, Curso>()
    val listaMatriculas = mutableMapOf<Int, Matricula>()

    fun registrarCurso(nome: String, quantidadeMaximaDeAlunos: Int) : Int{
        var novoCurso = Curso(nome, quantidadeMaximaDeAlunos)
        listaCursos[novoCurso.codCurso] = novoCurso
        return novoCurso.codCurso
    }

    fun excluirCurso(codigoCurso: Int){
        if (listaCursos.containsKey(codigoCurso))
            listaCursos.remove(codigoCurso)
        else throw IllegalArgumentException("Curso não cadastrado no sistema!")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int): Int{
        var novoProfAdj = ProfessorAdjunto(codigoProfessor, nome, sobrenome, quantidadeDeHoras)
        listaProfessores[codigoProfessor] = novoProfAdj
        return novoProfAdj.codProfessor
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String,  codigoProfessor: Int, especialidade: String): Int{
        var novoProfTit = ProfessorTitular(codigoProfessor, nome, sobrenome, especialidade)
        listaProfessores[codigoProfessor] = novoProfTit
        return novoProfTit.codProfessor
    }

    fun excluirProfessor(codigoProfessor: Int){
        if (listaProfessores.containsKey(codigoProfessor))
            listaProfessores.remove(codigoProfessor)
        else throw IllegalArgumentException("Professor não cadastrado no sistema!")
    }

    fun registrarAluno(nome: String, sobrenome: String): Int{
        var novoAluno = Aluno(nome, sobrenome)
        listaAlunos[novoAluno.codAluno] = novoAluno
        return novoAluno.codAluno
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int): Int{
        var aluno = listaAlunos[codigoAluno] ?: throw IllegalArgumentException("Aluno não cadastrado no sistema!")
        var curso = listaCursos[codigoCurso] ?: throw IllegalArgumentException("Curso não cadastrado no sistema!")

        if (!curso.adicionarUmAluno(aluno)) throw IllegalStateException("O número máximo de alunos no curso já foi atingido!")

        var novaMatricula = Matricula(aluno, curso)
        listaMatriculas[novaMatricula.rm] = novaMatricula
        return novaMatricula.rm
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var curso = listaCursos[codigoCurso] ?: throw IllegalArgumentException("Curso não cadastrado no sistema!")
        var profTit = listaProfessores[codigoProfessorTitular]  ?: throw IllegalArgumentException("Professor Titular não cadastrado no sistema!")
        var profAdj = listaProfessores[codigoProfessorAdjunto]  ?: throw IllegalArgumentException("Professor Adjunto não cadastrado no sistema!")
        if (profTit is ProfessorTitular && profAdj is ProfessorAdjunto){
            curso.trocarProfessorTit(profTit)
            curso.trocarProfessorAdj(profAdj)
        }else throw IllegalArgumentException("Algum dos professores não é da categoria indicada!")
    }
}