package fi.haagahelia.mel.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class DVDstore {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String director;
    private String duration;
    private String cast;
    private String price;
    
    @ManyToOne
    @JoinColumn(name = "Genreid")
    private Genre genre;
    


    public DVDstore() {}

	public DVDstore(String title, String director , String duration , String cast , String price , Genre genre) {
		super();
		this.title = title;
		this.director = director;
		this.duration = duration;
		this.cast = cast;
		this.price = price;
		this.genre = genre;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
			return "DVDstore [id=" + id + ", title=" + title + ", director=" + director + ", duration=" + duration + ", cast=" + cast + ", price=" + price + " genre =" + this.getGenre() + "]";
		else
			return "DVDstore [id=" + id + ", title=" + title + ", director=" + director + ", duration=" + duration + ", cast=" + cast + ", price=" + price + "]";
			
	}
}
