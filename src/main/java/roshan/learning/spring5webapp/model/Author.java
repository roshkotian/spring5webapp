package roshan.learning.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String authorFirstName;
  private String authorLastName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet();


  public Author(){

  }

  public Author(String authorFirstName, String authorLastName) {
    this.authorFirstName = authorFirstName;
    this.authorLastName = authorLastName;
  }

  public Author(String authorFirstName, String authorLastName, Set<Book> books) {
    this.authorFirstName = authorFirstName;
    this.authorLastName = authorLastName;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthorFirstName() {
    return authorFirstName;
  }

  public void setAuthorFirstName(String authorFirstName) {
    this.authorFirstName = authorFirstName;
  }

  public String getAuthorLastName() {
    return authorLastName;
  }

  public void setAuthorLastName(String authorLastName) {
    this.authorLastName = authorLastName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return Objects.equals(id, author.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Author{" +
            "id=" + id +
            ", authorFirstName='" + authorFirstName + '\'' +
            ", authorLastName='" + authorLastName + '\'' +
            ", books=" + books +
            '}';
  }
}
