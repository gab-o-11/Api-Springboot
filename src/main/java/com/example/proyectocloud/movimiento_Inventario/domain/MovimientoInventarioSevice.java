package com.example.proyectocloud.movimiento_Inventario.domain;

import com.example.proyectocloud.movimiento_Inventario.dto.MovimientoInventarioDTO;
import com.example.proyectocloud.movimiento_Inventario.infrastructure.MovimientoInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioSevice {
    private final MovimientoInventarioRepository movimientoInventarioRepository;

    @Autowired
    public MovimientoInventarioSevice(MovimientoInventarioRepository movimientoInventarioRepository) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
    }
    public List<MovimientoInventario> listarMovimientos() {
        return movimientoInventarioRepository.findAll();
    }
    public MovimientoInventario crearMovimiento(MovimientoInventarioDTO createMovimientoDTO) {
        MovimientoInventario movimientoInventario = new MovimientoInventario();
        movimientoInventario.setType(createMovimientoDTO.getType());
        movimientoInventario.setQuantity(createMovimientoDTO.getQuantity());
        movimientoInventario.setDate(createMovimientoDTO.getDate());
        movimientoInventario.setProduct_id(createMovimientoDTO.getProduct_id());
        movimientoInventario.setUser_id(createMovimientoDTO.getUser_id());

        MovimientoInventario savedMovimiento = movimientoInventarioRepository.save(movimientoInventario);

        return savedMovimiento;
    }
}
