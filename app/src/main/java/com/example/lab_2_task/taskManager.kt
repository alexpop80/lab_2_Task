package com.example.lab_2_task

object taskManager {
    private val tasklist = mutableListOf<Task>()
//this return the list
    fun getAlltask() : List<Task>{
  return tasklist
    }

    //this make a new item to the list with a uqnie id
    fun addTask(task: String){
        tasklist.add(Task(System.currentTimeMillis().toInt(),task))

    }
// this delete an item with an id
    fun deletetask(id : Int){
        tasklist.removeIf { it.id==id }

    }
}