package com.astrapay.entity.mapper;

import com.astrapay.dto.NoteDto;
import com.astrapay.entity.Note;

public class NoteMapper {
 public static Note toEntity(NoteDto dto) {
        Note note = new Note();
        note.setContent(dto.getContent());
        return note;
    }
}
