package telran.java47.book.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 2722622342427943784L;
	@Id
	String name;
	LocalDate birdDate;
	@ManyToMany(mappedBy = "authors")
	Set<Book> books;
	
	public Author(String name, LocalDate birdDate) {
		this.name = name;
		this.birdDate = birdDate;
	}
	
	
}
