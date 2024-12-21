package isil.edu.pe.desaandroid.demo1.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import isil.edu.pe.desaandroid.demo1.R

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