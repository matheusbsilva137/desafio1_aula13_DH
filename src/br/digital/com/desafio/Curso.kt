package br.digital.com.desafio

class Curso (val codCurso: Int,
             var nome: String,
             var quantMaxAlunos: Int,
             var profTit: ProfessorTitular,
             var profAdj: ProfessorAdjunto){

    private val alunosMatriculados = mutableMapOf<Int, Aluno>()
    private val profTitAnteriores = mutableSetOf<Int>()
    private val profAdjAnteriores = mutableSetOf<Int>()

    override fun equals(other: Any?): Boolean {
        return if (other !is Curso) false
        else (other.codCurso == this.codCurso)
    }

    fun trocarProfessorTit(novoProfTit: ProfessorTitular){
        if (profAdj.codProfessor != novoProfTit.codProfessor)
            profTitAnteriores.add(profTit.codProfessor)
        profTit = novoProfTit
    }

    fun trocarProfessorAdj(novoProfAdj: ProfessorAdjunto){
        if (profAdj.codProfessor != novoProfAdj.codProfessor)
            profAdjAnteriores.add(profAdj.codProfessor)
        profAdj = novoProfAdj
    }

    fun adicionarAlunos(vararg alunos: Aluno){
        alunos.forEach {
            adicionarUmAluno(it)
        }
    }

    fun adicionarUmAluno(umAluno: Aluno){
        if (!alunosMatriculados.containsKey(umAluno.codAluno) && quantMaxAlunos >= alunosMatriculados.size + 1)
            alunosMatriculados[umAluno.codAluno] = umAluno
    }

    fun excluirAluno(umAluno: Aluno){
        if (!alunosMatriculados.containsKey(umAluno.codAluno))
            alunosMatriculados.remove(umAluno)

    }
}