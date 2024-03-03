package  com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.local.entity.Todo
import com.example.myapplication.ui.TodoAdappter
import com.example.myapplication.ui.TodoViewModel
import com.scienceexperts.mayartodos.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val todoViewModel : TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        val adappter = TodoAdappter(todoViewModel)
        recyclerView.adapter = adappter
        recyclerView.layoutManager = LinearLayoutManager(this)

        todoViewModel.allTodos.observe(this) { todo ->
            todo?.let {
                adappter.setTodos(todo)
            }

        }

findViewById<Button>(R.id.addButton).setOnClickListener {
    val title = findViewById<EditText>(R.id.titleEditText).text.toString()
    val description = findViewById<EditText>(R.id.descriptionEditText).text.toString()
    Log.e("osama" , "")
    val todo = Todo(
        title= title,
        desciption = description
    )
    todoViewModel.insert(todo)
}


         fun saveTodo(todo: Todo) {
            // Retrieve other todo details from EditText fields, then save todo with isComplete value
            todoViewModel.update(todo)
        }
    }
}