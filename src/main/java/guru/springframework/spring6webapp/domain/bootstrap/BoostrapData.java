package guru.springframework.spring6webapp.domain.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring6webapp.domain.repositories.BookRepository;
import guru.springframework.spring6webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {

  final private AuthorRepository authorRepository;
  final private BookRepository bookRepository;
  final private PublisherRepository publisherRepository;

  public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("123456");

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("54757585");

    Publisher p1 = new Publisher();
    p1.setPublisherName("p1111");
    p1.setCity("city1");


    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);
    Author rodSaved = authorRepository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);
    Publisher p1Saved = publisherRepository.save(p1);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);
    dddSaved.setPublisher(p1Saved);
    noEJBSaved.setPublisher(p1Saved);



    authorRepository.save(rodSaved);
    authorRepository.save(ericSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count : "+authorRepository.count());
    System.out.println("Book Count : "+bookRepository.count());
    System.out.println("Publisher Count : "+publisherRepository.count());




  }
}
