package br.senai.sp.jandira.kalos_app.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("aluno")
    var data: T? = null

)
