package com.example.goodjob.classes;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Empresa implements Parcelable {

    private Integer id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correo;
    private String direccion;
    private String fechaRegistro;
    private String codigoPostal;
    private String password;
    private String distrito;
    private Integer numeroActividades; // publicadas me imagino, right ?
    private Integer estado;

    public Empresa() {
    }

    protected Empresa(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        razonSocial = in.readString();
        nombreComercial = in.readString();
        ruc = in.readString();
        telefono = in.readString();
        correo = in.readString();
        direccion = in.readString();
        fechaRegistro = in.readString();
        codigoPostal = in.readString();
        password = in.readString();
        distrito = in.readString();
        if (in.readByte() == 0) {
            numeroActividades = null;
        } else {
            numeroActividades = in.readInt();
        }
        if (in.readByte() == 0) {
            estado = null;
        } else {
            estado = in.readInt();
        }
    }

    public static final Creator<Empresa> CREATOR = new Creator<Empresa>() {
        @Override
        public Empresa createFromParcel(Parcel in) {
            return new Empresa(in);
        }

        @Override
        public Empresa[] newArray(int size) {
            return new Empresa[size];
        }
    };

    public static Empresa cargarDatosDesdeJson(JSONObject data) {

        Empresa empresa = new Empresa();
        empresa.setId(data.optInt("id"));
        empresa.setRazonSocial(data.optString("razon_social"));
        empresa.setNombreComercial(data.optString("nombre_comercial"));
        empresa.setRuc(data.optString("ruc"));
        empresa.setTelefono(data.optString("telefono"));
        empresa.setCorreo(data.optString("correo"));
        empresa.setDireccion(data.optString("direccion"));
        empresa.setFechaRegistro(data.optString("fecha_registro"));
        empresa.setCodigoPostal(data.optString("codigo_postal"));
        empresa.setDistrito(data.optString("distrito"));
        empresa.setNumeroActividades(data.optInt("numero_actividades"));
        empresa.setEstado(data.optInt("estado"));
        return empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getNumeroActividades() {
        return numeroActividades;
    }

    public void setNumeroActividades(Integer numeroActividades) {
        this.numeroActividades = numeroActividades;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(razonSocial);
        parcel.writeString(nombreComercial);
        parcel.writeString(ruc);
        parcel.writeString(telefono);
        parcel.writeString(correo);
        parcel.writeString(direccion);
        parcel.writeString(fechaRegistro);
        parcel.writeString(codigoPostal);
        parcel.writeString(password);
        parcel.writeString(distrito);
        if (numeroActividades == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(numeroActividades);
        }
        if (estado == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(estado);
        }
    }
}