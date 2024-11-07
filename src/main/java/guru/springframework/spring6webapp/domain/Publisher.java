package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String publisherName;
  String adress;
  String city;
  String state;
  Long zip;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Long getZip() {
    return zip;
  }

  public void setZip(Long zip) {
    this.zip = zip;
  }

  @Override
  public String toString() {
    return "Publisher{" +
      "id=" + id +
      ", adress='" + adress + '\'' +
      ", city='" + city + '\'' +
      ", state='" + state + '\'' +
      ", zip=" + zip +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Publisher publisher = (Publisher) o;

      return Objects.equals(id, publisher.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
