package com.example.myapplication.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.TodoDao
import com.example.myapplication.data.local.TodoDataBase
import com.example.myapplication.data.repositories.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

// AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDataBase {
        return Room.databaseBuilder(
            context,
            TodoDataBase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun provideTodoDao(todoDatabase: TodoDataBase): TodoDao {
        return todoDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepository(todoDao)
    }
}