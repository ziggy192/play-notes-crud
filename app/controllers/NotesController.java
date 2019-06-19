package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Note;
import models.NoteRepository;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.Optional;

public class NotesController extends Controller {

    @Inject
    NoteRepository noteRepository;


    @BodyParser.Of(BodyParser.Json.class)
    public Result getAll() {
        return ok(Json.toJson(noteRepository.getAll()));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result addNote(Http.Request request) {
        Optional<Note> optionalNote= request.body().parseJson(Note.class);
        if (!optionalNote.isPresent()) {
            return Results.badRequest();
        }
        Note note = optionalNote.get();

        Note mangedNote = noteRepository.insertNote(note);
        return ok(Json.toJson(mangedNote));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result getNoteById(int id) {

        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            return ok(Json.toJson(note));
        } else {
            return notFound();
        }

    }
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateNote(int id, Http.Request request) {

        Optional<Note> optionalNote = noteRepository.findById(id);
        if (!optionalNote.isPresent()) {
            return notFound();

        }
        Note note = request.body().parseJson(Note.class).get();
        note.setId(id);
        try {
            return ok(Json.toJson(noteRepository.updateNote(note)));
        } catch (Throwable throwable) {
            return badRequest();
        }

    }
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteNote(int id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            noteRepository.deleteNote(optionalNote.get());
            return ok();
        } else {
            return notFound();
        }
    }

}
