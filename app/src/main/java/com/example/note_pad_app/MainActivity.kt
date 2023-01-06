package com.example.note_pad_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_pad_app.data.NoteDataSource
import com.example.note_pad_app.model.Note
import com.example.note_pad_app.screen.NoteScreen
import com.example.note_pad_app.screen.NoteViewModel
import com.example.note_pad_app.ui.theme.Note_pad_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Note_pad_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Surface {
                        val noteViewModel: NoteViewModel by viewModels()
                        NotesApp(noteViewModel)

                    }


                }
            }

        }
    }
}






@Composable
fun NotesApp(noteViewModel: NoteViewModel= viewModel()){
    val notesList=noteViewModel.getAllNotes()
    val context= LocalContext.current

    NoteScreen(notes =notesList, onAddNote = { it -> noteViewModel.addNote(it) },
        onRemoveNote = {it->
            noteViewModel.removeNote(it)
            Toast.makeText(context,"Note Removed Successfully", Toast.LENGTH_SHORT).show()

        })

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Note_pad_appTheme {
        NoteScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})

    }
}

