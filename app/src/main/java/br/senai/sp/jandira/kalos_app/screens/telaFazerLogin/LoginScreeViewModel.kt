package br.senai.sp.jandira.kalos_app.screens.telaFazerLogin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


class LoginScreeViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Sucesso", "Logado com  sucesso")
                        home()
                    }

                }.addOnFailureListener { Log.e("Erro", "Falha ao logar Com Google!") }
            }catch (ex:Exception){
                Log.d("teste", "Ao logar com Google " + "${ex.localizedMessage}")
            }
        }
}


