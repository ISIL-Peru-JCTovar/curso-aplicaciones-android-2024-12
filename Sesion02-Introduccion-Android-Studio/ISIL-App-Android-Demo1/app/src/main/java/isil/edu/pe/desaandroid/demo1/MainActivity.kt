package isil.edu.pe.desaandroid.demo1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var constraintLayout1: ConstraintLayout
    private lateinit var etvTarea1: EditText
    private lateinit var bvAgregarTarea1: Button
    private lateinit var rvListaTareas1: RecyclerView

    private lateinit var taskAdapter: TaskAdapter

    private val listaTareas1 = mutableListOf<String>()

    //Este es el metodo comun para inicializar las acciones previas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Iniciar con que pantalla va a trabajar (layout)
        setContentView(R.layout.activity_main)
        //Inicializar vistas
        etvTarea1 = findViewById<EditText>(R.id.etvTarea1)
        bvAgregarTarea1 = findViewById<Button>(R.id.bvAgregarTarea1)
        rvListaTareas1 = findViewById<RecyclerView>(R.id.rvListaTareas1)
        //Creando artificialmente un View
        /*
        var textView1 = TextView(this).apply {
            text = "Mensaje de prueba"
            textSize = 22f
        }
        constraintLayout1.addView(textView1)
        */
        //Configurando el RecyclerView
        rvListaTareas1.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(listaTareas1)
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

