package roshan.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import roshan.learning.spring5webapp.model.Author;
import roshan.learning.spring5webapp.model.Book;
import roshan.learning.spring5webapp.repository.AuthorRepository;
import roshan.learning.spring5webapp.repository.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepositoryObj;
    private BookRepository bookRepositoryObj;

    public DevBootStrap(AuthorRepository authorRepositoryObj, BookRepository bookRepositoryObj) {
        this.authorRepositoryObj = authorRepositoryObj;
        this.bookRepositoryObj = bookRepositoryObj;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

        Author authObj = new Author("Roshan","Kotian");
        Book bookObj = new Book("Doamin Driven Design","1234","Pearson");
        authObj.getBooks().add(bookObj);
        bookObj.getAuthors().add(authObj);

        authorRepositoryObj.save(authObj);
        bookRepositoryObj.save(bookObj);

    }
}
