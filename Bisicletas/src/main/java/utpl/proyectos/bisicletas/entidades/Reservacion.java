/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpl.proyectos.bisicletas.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sistemas
 */
@Entity
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")
    , @NamedQuery(name = "Reservacion.findById", query = "SELECT r FROM Reservacion r WHERE r.id = :id")
    , @NamedQuery(name = "Reservacion.findByFechaReservacion", query = "SELECT r FROM Reservacion r WHERE r.fechaReservacion = :fechaReservacion")
    , @NamedQuery(name = "Reservacion.findByIdCliente", query = "SELECT r FROM Reservacion r WHERE r.idCliente = :idCliente")
    , @NamedQuery(name = "Reservacion.findByIdUsuario", query = "SELECT r FROM Reservacion r WHERE r.idUsuario = :idUsuario")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_reservacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReservacion;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idCliente;
   @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "id_bicicleta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bicicleta idBicicleta;
    @OneToMany(mappedBy = "idReservacion")
    private List<Prestamo> prestamoList;

    public Reservacion() {
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Reservacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Bicicleta getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(Bicicleta idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utpl.proyectos.bisicletas.entidades.Reservacion[ id=" + id + " ]";
    }

}
