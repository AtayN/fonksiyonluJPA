package folder;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: urun
 *
 */
@Entity
@Table(name="urunler")
public class urun implements Serializable {

	   
	@Id
	@SequenceGenerator(allocationSize=1 , initialValue=1, name="urunSeq",sequenceName="urunSeq")
	@GeneratedValue(generator="urunSeq",strategy=GenerationType.SEQUENCE)
	@Column(name="urun_id")
	private long id;
	private String ismi;
	private double fiyati;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable( name="EMP_DEPT", 
	joinColumns= {@JoinColumn(name="urun_id", referencedColumnName ="urun_id")}, 
	inverseJoinColumns={@JoinColumn(name="sip_id", referencedColumnName ="sip_id")}) 
	private List <siparis > Siparis =new ArrayList<siparis>();;
	
	public List<siparis> getSiparis() {
		return Siparis;
	}
	
	
	public void setSiparis(List<siparis> siparis) {
		Siparis = siparis;
	}
	public urun() {
		super();
	}   
	public long get›d() {
		return this.id;
	}

	public void set›d(long id) {
		this.id = id;
	}   
	public String get›smi() {
		return this.ismi;
	}

	public void set›smi(String ismi) {
		this.ismi = ismi;
	}   
	public double getFiyati() {
		return this.fiyati;
	}

	public void setFiyati(double fiyati) {
		this.fiyati = fiyati;
	}   
	
   
}
