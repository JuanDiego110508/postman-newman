package com.sena.inventario.service;

import com.sena.inventario.model.ProductoInventario;
import com.sena.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<ProductoInventario> obtenerTodos() {
        return inventarioRepository.findAll();
    }

    public ProductoInventario obtenerPorId(Long id) {
        return inventarioRepository.findById(id);
    }

    public ProductoInventario crear(ProductoInventario producto) {
        return inventarioRepository.save(producto);
    }

    public ProductoInventario actualizar(Long id, ProductoInventario producto) {
        return inventarioRepository.update(id, producto);
    }

    public boolean eliminar(Long id) {
        return inventarioRepository.deleteById(id);
    }
}
