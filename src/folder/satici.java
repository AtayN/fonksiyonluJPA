package folder;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity implementation class for Entity: sat�c�
 *
 */
@Entity
@Table(name="saticilar")
public class satici implements Serializable {

	   
	@Id
	@SequenceGenerator(allocationSize=1 , initialValue=1, name="saticiSeq",sequenceName="saticiSeq")
	@GeneratedValue(generator="saticiSeq",strategy=GenerationType.SEQUENCE)
	@Column(name="sat_id")
	private long id;
	
	private String isim;
	private String sifre;
	private static final long serialVersionUID = 1L;

	 @OneToMany(mappedBy="customer", fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	 private List <siparis> orders =  new ArrayList<siparis>();
	
	public List<siparis> getOrders() {
		return orders;
	}
	public void setOrders(List<siparis> orders) {
		this.orders = orders;
	}
   

	public satici() {
		super();
	}   
	public long get�d() {
		return this.id;
	}

	public void set�d(long id) {
		this.id = id;
	}   
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String get�sim() {
		return this.isim;
	}

	public void set�sim(String isim) {
		this.isim = isim;
	}   


}
