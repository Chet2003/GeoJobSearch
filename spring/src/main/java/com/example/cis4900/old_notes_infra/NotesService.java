package com.example.cis4900.old_notes_infra;

public interface NotesService {
    public String addNote(Note newNote);

    public Note getNote(Integer id);
    
    public String updateNote(Note updatedNote);

    public String deleteNote(Integer id);

    public Iterable<Note> allNotes();

    public Integer count();
}
