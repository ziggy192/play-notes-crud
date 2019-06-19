package models;

import java.util.*;
import java.util.function.Supplier;

public class NoteRepository {


    private static List<Note> notes = new ArrayList<>();

    public NoteRepository() {
        notes.addAll(Arrays.asList(
                new Note(1, "hello", "body")
                , new Note(2, "John", "Doo")
                , new Note(3, "Jack", "Barker")));
    }

    public List<Note> getAll() {

        return notes;
    }

    public Optional<Note> findById(int id) {
        return notes.stream().filter(note -> note.getId() == id).findAny();
    }

    public Note insertNote(Note note) {
        if (note.getId() <= 0) {
            note.setId(UUID.randomUUID().hashCode());
        }
        notes.add(note);
        return note;
    }

    public Note updateNote(Note note) throws Throwable {
        Note foundNote = findById(note.getId())
                .orElseThrow(new Supplier<Throwable>() {
                    @Override
                    public Throwable get() {
                        return new Exception("Note not found");
                    }
                });

        foundNote.setBody(note.getBody());
        foundNote.setTitle(note.getTitle());
        return foundNote;

    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }
}
