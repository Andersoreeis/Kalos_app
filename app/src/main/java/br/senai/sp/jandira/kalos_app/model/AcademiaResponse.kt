package br.senai.sp.jandira.kalos_app.model

data class Tag(
    var id_tags: Int? = 0,
    var nome_tags: String? = ""
)

data class AcademiaResponse(
    var id: Int? = 0,
    var nome: String? = "",
    var email: String? = "",
    var senha: String? = "",
    var telefone: String? = "",
    var cnpj: String? = "",
    var foto: String? = "",
    var descricao: String? = "",
    var cor_primaria: String? = "",
    var cor_secundaria: String? = "",
    var data_abertura: String? = "",
    var razao_social: String? = "",
    var facebook: String? = "",
    var whatsapp: String? = "",
    var instagram: String? = "",
    var id_endereco: Int? = 0,
    var status: String? = "",
    var token: String? = null,
    var expiracao_token: String? = null,
    var id_categoria: Int? = 0,
    var categoria: String? = "",
    var logradouro: String? = "",
    var numero: String? = "",
    var complemento: String? = "",
    var cep: String? = "",
    var cidade: String? = "",
    var estado: String? = "",
    var tags: List<Tag>? = emptyList()
)
