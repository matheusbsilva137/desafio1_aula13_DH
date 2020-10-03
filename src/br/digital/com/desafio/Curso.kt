package br.digital.com.desafio

class Curso (var nome: String,
             var quantMaxAlunos: Int){

    val codCurso: Int
    lateinit var profTit: ProfessorTitular
    lateinit var profAdj: ProfessorAdjunto
    val alunosMatriculados = mutableMapOf<Int, Aluno>()
    val profTitAnteriores = mutableSetOf<Int>()
    val profAdjAnteriores = mutableSetOf<Int>()

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
        if (this::profTit.isInitialized) {
            if (profAdj.codProfessor != novoProfTit.codProfessor)
                profTitAnteriores.add(profTit.codProfessor)
        }
        profTit = novoProfTit
    }

    fun trocarProfessorAdj(novoProfAdj: ProfessorAdjunto){
        if (this::profAdj.isInitialized) {
            if (profAdj.codProfessor != novoProfAdj.codProfessor)
                profAdjAnteriores.add(profAdj.codProfessor)
        }
        profAdj = novoProfAdj
    }

    fun adicionarUmAluno(umAluno: Aluno) : Boolean{
        if (!alunosMatriculados.containsKey(umAluno.codAluno) && quantMaxAlunos >= alunosMatriculados.size + 1) {
            alunosMatriculados[umAluno.codAluno] = umAluno
            return true
        }else return false
    }

    fun excluirAluno(umAluno: Aluno){
        if (alunosMatriculados.containsKey(umAluno.codAluno))
            alunosMatriculados.remove(umAluno.codAluno)
        else throw IllegalArgumentException("Aluno não cadastrado no sistema!")
    }

    fun exibirListaAlunos(){
        alunosMatriculados.forEach {
            println(" [${it.value.codAluno}] - ${it.value.nome} ${it.value.sobrenome}")
        }
    }
}