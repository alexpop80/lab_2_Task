package com.example.lab_2_task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Taskpage(viewModel: TaskViewModel){

    val tasklist by viewModel.tasklist.observeAsState()
// this make the textField work
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter task") }
            )
// this is the add button
            Button(onClick = {
                viewModel.addTask(text)
                text = ""
            }){
                Text(text = "Add")

            }
        }
// this let the list be able to be displayed
        tasklist?.let{
            LazyColumn(
                content = {
                    itemsIndexed(it){index: Int, item: Task  ->

                        TaskItem(item = item, onDelet = {viewModel.deletetask(item.id)}

                        )
                    }
                }
            )
        }

    }
}

// this big chuck of code is how i made the the task look
@Composable
fun TaskItem(item: Task, onDelet : ()-> Unit){
    val isChecked = remember { mutableStateOf(false) }

   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(8.dp),
verticalAlignment = Alignment.CenterVertically
   ) {

       //this the checkbox
       Checkbox(
       checked = isChecked.value,
       onCheckedChange = { isChecked.value = it }
   )
      Column(
          modifier = Modifier.weight(1f)
      ){
//this the name of the task
          Text(
              text = item.task,
              fontSize = 25.sp

          )
      }
// this is the delete button
       IconButton(onClick = onDelet){
           Icon(painter = painterResource(id = R.drawable.baseline_delete_24),
               contentDescription ="")
       }
   }
}

