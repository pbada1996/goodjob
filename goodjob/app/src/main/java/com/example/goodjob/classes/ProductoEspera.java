package com.example.goodjob.classes;

import org.json.JSONObject;

public class ProductoEspera {

    private Integer id;
    private String producto;
    private Integer stock;
    private Double valor;
    private String fechaRegistro;

    public ProductoEspera() {
    }

    public static ProductoEspera cargarDesdeJson(JSONObject data) {
        ProductoEspera pe = new ProductoEspera();
        pe.id = data.optInt("id");
        pe.producto = data.optString("nombre");
        pe.stock = data.optInt("stock");
        pe.valor = data.optDouble("valor") * 7;
        pe.fechaRegistro = data.optString("fecha_registro");
        return pe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
