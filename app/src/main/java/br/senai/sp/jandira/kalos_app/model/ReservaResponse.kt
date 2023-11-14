package br.senai.sp.jandira.kalos_app.model

data class ReservaResponse(
    var id: Int? = 0,
    var quantidade: String? = "",
    var data: String? = "",
    var total: String? = "",
    var id_produto: Int? = 0,
    var id_status_reserva: Int? = 0,
    var codigo: String? = "",
    var nome_aluno: String? = "",
    var status_reserva: String? = "",
    var nome_produto: String? = "",
    var foto: String? = "",
    var id_academia: Int? = 0
)
