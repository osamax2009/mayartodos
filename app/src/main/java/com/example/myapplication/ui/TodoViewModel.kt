package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.entity.Todo
import com.example.myapplication.data.repositories.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor( private  val repository: TodoRepository ) : ViewModel() {
    val allTodos : LiveData<List<Todo>> = repository.allTodos

    fun insert(todo: Todo) {
        viewModelScope.launch {
            repository.insert(todo)
        }

    }

    fun update(todo: Todo) {
        viewModelScope.launch {
            repository.update(todo)
        }

    }

    fun delete(todo: Todo) {
        viewModelScope.launch {
            repository.delete(todo)
        }

    }

}