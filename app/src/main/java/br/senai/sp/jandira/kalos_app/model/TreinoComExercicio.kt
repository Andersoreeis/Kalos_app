package br.senai.sp.jandira.kalos_app.model

data class TreinoComExercicio(
    val id:Int? = 0,
    val id_treino:Int? = 0,
    val nome: String? = "",
    val descricao: String? ="",
    val foto: String? = "",
    val data_criacao: String? = "",
    val nome_categoria_treino: String? = "",
    val id_academia:Int? = 0,
    val exercicio:List<ExercicioResponse>? = emptyList()
)
