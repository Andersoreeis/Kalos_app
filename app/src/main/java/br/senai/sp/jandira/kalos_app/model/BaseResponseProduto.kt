package br.senai.sp.jandira.kalos_app.model

data class BaseResponseProduto<T> (
    var produto: List<ProdutosResponse>? = emptyList()
)
