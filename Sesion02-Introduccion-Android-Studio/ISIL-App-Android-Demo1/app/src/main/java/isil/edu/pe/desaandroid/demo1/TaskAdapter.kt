package isil.edu.pe.desaandroid.demo1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val listaTareas: List<String>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return TaskViewHolder(vista)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.
    }

    override fun getItemCount() = listaTareas.size

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textoTarea: TextView = view.findViewById(android.R.id.text1)
    }

}