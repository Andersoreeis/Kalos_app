package br.senai.sp.jandira.kalos_app.model

data class ProdutosTeste(
    var nomeProduto: String = "",
    var imagem : String= "",
    var dataReserva: String = "",
    var quantidade: String = "",
    var valor: String = "",
    var status: String = ""
)


data class ProdutosResponse(
    var id: Int?  = 0,
    var nome : String? = "",
    var descricao : String? = "",
    var codigo: String ? = "",
    var categoria: String? = "",
    var preco: String = "",
    var status: String = "",
    var id_academia: Int?  = 0,
    var fotos: List<FotoResponse>? = emptyList()
)


data class FotoResponse(
    var url: String? = null
)