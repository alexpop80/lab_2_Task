package com.example.lab_2_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.lab_2_task.ui.theme.Lab_2_TaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         //this here so my ViewModel work and i can use the function in it
        val TaskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            Lab_2_TaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color???
                )
                {
                    Taskpage(TaskViewModel)
                }
                }
            }
        }
    }


