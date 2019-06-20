package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.JPANoteRepository;
import models.Note;
import models.NoteRepository;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.function.Supplier;

public class NotesController extends Controller {

    @Inject
    JPANoteRepository noteRepository;


    //    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> getAll() {
        return noteRepository.list().thenApplyAsync((result) -> ok(Json.toJson(result)));

    }

    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> addNote(Http.Request request) {
        Optional<Note> optionalNote = request.body().parseJson(Note.class);
        if (!optionalNote.isPresent()) {
            return CompletableFuture.supplyAsync(Results::badRequest);
        }
        Note note = optionalNote.get();

        return noteRepository.insert(note).thenApplyAsync(note1 -> ok(Json.toJson(note1)));
    }


    public CompletionStage<Result> getNoteById(int id) {

        return noteRepository.findById(id).thenApplyAsync(note -> {
            if (note.isPresent()) {

                return ok(Json.toJson(note));
            } else {
                return notFound();
            }
        });

    }

    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> updateNote(int id, Http.Request request) {

        Note note = request.body().parseJson(Note.class).get();
        return noteRepository.update(id, note).thenApplyAsync(result -> {
            if (result.isPresent()) {
                return ok(Json.toJson(result));
            } else {
                return badRequest();
            }
        });

    }


//    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> deleteNote(int id) {
        return noteRepository.delete(id).thenApplyAsync((Function<Void, Result>) aVoid -> ok());
    }

}
