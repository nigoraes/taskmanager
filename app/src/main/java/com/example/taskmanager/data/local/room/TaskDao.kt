package com.example.taskmanager.data.local.room

import androidx.room.*
import com.example.taskmanager.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY id DESC ")
    fun getAll(): List<Task>

    //save task
    @Insert
    fun insert(task: Task)

    //delete task
    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}