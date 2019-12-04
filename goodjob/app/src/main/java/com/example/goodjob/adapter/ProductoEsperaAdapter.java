package com.example.goodjob.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodjob.R;
import com.example.goodjob.classes.ProductoEspera;

import java.util.List;

public class ProductoEsperaAdapter extends RecyclerView.Adapter<ProductoEsperaAdapter.ProductoEsperaViewHolder> {

    private List<ProductoEspera> productosEnEspera;

    public ProductoEsperaAdapter(List<ProductoEspera> productosEnEspera) {
        this.productosEnEspera = productosEnEspera;
    }

    @NonNull
    @Override
    public ProductoEsperaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_producto_espera,
                viewGroup, false);
        return new ProductoEsperaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoEsperaViewHolder pvh, int index) {
        ProductoEspera pe = productosEnEspera.get(index);
        pvh.producto.setText(pe.getProducto());
        pvh.stock.setText(String.valueOf(pe.getStock()));
        pvh.valor.setText(String.valueOf(pe.getValor()));
        pvh.fechaRegistro.setText(pe.getFechaRegistro());
    }

    @Override
    public int getItemCount() {
        return productosEnEspera.size();
    }

    static class ProductoEsperaViewHolder extends RecyclerView.ViewHolder {
        TextView producto, stock, valor, fechaRegistro;

        private ProductoEsperaViewHolder(@NonNull View itemView) {
            super(itemView);
            producto = itemView.findViewById(R.id.tvProductoEsperaNombre);
            stock = itemView.findViewById(R.id.tvProductoEsperaStock);
            valor = itemView.findViewById(R.id.tvProductoEsperaValor);
            fechaRegistro = itemView.findViewById(R.id.tvProductoEsperaFechaRegistro);
        }
    }
}
