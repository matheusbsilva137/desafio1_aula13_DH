package br.digital.com.desafio

class ProfessorAdjunto (codProfessor: Int,
                        nome: String,
                        sobrenome: String,
                        var quantHoras: Int
                        ) : Professor(codProfessor, nome, sobrenome)