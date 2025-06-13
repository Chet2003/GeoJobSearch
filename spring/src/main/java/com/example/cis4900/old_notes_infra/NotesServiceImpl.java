package com.example.cis4900.old_notes_infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesDao notesDao;

    @Override
    public String addNote(Note newNote) {
        try {
            notesDao.save(newNote);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Saved";
    }

    @Override
    public Note getNote(Integer id) {
        return notesDao.findById(id).get();
    }

    @Override
    public String updateNote(Note updatedNote) {
        try {
            notesDao.save(updatedNote);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Updated";
    }

    @Override
    public String deleteNote(Integer id) {
        try {
            notesDao.deleteById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted";
    }

    @Override
    public Iterable<Note> allNotes() {
        return notesDao.findAll();
    }

    @Override
    public Integer count() {
        return notesDao.getCount();
    }
}