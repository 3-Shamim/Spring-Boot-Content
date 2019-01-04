package com.learningstuff.onlinenotebook.sevice;

import com.learningstuff.onlinenotebook.model.Note;
import com.learningstuff.onlinenotebook.model.User;
import com.learningstuff.onlinenotebook.repositroy.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note saveNote(Note note, User user) {
        note.setUser(user);
        return noteRepository.save(note);
    }

    public List<Note> findAllNotesByUser(User user) {
        return noteRepository.findNotesByUser(user);
    }

    public Note findNoteById(long id, User user) {
        return noteRepository.findNoteByIdAndUser(id, user);
    }

    public int deleteNoteById(long id, User user) {

        return noteRepository.deleteNoteByIdAndUser(id, user);
    }

}
