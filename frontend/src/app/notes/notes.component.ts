import { Component, OnInit } from '@angular/core';
import { Note, NoteService } from '../note.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-notes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notes: Note[] = [];
  newNote: string = '';

  constructor(private noteService: NoteService) {}

  ngOnInit() {
    this.loadNotes();
  }

  loadNotes() {
    this.noteService.getNotes().subscribe(data => this.notes = data);
  }

  addNote() {
    if (this.newNote.trim()) {
      this.noteService.addNote({ content: this.newNote }).subscribe(note => {
        this.notes.push(note);
        this.newNote = '';
      });
    }
  }

  deleteNote(id: number) {
    this.noteService.deleteNote(id).subscribe(() => {
      this.notes = this.notes.filter(n => n.id !== id);
    });
  }
}
