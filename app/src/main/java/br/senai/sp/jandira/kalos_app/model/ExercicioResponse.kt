package br.senai.sp.jandira.kalos_app.model

data class ExercicioResponse(
    val id_exercicio_serie_repeticao:Int? = 0,
    val id_exercicio:Int? = 0,
    val nome: String? = "",
    val descricao: String? = "",
    val anexo: String? = "",
    val series: String? = "",
    val repeticoes: String? = "",
    val duracao: String? = null,
    val id_treino_nivel_categoria:Int? = 0

)
