package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseAcademia<T>(
    @SerializedName("academias")
    var data: List<T>? = null

)