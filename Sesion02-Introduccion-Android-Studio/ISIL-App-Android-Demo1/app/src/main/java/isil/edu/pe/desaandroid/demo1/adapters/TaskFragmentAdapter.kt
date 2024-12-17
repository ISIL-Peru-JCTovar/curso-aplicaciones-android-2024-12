package isil.edu.pe.desaandroid.demo1.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import isil.edu.pe.desaandroid.demo1.R
import isil.edu.pe.desaandroid.demo1.activities.DetalleTareaActivity

class TaskFragmentAdapter(private val listaTareas: List<String>, private val navigation: NavController) :
    RecyclerView.Adapter<TaskFragmentAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return TaskViewHolder(vista)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.textoTarea.text = listaTareas[position]
        //Manejar los clicks en cada elemento de la lista - Mediante Navigation (Fragments)
        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("DETALLE_TAREA", listaTareas[position])
                putString("TITULO", "Ver Detalle de la Tarea: ")
            }
            navigation.navigate(R.id.action_mainFragment_a_detalleTareaFragment, bundle)
        }
    }

    override fun getItemCount() = listaTareas.size

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textoTarea: TextView = view.findViewById(android.R.id.text1)
    }

}