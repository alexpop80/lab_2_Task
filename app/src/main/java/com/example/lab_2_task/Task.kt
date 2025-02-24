package com.example.lab_2_task
//this data class
data class Task(
    var id: Int,
    var task: String
)

//this was just test if my list was look all right
fun getStartTask() : List<Task>{
    return listOf<Task>(
        Task(1,"take out the dog"),
        Task(2,"start  coding"),
        Task(3,"eat")
    )}