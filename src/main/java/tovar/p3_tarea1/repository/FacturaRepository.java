package tovar.p3_tarea1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tovar.p3_tarea1.entity.Factura;

public interface FacturaRepository  extends JpaRepository<Factura, Long> {

    //Contar las lineas de una factura
    @Query("select count(c) from Linea c where c.factura.id = ?1")
    int findCount(long id);

    //calcular total de la factura
    @Query("select sum(c.precioTotal) from Linea c where c.factura.id = ?1")
    double getTotal(long id);
}
