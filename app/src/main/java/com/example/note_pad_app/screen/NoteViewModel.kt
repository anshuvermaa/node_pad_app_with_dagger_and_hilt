package com.example.note_pad_app.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.note_pad_app.data.NoteDataSource
import com.example.note_pad_app.model.Note

class NoteViewModel : ViewModel() {
   private var noteList= mutableListOf<Note>()

    init{
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)

    }
    fun removeNote(note:Note){
        noteList.remove(note)

    }

    fun getAllNotes():List<Note>{
        return noteList
    }
}

