package br.senai.sp.jandira.kalos_app.model

data class ExercicioResponse(
    var id_exercicio_serie_repeticao:Int? = 0,
    var id_exercicio:Int? = 0,
    var nome: String? = "",
    var descricao: String? = "",
    var anexo: String? = "",
    var series: String? = "",
    var repeticoes: String? = "",
    var duracao: String? = null,
    var id_treino_nivel_categoria:Int? = 0,
    var numero:Int? = 0

)
