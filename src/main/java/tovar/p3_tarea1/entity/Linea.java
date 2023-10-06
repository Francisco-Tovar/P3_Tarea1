package tovar.p3_tarea1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Linea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String producto;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private double precioUnitario;
    @Column(nullable = false)
    private double precioTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_fk")
    @JsonBackReference
    private Factura factura;

    public Linea() {    }

    public Linea(Long id, String producto, Integer cantidad, double precioUnitario, Factura factura) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioUnitario * cantidad;
        this.factura = factura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal() {
        this.precioTotal = this.precioUnitario * this.cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
