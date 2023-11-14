package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponsePostagem
import br.senai.sp.jandira.kalos_app.model.BaseResponseProduto
import br.senai.sp.jandira.kalos_app.model.PostagensResponse
import br.senai.sp.jandira.kalos_app.model.ProdutosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProdutoService {

    @GET("kalos/produtoByIdAcademia/id/{idAcademia}")
    suspend fun getTodosProdutos(@Path("idAcademia") idAcademia: String): Response<BaseResponseProduto<ProdutosResponse>>
}