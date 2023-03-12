package com.example.taskmanager.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmanager.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun collection(toString: String): Any
}