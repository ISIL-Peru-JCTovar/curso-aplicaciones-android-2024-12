package isil.edu.pe.desaandroid.demo1

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isil.edu.pe.desaandroid.demo1.ui.theme.ISILAppAndroidDemo1Theme

class MainActivity : ComponentActivity() {

    private lateinit var taskInput: EditText
    private lateinit var agregarBoton: Button
    private lateinit var listaTareas: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private val listaTareas1 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicializar vistas
        taskInput = findViewById<EditText>(R.id.etvTarea1)
        agregarBoton = findViewById<Button>(R.id.bvAgregarTarea1)
        listaTareas = findViewById<RecyclerView>(R.id.rvListaTareas1)
        //Configurando el RecyclerView
        listaTareas.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(listaTareas1)
        listaTareas.adapter = taskAdapter
        //Manejo del boton
        agregarBoton.setOnClickListener {
            val tarea = taskInput.text.toString()
            if (tarea.isNotEmpty()) {
                listaTareas1.add(tarea)
                //taskAdapter
            }
        }
    }

}

