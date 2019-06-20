package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

@Singleton
public class JPANoteRepository {

    @Inject
    private JPAApi jpaApi;

    @Inject
    private DatabaseCustomExecutor executor;

    public JPANoteRepository() {
    }


    public CompletionStage<List<Note>> list() {
        return CompletableFuture.supplyAsync(() -> jpaApi.withTransaction(entityManager -> {
                    return entityManager.createQuery("select e from Note e", Note.class)
                            .getResultList();
                })
                , executor);

    }

    public CompletionStage<Note> insert(Note note) {


        return CompletableFuture.supplyAsync(new Supplier<Note>() {
            @Override
            public Note get() {
                jpaApi.withTransaction(entityManager -> {
                    entityManager.persist(note);
                    return note;
                });

                return note;
            }
        }, executor);
    }

    public CompletionStage<Optional<Note>> update(int id,Note note) {

        return CompletableFuture.supplyAsync(() -> {

            Optional<Note> optionalNote = Optional.ofNullable(jpaApi.withTransaction(entityManager -> {
                Note foundNote = entityManager.find(Note.class, id);
                if (foundNote != null) {
                    note.setId(id);
                    return entityManager.merge(note);
                } else {
                    return null;
                }
            }));
            return optionalNote;
        }, executor);


    }



    public CompletionStage<Optional<Note>> findById(int id) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<Note> optionalNote = jpaApi.withTransaction(entityManager -> {
                return Optional.ofNullable(entityManager.find(Note.class, id));
            });
            return optionalNote;
        }, executor);
    }

    public CompletionStage<Void> delete(int id) {
        return CompletableFuture.runAsync(() -> {
            jpaApi.withTransaction(entityManager -> {
                Note note = entityManager.find(Note.class, id);
                if (note != null) {
                    entityManager.remove(note);
                }
            });
        }, executor);
    }

}
