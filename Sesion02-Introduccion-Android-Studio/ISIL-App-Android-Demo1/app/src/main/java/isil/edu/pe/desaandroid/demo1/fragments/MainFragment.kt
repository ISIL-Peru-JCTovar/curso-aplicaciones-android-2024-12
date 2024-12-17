package isil.edu.pe.desaandroid.demo1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.adapters.TaskAdapter
import isil.edu.pe.desaandroid.demo1.adapters.TaskFragmentAdapter

class MainFragment : Fragment() {

    private lateinit var constraintLayout1: ConstraintLayout
    private lateinit var etvTarea1: EditText
    private lateinit var bvAgregarTarea1: Button
    private lateinit var rvListaTareas1: RecyclerView

    private lateinit var taskAdapter: TaskFragmentAdapter

    private val listaTareas1 = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Inicializar vistas
        etvTarea1 = view.findViewById<EditText>(R.id.etvTarea1)
        bvAgregarTarea1 = view.findViewById<Button>(R.id.bvAgregarTarea1)
        rvListaTareas1 = view.findViewById<RecyclerView>(R.id.rvListaTareas1)
        //Creando artificialmente un View
        /*
        var textView1 = TextView(this).apply {
            text = "Mensaje de prueba"
            textSize = 22f
        }
        constraintLayout1.addView(textView1)
        */
        //Configurando el RecyclerView
        rvListaTareas1.layoutManager = LinearLayoutManager(this.activity)
        val controlador = findNavController()
        taskAdapter = TaskFragmentAdapter(listaTareas1, controlador)
        rvListaTareas1.adapter = taskAdapter
        //Manejo del boton
        bvAgregarTarea1.setOnClickListener {
            val tarea = etvTarea1.text.toString()
            if (tarea.isNotEmpty()) {
                listaTareas1.add(tarea)
                taskAdapter.notifyDataSetChanged()
            }
        }
    }

}

