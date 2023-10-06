package tovar.p3_tarea1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tovar.p3_tarea1.entity.Factura;
import tovar.p3_tarea1.repository.FacturaRepository;
import tovar.p3_tarea1.repository.LineaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturaRepository facturaRepository;
    //Agrega una factura nueva
    @PostMapping("add")
    public Factura addFactura (@RequestBody Factura factura){
        return facturaRepository.save(factura);
    }
    //lista todas las facturas en la BD
    @GetMapping("getall")
    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }

    //lista una factura por id
    @GetMapping("getById/{id}")
    public Optional<Factura> getFacturaId(@PathVariable(value = "id")Long id){
        return facturaRepository.findById(id);
    }
    //lista la cantidad de lineas de una factura
    @GetMapping("lineaCount/{id}")
    public int getLineasCount(@PathVariable(value = "id")Long id){
        return facturaRepository.findCount(id);
    }

    //calcula el total de una factura
    @GetMapping("totalFactura/{id}")
    public double getTotal(@PathVariable(value = "id")Long id){
        return facturaRepository.getTotal(id);
    }
}
