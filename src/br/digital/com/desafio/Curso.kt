package br.digital.com.desafio

class Curso (var nome: String,
             var quantMaxAlunos: Int){

    val codCurso: Int
    lateinit var profTit: ProfessorTitular
    lateinit var profAdj: ProfessorAdjunto
    private val alunosMatriculados = mutableMapOf<Int, Aluno>()
    private val profTitAnteriores = mutableSetOf<Int>()
    private val profAdjAnteriores = mutableSetOf<Int>()

    companion object{
        var codigo = 1
    }

    init{
        codCurso = codigo++
    }

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

    fun adicionarUmAluno(umAluno: Aluno) : Boolean{
        if (!alunosMatriculados.containsKey(umAluno.codAluno) && quantMaxAlunos >= alunosMatriculados.size + 1) {
            alunosMatriculados[umAluno.codAluno] = umAluno
            return true
        }else return false
    }

    fun excluirAluno(umAluno: Aluno){
        if (!alunosMatriculados.containsKey(umAluno.codAluno))
            alunosMatriculados.remove(umAluno)
        else throw IllegalArgumentException("Aluno não cadastrado no sistema!")
    }
}