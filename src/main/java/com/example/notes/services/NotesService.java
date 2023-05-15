package com.example.notes.services;

import com.example.notes.models.NoteModel;
import com.example.notes.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepository notesRepository;

    public List<NoteModel> getAllNotes(){
        return notesRepository.findAll();
    }

    public NoteModel getNoteById(Long id){
        return notesRepository.findById(id).get();
    }

    public String createNote(NoteModel note){
        notesRepository.save(note);
        return "note saved";
    }
}
