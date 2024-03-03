package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.entity.Todo

//TodoDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDataBase :RoomDatabase() {
   abstract fun todoDao():TodoDao
}