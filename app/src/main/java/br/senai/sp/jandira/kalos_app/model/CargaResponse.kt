package br.senai.sp.jandira.kalos_app.model

data class CargaResponse(
    val id: Int? = 0,
    var peso: String? = "",
    val data_horario: String? = "",
    val id_aluno: Int? = 0,
    val id_exercicio_serie_repeticao: Int? = 0
)