package isil.edu.pe.desaandroid.demo1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleTareaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Lineas comunes (por defecto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_tarea)
        //Recibir el nombre de la tarea desde la otra pantalla
        val detalleTarea = intent.getStringExtra("DETALLE_TAREA")
        //Mostrar en el TextView
        val tvDetalleTareaActivity = findViewById<TextView>(R.id.tvDetalleTarea1)
        tvDetalleTareaActivity.text = detalleTarea
    }

}