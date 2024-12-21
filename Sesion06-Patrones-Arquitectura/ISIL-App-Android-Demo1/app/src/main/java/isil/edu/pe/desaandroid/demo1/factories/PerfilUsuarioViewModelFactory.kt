package isil.edu.pe.desaandroid.demo1.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import isil.edu.pe.desaandroid.demo1.repositories.PerfilUsuarioRepository
import isil.edu.pe.desaandroid.demo1.viewmodels.PerfilUsuarioViewModel

class PerfilUsuarioViewModelFactory(private val repository: PerfilUsuarioRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PerfilUsuarioViewModel::class.java)) {
            return PerfilUsuarioViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase ViewModel desconocida")
    }

}