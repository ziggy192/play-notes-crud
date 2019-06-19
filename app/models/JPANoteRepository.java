package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

//@Singleton
public class JPANoteRepository  {

    @Inject
    private JPAApi jpaApi;

    @Inject
    private DatabaseCustomExecutor executor;

    public JPANoteRepository() {
    }


    public CompletableFuture<List<Note>> list() {
      return   CompletableFuture.supplyAsync(() -> jpaApi.withTransaction(entityManager -> {
                    return entityManager.createQuery("select e from Note e", Note.class)
                            .getResultList();
                })
                , executor);

    }

    public CompletableFuture<Note> insert(Note note) {


        return CompletableFuture.supplyAsync(new Supplier<Note>() {
            @Override
            public Note get() {
                jpaApi.withTransaction(entityManager -> {
                return entityManager.merge(note);
            });
                return note;


            }
        });
    }

}
