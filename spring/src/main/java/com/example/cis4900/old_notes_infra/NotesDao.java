package com.example.cis4900.old_notes_infra;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NotesDao extends CrudRepository<Note, Integer> {

    @Query("SELECT COUNT(*) FROM Note")
    Integer getCount();
}
