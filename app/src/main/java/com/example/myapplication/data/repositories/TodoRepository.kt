package com.example.myapplication.data.repositories

import androidx.lifecycle.LiveData
import com.example.myapplication.data.local.TodoDao
import com.example.myapplication.data.local.entity.Todo
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<Todo>> = todoDao.getAll()

    suspend fun insert (todo: Todo){
        todoDao.insert(todo)
    }
    suspend fun update(todo: Todo){
        todoDao.update(todo)
    }
    suspend fun delete(todo: Todo){
        todoDao.delete(todo)
    }
}