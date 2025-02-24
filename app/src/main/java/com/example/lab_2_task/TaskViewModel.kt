package com.example.lab_2_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    private var taskList = MutableLiveData<List<Task>>()
    val tasklist : LiveData<List<Task>> = taskList
//this rutrn the list
    fun getAlltask(){
       taskList.value = taskManager.getAlltask().reversed()
    }
//this add a item to the list and return the list
    fun addTask(task : String){
       taskManager.addTask(task)
        getAlltask()
    }
//the remove a item to the list and return it
    fun deletetask(id : Int){
         taskManager.deletetask(id)
        getAlltask()
    }


}