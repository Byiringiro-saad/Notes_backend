package com.example.notes.repositories;

import com.example.notes.models.NoteModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotesRepository extends JpaRepository<NoteModel, Long> {}
