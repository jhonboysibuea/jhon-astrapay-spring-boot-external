package com.astrapay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrapay.dto.NoteDto;
import com.astrapay.entity.Note;
import com.astrapay.entity.mapper.NoteMapper;
import com.astrapay.service.NoteService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/notes")
@Api(value = "NoteController")
@Slf4j
public class NoteController {
    @Autowired
    private NoteService noteService;
    
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllnotes();
    }

    @PostMapping
    public Note createNote(@RequestBody NoteDto noteDto) {
        Note note=NoteMapper.toEntity(noteDto);
        return noteService.createNote(note);
    }
    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable Long id){
        return noteService.deleteNote(id);
    }
    

}
