package com.example.myapplication.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.local.entity.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TodoAdappter(private  val todoViewModel: TodoViewModel) : RecyclerView.Adapter<TodoAdappter.TodoViewHolder>() {
    private  var todos : List<Todo> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
    }

    override fun getItemCount(): Int {
      return  todos.size
    }

    fun setTodos(todos : List<Todo>){
        CoroutineScope(Dispatchers.Main).launch {
            // Delay for 500 milliseconds (adjust as needed)
            delay(500)

            val incompleteTodos = todos.filter { !it.isComplete }
            this@TodoAdappter.todos = incompleteTodos
            notifyDataSetChanged()
        }
    }


        inner  class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(todo: Todo){
                itemView.findViewById<TextView>(R.id.titleTextView).text = todo.title
                itemView.findViewById<TextView>(R.id.descriptiomTextView).text = todo.desciption

                val isCompleteRadioButton = itemView.findViewById<RadioButton>(R.id.isCompleteRadioButton)
                 isCompleteRadioButton.isChecked = todo.isComplete


                isCompleteRadioButton.setOnClickListener {
                    // Toggle the isComplete field when the RadioButton is clicked
                    todo.isComplete = !todo.isComplete
                    // Update the UI state of the RadioButton
                    isCompleteRadioButton.isChecked = todo.isComplete
                    // Call ViewModel to update the Todo object in the database
                    todoViewModel.update(todo)
                  Log.e("osama", todo.isComplete.toString())
                }

            }
        }
}