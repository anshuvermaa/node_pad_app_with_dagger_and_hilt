package com.example.note_pad_app.data

import android.util.Log
import com.example.note_pad_app.model.Note

class  NoteDataSource{
    fun loadNotes():List<Note> {
        Log.d("note","callled")
        return listOf(
            Note(title="A good day", description = "We wen t on a vacation for fun and moke lots of fun funck"),
            Note(title="A good day", description = "We wen t on a vacation for fun and moke lots of fun funck"),
            Note(title="A good day", description = "We wen t on a vacation for fun and moke lots of fun funck"),
            Note(title="A good day", description = "We wen t on a vacation for fun and moke lots of fun funck"),
            Note(title="A good day", description = "We wen t on a vacation for fun and moke lots of fun funck")


        )

    }
}