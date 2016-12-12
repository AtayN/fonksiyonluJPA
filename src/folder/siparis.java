package folder;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.lang.String;
import java.nio.MappedByteBuffer;

import javax.persistence.*;

import folder.*;

/**
 * Entity implementation class for Entity: siparis
 *
 */
@Entity
@Table(name = "siparis")
public class siparis implements Serializable {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "siparisSeq", sequenceName = "siparisSeq")
	@GeneratedValue(generator = "siparisSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "sip_id")
	private long id;
	private String musAdi;
	private double tutar;
	private static final long serialVersionUID = 1L;

	public siparis() {
		super();
	}

	public long get›d() {
		return this.id;
	}

	public void set›d(long id) {
		this.id = id;
	}

	public String getMusAdi() {
		return this.musAdi;
	}

	public void setMusAdi(String musAdi) {
		this.musAdi = musAdi;
	}

	public double getTutar() {
		return this.tutar;
	}

	public void setTutar(double tutar) {
		this.tutar = tutar;
	}

	@ManyToOne
	@JoinColumn(name = "sat_id", referencedColumnName = "sat_id")
	private satici customer;

	public satici getCustomer() {
		return customer;
	}

	public void setCustomer(satici customer) {
		this.customer = customer;

	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "Siparis")

	private List<urun> Urun = new ArrayList<urun>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "Siparis")
	public List<urun> getUrun() {
		return Urun;
	}

	public void setUrunler(List<urun> urunler) {
		Urun = urunler;
	}

}
