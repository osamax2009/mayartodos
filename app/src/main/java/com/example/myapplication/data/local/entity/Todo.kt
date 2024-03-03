package com.example.myapplication.data.local.entity


//Entity
import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "todos")
data class Todo (
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    val title: String,
    val desciption : String,
    var isComplete  :Boolean = false
 )
