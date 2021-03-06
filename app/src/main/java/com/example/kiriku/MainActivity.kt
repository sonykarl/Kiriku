package com.example.kiriku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kiriku.ui.screens.addNotesScreen
import com.example.kiriku.ui.screens.notesScreen
import com.example.kiriku.ui.theme.KirikuTheme
import com.example.kiriku.ui.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KirikuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                   navGraph()
                }
            }
        }
    }
}

@Composable
fun navGraph(){

    val context = LocalContext.current as ViewModelStoreOwner
    val viewModel = ViewModelProvider(context).get(NotesViewModel::class.java)
    val lifecycleOwner = LocalContext.current as LifecycleOwner
    val notesScreenUiState = viewModel.notesscreenuistate
    val navcontroller = rememberNavController()

    NavHost(navController = navcontroller, startDestination = "noteslist"){
        composable("noteslist"){
            notesScreen(notesScreenUiState = notesScreenUiState, lifecycleOwner = lifecycleOwner, navController = navcontroller)
        }
        composable("addnotes"){
            addNotesScreen(viewModel = viewModel, navController = navcontroller)
        }

    }
}
