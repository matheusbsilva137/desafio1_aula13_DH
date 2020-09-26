package br.digital.com.desafio

class ProfessorTitular (codProfessor: Int,
                        nome: String,
                        sobrenome: String,
                        var especialidade: String
                        ) : Professor(codProfessor, nome, sobrenome)