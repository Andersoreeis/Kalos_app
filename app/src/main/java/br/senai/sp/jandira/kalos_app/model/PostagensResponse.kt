package br.senai.sp.jandira.kalos_app.model

data class PostagensResponse(
    var id: Int? = 0,
    var titulo: String? = "",
    var corpo: String? = "",
    var anexo: String? = "",
    var id_academia: Int? = 0,
    var data: String? = "",
    var hora: String? = ""
)
