package isil.edu.pe.desaandroid.demo1.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.managers.ThemeManager

class MainNavActivity : AppCompatActivity() {

    private var esTemaOscuro: Boolean = false

    private val REQUEST_CODE: Int = 123

    //Este es el metodo comun para inicializar las acciones previas
    override fun onCreate(savedInstanceState: Bundle?) {
        //Invocar el administrador del tema (ThemeManager) - Antes de invocar el super del padre
        esTemaOscuro = ThemeManager.aplicarTema(this)
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
        //Permiso para acceder a la galeria de imagenes
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_MEDIA_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_MEDIA_LOCATION), REQUEST_CODE);
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        val itemCambiarModo1 = menu?.findItem(R.id.menuCambiarModo)
        if (esTemaOscuro) {
            itemCambiarModo1?.setTitle("Cambiar Modo Claro")
        } else {
            itemCambiarModo1?.setTitle("Cambiar Modo Oscuro")
        }
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
            R.id.menuCambiarModo -> {
                ThemeManager.intercambiarTema(this)
                recreate()
                true
            }
            R.id.menuPerfil -> {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
                val navController = navHostFragment?.findNavController()
                navController?.navigate(R.id.perfilFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

