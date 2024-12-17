package isil.edu.pe.desaandroid.demo1.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.adapters.TaskAdapter
import isil.edu.pe.desaandroid.demo1.adapters.TaskFragmentAdapter

class MainNavActivity : AppCompatActivity() {

    private lateinit var constraintLayout1: ConstraintLayout
    private lateinit var etvTarea1: EditText
    private lateinit var bvAgregarTarea1: Button
    private lateinit var rvListaTareas1: RecyclerView

    private lateinit var taskAdapter: TaskFragmentAdapter

    private val listaTareas1 = mutableListOf<String>()

    //Este es el metodo comun para inicializar las acciones previas
    override fun onCreate(savedInstanceState: Bundle?) {
        //Llamando al metodo padre
        super.onCreate(savedInstanceState)
        //Seteando la vista principal del Activity
        setContentView(R.layout.activity_nav_main)
        //Trabajando con el toolbar
        val navController = findNavController(R.id.navHostFragment)
        val appBarConfig = AppBarConfiguration(navController.graph)
        //Configurando la barra de tareas como ActionBar
        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)
        //Sincronizar la barra de tareas con el Navigation Controller
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menuAgregarTarea1 -> {
                Toast.makeText(this, "Agregar tarea seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuPreferencias -> {
                Toast.makeText(this, "Configurar preferencias", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

