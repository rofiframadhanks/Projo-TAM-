package com.example.taskmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagementapp.model.Task
import com.example.taskmanagementapp.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(app: Application, private val taskRepository: TaskRepository): AndroidViewModel(app) {

    fun addTask(task: Task) =
        viewModelScope.launch {
            taskRepository.insertTask(task)
        }

    fun deleteTask(task: Task) =
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }

    fun updateTask(task: Task) =
        viewModelScope.launch {
            taskRepository.updateTask(task)
        }

    fun getALlTasks() = taskRepository.getAllTasks()

    fun getTodoTasks() = taskRepository.getTodoTasks()

    fun getProgressTasks() = taskRepository.getProgressTasks()

    fun getCompleteTasks() = taskRepository.getCompleteTasks()

    fun searchTask(query: String?) =
        taskRepository.searchTask(query)

}