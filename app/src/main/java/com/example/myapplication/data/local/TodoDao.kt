package com.example.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.local.entity.Todo
@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    fun getAll():LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo: Todo)
    @Update
    suspend fun update(todo: Todo)
    @Delete
    suspend fun delete(todo: Todo)
}