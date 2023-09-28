package br.senai.sp.jandira.kalos_app.screens.telaEditarPerfil.components

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.kalos_app.R
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.ui.theme.GreenKalos
import coil.compose.AsyncImage

import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

@Composable
fun EditarFoto(aluno: AlunoResponse) {
    //Referencia para acesso e manipulação do cloud Storage e firestore
     lateinit var storageRef: StorageReference
     lateinit var fibaseFirestore: FirebaseFirestore
    storageRef = FirebaseStorage.getInstance().reference.child("images")
    fibaseFirestore = FirebaseFirestore.getInstance()
    var fotoUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var context = LocalContext.current

    //Criar o objeto que  abrirá a galeria e retornará a Uri da imagem selecionada
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        fotoUri = it
    }
    Log.e("foto", "EditarFoto: ${fotoUri}", )

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(fotoUri).build()
    )
    var foto: String


    Column(
       modifier = Modifier
           .fillMaxSize()
           .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(100.dp)
                ,
            color = GreenKalos
        ) {

            AsyncImage(
                model = aluno.foto,
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.ellipse1)
            )
            Image(
                painter = painter,
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp),
                contentScale = ContentScale.Crop
            )

        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.editar_foto),
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier .clickable {
                launcher.launch("image/*")
                Log.e("TAG", "EditarFoto: ${painter.toString()} " )
            }
        )


//        Button(
//            onClick = {
//                storageRef = storageRef.child(System.currentTimeMillis().toString())
//                fotoUri?.let {
//                    storageRef.putFile(it).addOnCompleteListener { task->
//
//                        if (task.isSuccessful) {
//
//                            storageRef.downloadUrl.addOnSuccessListener { uri ->
//
//                                val map = HashMap<String, Any>()
//                                map["pic"] = uri.toString()
//                                Log.e("link", map.toString() )
//
//                                fibaseFirestore.collection("images").add(map).addOnCompleteListener { firestoreTask ->
//
//                                    if (firestoreTask.isSuccessful){
//                                        Toast.makeText(context, "Uploaded realizado com sucesso", Toast.LENGTH_SHORT).show()
//
//                                    }else{
//                                        Toast.makeText(context, "ERRO ao tentar fazer upload", Toast.LENGTH_SHORT).show()
//
//                                    }
//
//
//                                }
//                            }
//
//                        }else{
//
//                            Toast.makeText(context,  task.exception?.message, Toast.LENGTH_SHORT).show()
//
//                        }
//
//                    }
//                }
//        }) {}


    }


}