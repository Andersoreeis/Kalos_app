package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseCargas<T>(
    @SerializedName("cargas")
    var data: List<T>? = null
)
