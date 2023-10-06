package tovar.p3_tarea1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tovar.p3_tarea1.entity.Linea;
import tovar.p3_tarea1.repository.LineaRepository;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linea")
public class LineaController {
    @Autowired
    LineaRepository lineaRepository;

    //crear linea de factura
    @PostMapping("add")
    public Linea addLinea(@RequestBody Linea linea){
        linea.setPrecioTotal();
        return lineaRepository.save(linea);
    }

    //lista todas las lineas
    @GetMapping("getall")
    public List<Linea> getAllLineas(){
        return lineaRepository.findAll();
    }

    //Modificar linea de factura
    @PutMapping("update/{id}")
    public ResponseEntity<Linea> updateLinea(
            @PathVariable(value = "id")Long id, @RequestBody Linea lineaUpdate){

        Optional<Linea> linea = lineaRepository.findById(id);

        linea.get().setCantidad(lineaUpdate.getCantidad());
        linea.get().setProducto(lineaUpdate.getProducto());
        linea.get().setPrecioUnitario(lineaUpdate.getPrecioUnitario());
        linea.get().setPrecioTotal();

        Linea updatedLinea = lineaRepository.save(linea.get());
        return ResponseEntity.ok(updatedLinea);
    }

    //borrar linea de factura
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteLinea(@PathVariable(value = "id")Long id){
        lineaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
