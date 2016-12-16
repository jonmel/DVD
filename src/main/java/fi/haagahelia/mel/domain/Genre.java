package fi.haagahelia.mel.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long Genreid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<DVDstore> DVDstores;
	
	public Genre() {}
	
	public Genre(String name) {
		super();
		this.name = name;
	}
	
	public Long getGenreid() {
		return Genreid;
	}
	
	public void setGenreid(Long Genreid) {
		this.Genreid = Genreid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<DVDstore> getDVDstores() {
		return DVDstores;
	}

	public void setStudents(List<DVDstore> DVDstores) {
		this.DVDstores = DVDstores;
	}

	@Override
	public String toString() {
		return "Department [Genreid=" + Genreid + ", name=" + name + "]";
	}
}
