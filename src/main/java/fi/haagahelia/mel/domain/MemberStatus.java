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
public class MemberStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long MemberStatusid;
	private String name1;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "memberstatus")
	private List<Reservation> Reservations;
	
	public MemberStatus() {}
	
	public MemberStatus(String name1) {
		super();
		this.name1 = name1;
	}
	
	public Long getMemberStatusid() {
		return MemberStatusid;
	}
	
	public void setMemberStatusid(Long MemberStatus) {
		this.MemberStatusid = MemberStatus;
	}
	
	public String getName1() {
		return name1;
	}
	
	public void setName1(String name1) {
		this.name1 = name1;
	}

	public List<Reservation> getReservations() {
		return Reservations;
	}

	public void setStudents(List<Reservation> Reservations) {
		this.Reservations = Reservations;
	}

	@Override
	public String toString() {
		return "Department [Genreid=" + MemberStatusid + ", name=" + name1 + "]";
	}
}
