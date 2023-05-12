package com.example.notes.controllers;

import com.example.notes.models.NoteModel;
import com.example.notes.services.NotesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class NotesController {
    @Autowired
    NotesService notesService;

    @GetMapping("/notes")
    public List<NoteModel> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public NoteModel getNote(@PathVariable("id") Long id){
        return notesService.getNoteById(id);
    }

    @PostMapping("/notes")
    public String createNote(@RequestBody NoteModel note) {
        notesService.createNote(note);
        return "note saved";
    }

}
