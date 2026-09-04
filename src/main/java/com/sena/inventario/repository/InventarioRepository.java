package com.sena.inventario.repository;

import com.sena.inventario.model.ProductoInventario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventarioRepository {

    private final List<ProductoInventario> productos = new ArrayList<>();
    private Long siguienteId = 1L;

    public InventarioRepository() {
        productos.add(new ProductoInventario(siguienteId++, "Laptop Dell Inspiron", "Electrónica", 12, 2500000, "Bodega A"));
        productos.add(new ProductoInventario(siguienteId++, "Silla ergonómica", "Mobiliario", 30, 350000, "Bodega B"));
        productos.add(new ProductoInventario(siguienteId++, "Monitor LG 24 pulgadas", "Electrónica", 0, 650000, "Bodega A"));
        productos.add(new ProductoInventario(siguienteId++, "Escritorio de madera", "Mobiliario", 8, 480000, "Bodega C"));
    }

    public List<ProductoInventario> findAll() {
        return productos;
    }

    public ProductoInventario findById(Long id) {
        for (ProductoInventario producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public ProductoInventario save(ProductoInventario producto) {
        producto.setId(siguienteId++);
        productos.add(producto);
        return producto;
    }

    public ProductoInventario update(Long id, ProductoInventario datosNuevos) {
        ProductoInventario producto = findById(id);
        if (producto == null) {
            return null;
        }
        producto.setNombre(datosNuevos.getNombre());
        producto.setCategoria(datosNuevos.getCategoria());
        producto.setCantidad(datosNuevos.getCantidad());
        producto.setPrecio(datosNuevos.getPrecio());
        producto.setUbicacion(datosNuevos.getUbicacion());
        return producto;
    }

    public boolean deleteById(Long id) {
        ProductoInventario producto = findById(id);
        if (producto == null) {
            return false;
        }
        productos.remove(producto);
        return true;
    }
}
