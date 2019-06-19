package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Note;
import models.NoteRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.Optional;

public class NotesController extends Controller {

    @Inject
    NoteRepository noteRepository;

    public Result getAll() {
        return ok(Json.toJson(noteRepository.getAll()));
    }

    public Result addNote(Http.Request request) {
        Optional<Note> optionalNote= request.body().parseJson(Note.class);
        if (!optionalNote.isPresent()) {
            return Results.badRequest();
        }
        Note note = optionalNote.get();

        Note mangedNote = noteRepository.insertNote(note);
        return ok(Json.toJson(mangedNote));
    }

    public Result getNoteById(int id) {

        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            return ok(Json.toJson(note));
        } else {
            return notFound();
        }

    }

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
