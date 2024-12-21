package isil.edu.pe.desaandroid.demo1.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.data.PerfilUsuario
import isil.edu.pe.desaandroid.demo1.factories.PerfilUsuarioViewModelFactory
import isil.edu.pe.desaandroid.demo1.repositories.PerfilUsuarioRepository
import isil.edu.pe.desaandroid.demo1.viewmodels.PerfilUsuarioViewModel
import kotlinx.coroutines.launch

class PerfilFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etUserId: EditText
    private lateinit var ivPhoto: ImageView
    private lateinit var btnSave: Button

    private var photoUri: Uri? = null

    //Patron Repositorio para encapsular el manejo de DataStore de Usuario
    //private lateinit var perfilUsuarioRepository: PerfilUsuarioRepository

    private val perfilUsuarioViewModel: PerfilUsuarioViewModel by viewModels {
        PerfilUsuarioViewModelFactory(PerfilUsuarioRepository(requireContext()))
    }

    // Launcher para seleccionar una imagen de la galería
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            photoUri = it
            ivPhoto.setImageURI(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflar el Fragmento
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Invocando al padre
        super.onViewCreated(view, savedInstanceState)
        //Personalizando los componentes Views
        etName = view.findViewById(R.id.etName)
        etUserId = view.findViewById(R.id.etUserId)
        ivPhoto = view.findViewById(R.id.ivPhoto)
        btnSave = view.findViewById(R.id.btnSave)
        ivPhoto.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }
        btnSave.setOnClickListener {
            lifecycleScope.launch {
                guardarPerfilUsuario()
            }
        }
        //Setear los textos desde el DataStore
        lifecycleScope.launch {
            perfilUsuarioViewModel.perfilUsuarioData.collect({ perfil ->
                etName.setText(perfil.nombre)
                etUserId.setText(perfil.idUsuario)
            })
        }
    }

    override fun onPause() {
        super.onPause()
        //Aca se debe liberar los recursos del DataStore (ProfileManager)
        //TODO: Aca se debe liberar los recursos del DataStore (ProfileManager)
    }

    private fun guardarPerfilUsuario() {
        val name = etName.text.toString()
        val userId = etUserId.text.toString()
        if (name.isNotEmpty() && userId.isNotEmpty()) {
            val perfilUsuario = PerfilUsuario(name, userId, photoUri.toString())
            perfilUsuarioViewModel.guardarPerfil(perfilUsuario)
            Toast.makeText(requireContext(), "Perfil guardado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
