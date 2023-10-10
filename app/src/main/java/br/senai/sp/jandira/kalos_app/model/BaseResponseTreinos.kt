package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseTreinos<T>(
    @SerializedName("informacoes")
    var data: List<T>? = null

)
data class BaseResponseTreinos2<T>(
    @SerializedName("informacoes")
    var data: T? = null

)
