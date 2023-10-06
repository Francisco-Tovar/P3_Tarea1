package tovar.p3_tarea1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tovar.p3_tarea1.entity.Linea;

public interface LineaRepository extends JpaRepository<Linea, Long> {

}
