package com.astrapay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.astrapay.entity.Note;
import com.astrapay.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoteService {
    private final List<Note> notes=new ArrayList<>();
    private final AtomicLong atomicLong=new AtomicLong();
    public List<Note> getAllnotes(){
        return notes;
    }
    public Note createNote(Note note) {
        note.setId(atomicLong.incrementAndGet());
        notes.add(note);
        return note;
        
    }
    public boolean deleteNote(Long id) {
       
        Optional<Note> note = notes.stream()
                                   .filter(n -> n.getId().equals(id))
                                   .findFirst();
        
   
        if (!note.isPresent()) {
            throw new NotFoundException("Note not found with id: " + id);
        }
        
        
       
        return notes.removeIf(n -> n.getId().equals(id));
    }
    
}
