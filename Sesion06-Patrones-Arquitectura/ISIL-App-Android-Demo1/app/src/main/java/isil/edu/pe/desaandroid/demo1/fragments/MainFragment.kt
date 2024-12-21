package isil.edu.pe.desaandroid.demo1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.adapters.TaskFragmentAdapter
import isil.edu.pe.desaandroid.demo1.data.Tarea
import isil.edu.pe.desaandroid.demo1.repositories.TareaRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var etvTituloTarea1: EditText
    private lateinit var etvDescripcionTarea1: EditText

    private lateinit var bvAgregarTarea1: Button
    private lateinit var rvListaTareas1: RecyclerView

    private lateinit var taskAdapter: TaskFragmentAdapter

    //Patron Repositorio para encapsular el manejo de API REST HTTP de Tarea
    private lateinit var tareaRepository: TareaRepository

    private val listaTareas1 = mutableListOf<Tarea>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instanciando el Repository
        tareaRepository = TareaRepository(requireContext())
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicializar vistas
        etvTituloTarea1 = view.findViewById<EditText>(R.id.etvTituloTarea1)
        etvDescripcionTarea1 = view.findViewById<EditText>(R.id.etvDescripcionTarea1)
        bvAgregarTarea1 = view.findViewById<Button>(R.id.bvAgregarTarea1)
        rvListaTareas1 = view.findViewById<RecyclerView>(R.id.rvListaTareas1)
        //Configurando el RecyclerView
        rvListaTareas1.layoutManager = LinearLayoutManager(this.activity)
        val controlador = findNavController()
        taskAdapter = TaskFragmentAdapter(listaTareas1, controlador)
        rvListaTareas1.adapter = taskAdapter
        //Manejo del boton
        bvAgregarTarea1.setOnClickListener {
            val title = etvTituloTarea1.text.toString()
            val body = etvDescripcionTarea1.text.toString()
            if (title.isNotEmpty() && body.isNotEmpty()) {
                //-- Instanciando la tarea
                val tarea = Tarea(152624, title, body)
                //-- Agregando al RecyclerView
                listaTareas1.add(tarea)
                taskAdapter.notifyDataSetChanged()
                //-- Invocando el API
                //crearTareaConLifecycle(tarea)   //Sincrona
                crearTareaConCall(tarea)    //Asincrona
            }
        }
    }

    private fun crearTareaConLifecycle(tarea: Tarea) {
        lifecycleScope.launch {
            try {
                val response = tareaRepository.crearTareaResponse(tarea)
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Tarea creada exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Error al crear la tarea", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Excepcion: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun crearTareaConCall(tarea: Tarea) {
        val call = tareaRepository.crearTareaCall(tarea)
        call.enqueue(object: Callback<Tarea> {
            override fun onResponse(call: Call<Tarea>, response: Response<Tarea>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Tarea creada exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Error al crear la tarea", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Tarea>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}

