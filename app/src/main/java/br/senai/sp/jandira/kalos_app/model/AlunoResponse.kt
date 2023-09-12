package br.senai.sp.jandira.kalos_app.model

data class AlunoResponse(
    var id: Int? = 0,
    var nome: String? = "",
    var data_nascimento: String? = "",
    var telefone: String? = "",
    var email: String? = "",
    var foto: String? = "",
//    var senha: String? = "",
    var cpf: String? = "",
    var questao_condicao_medica: String? = "",
    var questao_lesoes: String? = "",
    var questao_medicamento:  String? = "",
    var peso: String? = "",
    var altura: String? = "",
    var objetivo: String? = "",
    var genero: String? = ""
)
