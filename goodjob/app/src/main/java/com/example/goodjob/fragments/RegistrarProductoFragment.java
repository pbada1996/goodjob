package com.example.goodjob.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.support.design.widget.TextInputLayout;
import android.widget.Toast;

import com.example.goodjob.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class RegistrarProductoFragment extends Fragment {

    private EditText producto, valor, stock, lugarCanje;
    private ImageView imagen;
    private TextInputLayout tilProducto, tilValor, tilStock,
            tilLugarCanje;
    private Bitmap bitmap;

    private final int CAMPO_VACIO = 0;
    final int NOMBRE_PRODUCTO_TOPE_LONGITUD = 40;
    final int LUGAR_CANJE_TOPE_LONGITUD = 250;
    final int STOCK_MINIMO = 1;
    final int REQUEST_CODE_GALLERY = 78;

    public RegistrarProductoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registrar_producto, container, false);

        mapearViews(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        clickEnImagen();
    }

    private void mapearViews(View v) {
        producto = v.findViewById(R.id.etNombreProductoRegistro);
        valor = v.findViewById(R.id.etValorProductoRegistro);
        stock = v.findViewById(R.id.etCantidadProductoRegistro);
        lugarCanje = v.findViewById(R.id.etLugarCanje);
        imagen = v.findViewById(R.id.ivImagenProductoRegistro);
        tilProducto = v.findViewById(R.id.tilNombreProducto);
        tilValor = v.findViewById(R.id.tilValorProducto);
        tilStock = v.findViewById(R.id.tilCantidadProductoRegistro);
        tilLugarCanje = v.findViewById(R.id.tilLugarCanje);
    }

    private void clickEnImagen() {
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarPermisosDeLectura();
            }
        });
    }

    private void solicitarPermisosDeLectura() {
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_GALLERY);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                abrirGaleria();
            } else {
                Toast.makeText(getContext(), "Permisos no concedidos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            try {
                setearImagenSeleccionada(data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void setearImagenSeleccionada(Intent data) throws FileNotFoundException {
        InputStream input = getActivity().getContentResolver().openInputStream(data.getData());
        bitmap = BitmapFactory.decodeStream(input);
        imagen.setImageBitmap(bitmap);
    }

    private String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] imgBytes = baos.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }
}
