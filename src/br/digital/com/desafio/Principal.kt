package br.digital.com.desafio

fun main(){
    var op = 1
    var cont: Int
    var ent: String?
    val dhm = DigitalHouseManager()

    loop@ while (op != 0) {
        try {
            espaco(3)
            println(" [ -------- DIGITAL HOUSE -------]")
            println(" * Opções:")
            println(" [0] - Sair do sistema;")
            println(" [1] - Cadastrar Aluno(s);")
            println(" [2] - Cadastrar Professor(es);")
            println(" [3] - Cadastrar Curso(s);")
            println(" [4] - Excluir Professor(es);")
            println(" [5] - Excluir Curso(s);")
            println(" [6] - Matricular Aluno(s);")
            println(" [7] - Alocar Professor(es);")
            print(" >>> ")
            do ent = readLine() while (ent == null)
            op = if (ent.isNotEmpty()) ent.toInt() else -1

            when (op) {
                0 -> break@loop
                1 -> {
                    var quantCadastros = 0
                    var nome: String?
                    var sobrenome: String?

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- CADASTRO DE ALUNO ----]")

                        quantCadastros++
                        print(" - Nome: ")
                        do nome = readLine() while (nome == null)

                        print(" - Sobrenome: ")
                        do sobrenome = readLine() while (sobrenome == null)

                        println(" - Aluno registrado com o código ${dhm.registrarAluno(nome, sobrenome)}.")
                        espaco(2)

                        println("Deseja cadastrar mais um aluno?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantCadastros cadastros de alunos realizados!")
                    pressEnter()
                }
                2 -> {
                    var quantCadastros = 0
                    var nome: String?
                    var sobrenome: String?
                    var tipo: Int
                    var especialidade: String?
                    var quantHoras: Int = 0
                    var codProf: Int = 0

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- CADASTRO DE PROFESSOR ----]")

                        quantCadastros++
                        print(" - Nome: ")
                        do nome = readLine() while (nome == null)

                        print(" - Sobrenome: ")
                        do sobrenome = readLine() while (sobrenome == null)

                        print(" - Código: ")
                        do ent = readLine() while (ent == null)
                        codProf = ent.toInt()

                        println(" - Qual é o tipo do professor?")
                        println(" [0] - Titular; [1] - Adjunto")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        tipo = if (ent.isNotEmpty() && (ent.toInt() == 0 || ent.toInt() == 1)) ent.toInt() else throw IllegalArgumentException("Tipo de professor informado incorretamente!")

                        if (tipo == 0) {
                            print(" - Especialidade: ")
                            do especialidade = readLine() while (especialidade == null)
                            println(" - Professor Titular registrado com o código ${dhm.registrarProfessorTitular(nome, sobrenome, codProf, especialidade)}.")
                        }else{
                            do ent = readLine() while (ent == null)
                            quantHoras = ent.toInt()
                            println(" - Professor Adjunto registrado com o código ${dhm.registrarProfessorAdjunto(nome, sobrenome, codProf, quantHoras)}.")
                        }
                        espaco(2)

                        println("Deseja cadastrar mais um professor?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }
                    println(" -> $quantCadastros cadastros de professores realizados!")
                    pressEnter()
                }
                3 -> {
                    var quantCadastros = 0
                    var nome: String?
                    var qtdMaximaAlunos: Int = 0

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- CADASTRO DE CURSO ----]")

                        quantCadastros++
                        print(" - Nome: ")
                        do nome = readLine() while (nome == null)

                        print(" - Quantidade máxima de alunos: ")
                        do ent = readLine() while (ent == null)
                        qtdMaximaAlunos = ent.toInt()

                        println(" - Curso registrado com o código ${dhm.registrarCurso(nome, qtdMaximaAlunos)}.")
                        espaco(2)

                        println("Deseja cadastrar mais um curso?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantCadastros cadastros de cursos realizados!")
                    pressEnter()
                }
                4 -> {
                    var quantExclusoes = 0
                    var cod: Int = 0

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- EXCLUSÃO DE PROFESSOR ----]")

                        quantExclusoes++

                        print(" - Código do Curso: ")
                        do ent = readLine() while (ent == null)
                        cod = ent.toInt()

                        var prof = dhm.listaProfessores[cod] ?: throw IllegalArgumentException("Não há professores cadastrados com o código dado!")
                        var nome = prof.nome

                        dhm.excluirCurso(cod)
                        println(" - Professor [$cod] - '$nome' excluído com sucesso.")
                        espaco(2)

                        println("Deseja excluir mais um professor?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantExclusoes exclusões de cursos realizadas!")
                    pressEnter()
                }
                5 -> {
                    var quantExclusoes = 0
                    var cod: Int = 0

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- EXCLUSÃO DE CURSO ----]")

                        quantExclusoes++

                        print(" - Código do Curso: ")
                        do ent = readLine() while (ent == null)
                        cod = ent.toInt()

                        var curso = dhm.listaCursos[cod] ?: throw IllegalArgumentException("Não há cursos cadastrados com o código dado!")
                        var nome = curso.nome

                        dhm.excluirCurso(cod)
                        println(" - Curso [$cod] - '$nome' excluído com sucesso.")
                        espaco(2)

                        println("Deseja excluir mais um curso?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantExclusoes exclusões de cursos realizadas!")
                    pressEnter()
                }
                6 -> {
                    var quantCadastros = 0
                    var codAluno: Int?
                    var codCurso: Int?
                    var nomeAluno: String?
                    var nomeCurso: String?

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- MATRÍCULA DE ALUNO ----]")

                        quantCadastros++
                        print(" - Código do Aluno: ")
                        do ent = readLine() while (ent == null)
                        codAluno = ent.toInt()

                        var aluno = dhm.listaCursos[codAluno] ?: throw IllegalArgumentException("Não há alunos cadastrados com o código dado!")
                        nomeAluno = aluno.nome

                        print(" - Código do Curso: ")
                        do ent = readLine() while (ent == null)
                        codCurso = ent.toInt()

                        var curso = dhm.listaCursos[codCurso] ?: throw IllegalArgumentException("Não há cursos cadastrados com o código dado!")
                        nomeCurso = curso.nome

                        println(" - $nomeAluno matriculado no curso de $nomeAluno com o RM -  ${dhm.matricularAluno(codAluno, codCurso)}.")
                        println(" - Há ${dhm.listaCursos[codCurso]!!.quantMaxAlunos - dhm.listaCursos.size} vagas restantes no curso.")
                        espaco(2)

                        println("Deseja matricular mais um aluno?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantCadastros matrículas de alunos realizados!")
                    pressEnter()
                }
                7 ->{
                    var quantCadastros = 0
                    var codProfTit: Int?
                    var codProfAdj: Int?
                    var codCurso: Int?
                    var nomeCurso: String?

                    cont = 1
                    while (cont == 1) {
                        println()
                        println(" [ ---- ALOCAÇÃO DE PROFESSOR ----]")

                        quantCadastros++
                        print(" - Código do Curso: ")
                        do ent = readLine() while (ent == null)
                        codCurso = ent.toInt()

                        var curso = dhm.listaCursos[codCurso] ?: throw IllegalArgumentException("Não há cursos cadastrados com o código dado!")
                        nomeCurso = curso.nome

                        print(" - Código do Professor Titular: ")
                        do ent = readLine() while (ent == null)
                        codProfTit = ent.toInt()

                        print(" - Código do Professor Adjunto: ")
                        do ent = readLine() while (ent == null)
                        codProfAdj = ent.toInt()

                        dhm.alocarProfessores(codCurso, codProfTit,  codProfAdj)
                        println(" - Professores alocados no curso [$codCurso] - $nomeCurso.")
                        espaco(2)

                        println("Deseja alocar mais professores a cursos?")
                        println(" [0] - Não; [1] - Sim")
                        print(" >>> ")
                        do ent = readLine() while (ent == null)
                        cont = if (ent.isNotEmpty()) ent.toInt() else 0
                    }

                    espaco(1)
                    println(" -> $quantCadastros alocações de professores realizadas!")
                    pressEnter()
                }
                else -> {
                    println(" - Opção inválida!")
                    pressEnter()
                }
            }
        } catch (e: IllegalStateException) {
            println(e.message)
            pressEnter()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            pressEnter()
        } catch (e: Exception) {
            println("ERRO INESPERADO!")
            pressEnter()
        }
    }
    espaco(5)
    println("FECHANDO O SISTEMA!")
}

fun espaco(qt: Int) {
    for (i in 1..qt) println()
}

fun pressEnter() {
    print("----------------------------------->> [Pressione Enter] <<")
    readLine()
}