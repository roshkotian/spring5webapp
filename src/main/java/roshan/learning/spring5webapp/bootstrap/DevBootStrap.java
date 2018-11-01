package roshan.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import roshan.learning.spring5webapp.model.Author;
import roshan.learning.spring5webapp.model.Book;
import roshan.learning.spring5webapp.model.Publisher;
import roshan.learning.spring5webapp.repository.AuthorRepository;
import roshan.learning.spring5webapp.repository.BookRepository;
import roshan.learning.spring5webapp.repository.PublisherRepository;

import java.util.HashSet;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepositoryObj;
    private BookRepository bookRepositoryObj;
    private PublisherRepository publisherRepositoryObj;


    public DevBootStrap(AuthorRepository authorRepositoryObj, BookRepository bookRepositoryObj, PublisherRepository publisherRepositoryObj) {
        this.authorRepositoryObj = authorRepositoryObj;
        this.bookRepositoryObj = bookRepositoryObj;
        this.publisherRepositoryObj = publisherRepositoryObj;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

        Publisher publisherObj = new Publisher("Pearson Bronsman","Fort Wayne");
        publisherRepositoryObj.save(publisherObj);
        Author authObj = new Author("Roshan","Kotian");
        Book bookObj = new Book("Doamin Driven Design","1234",publisherObj);
        authObj.getBooks().add(bookObj);
        bookObj.getAuthors().add(authObj);

        authorRepositoryObj.save(authObj);
        bookRepositoryObj.save(bookObj);

    }
}
