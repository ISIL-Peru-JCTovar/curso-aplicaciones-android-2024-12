package isil.edu.pe.desaandroid.demo1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import isil.edu.pe.desaandroid.demo1.data.PerfilUsuario
import isil.edu.pe.desaandroid.demo1.data.Tarea
import isil.edu.pe.desaandroid.demo1.repositories.PerfilUsuarioRepository
import isil.edu.pe.desaandroid.demo1.repositories.TareaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TareaViewModel(private val repository: TareaRepository): ViewModel() {

    private val _tareas = MutableStateFlow<List<Tarea>>(emptyList())
    val tareas: StateFlow<List<Tarea>> = _tareas

    fun crearTarea(tarea: Tarea) {
        viewModelScope.launch {
            repository.crearTareaCall(tarea)
            _tareas.value = _tareas.value + tarea
        }
    }

}