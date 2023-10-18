package br.senai.sp.jandira.kalos_app.model

data class BaseResponsePostagem<T>(
    var status: String? = "",
    var postagens: List<PostagensResponse>? = emptyList()
)
