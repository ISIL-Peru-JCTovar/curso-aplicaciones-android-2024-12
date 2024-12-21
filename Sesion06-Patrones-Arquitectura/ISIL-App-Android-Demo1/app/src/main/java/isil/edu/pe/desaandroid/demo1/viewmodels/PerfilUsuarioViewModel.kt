package isil.edu.pe.desaandroid.demo1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import isil.edu.pe.desaandroid.demo1.data.PerfilUsuario
import isil.edu.pe.desaandroid.demo1.repositories.PerfilUsuarioRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PerfilUsuarioViewModel(private val repository: PerfilUsuarioRepository): ViewModel() {

    val perfilUsuarioData: Flow<PerfilUsuario> = repository.datosPerfil1

    fun guardarPerfil(perfilUsuario: PerfilUsuario) {
        viewModelScope.launch {
            repository.guardarPerfil(perfilUsuario)
        }
    }

}