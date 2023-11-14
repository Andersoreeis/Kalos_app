package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponseReservas<T>(
    @SerializedName("reservas")
    var data: List<T>? = null
)
