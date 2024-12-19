package isil.edu.pe.desaandroid.demo1.fragments

import android.Manifest
import android.content.pm.PackageManager
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.managers.ProfileManager
import kotlinx.coroutines.launch

class PerfilFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etUserId: EditText
    private lateinit var ivPhoto: ImageView
    private lateinit var btnSave: Button

    private var photoUri: Uri? = null
    private lateinit var adminPerfilManager: ProfileManager

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
        //Instanciar el DataStore
        val context = requireContext()
        adminPerfilManager = ProfileManager(context)
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
                saveProfile()
            }
        }
        //Setear los textos desde el DataStore
        lifecycleScope.launch {
            adminPerfilManager.datosPerfil1.collect({ perfil ->
                etName.setText(perfil.nombre)
                etUserId.setText(perfil.idUsuario)
            })
        }
    }

    private suspend fun saveProfile() {
        val name = etName.text.toString()
        val userId = etUserId.text.toString()
        if (name.isNotEmpty() && userId.isNotEmpty()) {
            adminPerfilManager.guardarPerfil(name, userId, photoUri.toString())
            Toast.makeText(requireContext(), "Perfil guardado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
