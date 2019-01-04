package com.learningstuff.onlinenotebook.repositroy;

import com.learningstuff.onlinenotebook.model.Note;
import com.learningstuff.onlinenotebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findNotesByUser(User user);

    Note findNoteByIdAndUser(long id, User user);

    int deleteNoteByIdAndUser(long id, User user);
}
