package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseCarga<T>(
    @SerializedName("carga")
    var data: T? = null


)
