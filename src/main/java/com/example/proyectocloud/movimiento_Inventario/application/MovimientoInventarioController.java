package com.example.proyectocloud.movimiento_Inventario.application;

import com.example.proyectocloud.movimiento_Inventario.domain.MovimientoInventario;
import com.example.proyectocloud.movimiento_Inventario.domain.MovimientoInventarioSevice;
import com.example.proyectocloud.movimiento_Inventario.dto.MovimientoInventarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movimientos")
public class MovimientoInventarioController {
    private final MovimientoInventarioSevice movimientoInventarioService;

    @Autowired
    public MovimientoInventarioController(MovimientoInventarioSevice movimientoInventarioService) {
        this.movimientoInventarioService = movimientoInventarioService;
    }

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listarMovimientos() {
        List<MovimientoInventario> movimientoInventarios = movimientoInventarioService.listarMovimientos();
        return ResponseEntity.ok(movimientoInventarios);
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> crearMovimiento(@RequestBody MovimientoInventarioDTO movimientoDTO) {
        MovimientoInventario nuevoMovimiento = movimientoInventarioService.crearMovimiento(movimientoDTO);
        return ResponseEntity.ok(nuevoMovimiento);
    }
}
