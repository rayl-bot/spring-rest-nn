package spring.app.main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="piezas")
public class Pieza {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id_pieza;
    @Column(name="nombre")
    private String nombre;

    @OneToMany
    @JoinColumn(name="id_pieza")
    private List<ProporcionaPieza> piezasPropo;

    //Cosntructor por defecto
    public Pieza(){

    }

    /**
	 * @param id
	 * @param nombre
	 * @param piezasPropo
	 */
	public Pieza(int id, String nombre, List<ProporcionaPieza> piezasPropo) {
		this.id_pieza = id;
		this.nombre = nombre;
		this.piezasPropo = piezasPropo;
	}

    /**
	 * @return the id
	 */
	public int getId() {
		return id_pieza;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id_pieza = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "suministra")
	public List<ProporcionaPieza> getPiezasPropo() {
		return piezasPropo;
	}

    public void setPiezasPropo(List<ProporcionaPieza> piezasPropo) {
		this.piezasPropo = piezasPropo;
	}

}
