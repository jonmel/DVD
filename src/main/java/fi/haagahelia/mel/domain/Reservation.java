package fi.haagahelia.mel.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id1;
    private String title1;
    private String director1;
    private String cast1;
    private String returndate;
    private String price1;
    
    @ManyToOne
    @JoinColumn(name = "MemberStatusid")
    private MemberStatus memberstatus;
    


    public Reservation() {}

	public Reservation(String title1, String director1 , String cast1 , String returndate , String price1 , MemberStatus memberstatus) {
		super();
		this.title1 = title1;
		this.director1 = director1;
		this.cast1 = cast1;
		this.returndate = returndate;
		this.price1 = price1;
		this.memberstatus = memberstatus;
		
	}

	public Long getId1() {
		return id1;
	}

	public void setId1(Long id1) {
		this.id1 = id1;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getDirector1() {
		return director1;
	}

	public void setDirector1(String director1) {
		this.director1 = director1;
	}

	public String getCast1() {
		return cast1;
	}

	public void setCast1(String cast1) {
		this.cast1 = cast1;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public MemberStatus getMemberStatus() {
		return memberstatus;
	}

	public void setMemberStatus(MemberStatus memberstatus) {
		this.memberstatus = memberstatus;
	}

	@Override
	public String toString() {
		if (this.memberstatus != null)
			return "Reservation [id=" + id1 + ", title=" + title1 + ", author=" + director1 + ", year=" + cast1 + ", isbn=" + returndate + ", price=" + price1 + " memberstatus =" + this.getMemberStatus() + "]";
		else
			return "Reservation [id=" + id1 + ", title=" + title1 + ", author=" + director1 + ", year=" + cast1 + ", isbn=" + returndate + ", price=" + price1 + "]";
			
	}
}

