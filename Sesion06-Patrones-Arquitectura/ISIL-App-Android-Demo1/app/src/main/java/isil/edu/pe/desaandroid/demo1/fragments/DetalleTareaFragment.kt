package isil.edu.pe.desaandroid.demo1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import isil.edu.pe.desaandroid.demo1.R

class DetalleTareaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detalle_tarea, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Recibir el nombre de la tarea desde la otra pantalla
        val titulo = arguments?.getString("TITULO")
        val detalleTarea = arguments?.getString("DETALLE_TAREA")
        //Mostrar en el TextView
        val tvDetalleTareaActivity = view.findViewById<TextView>(R.id.tvDetalleTarea1)
        tvDetalleTareaActivity.text = titulo.plus(" - ").plus(detalleTarea)
    }

}