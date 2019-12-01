package com.example.goodjob.classes;

public class ValidSession {

    public static User usuarioLogueado = null;
    public static Empresa empresaLogueada = null;
    private static final String LOCAL = "https://192.168.1.5";
    // la línea debajo usa la conexión remota
    // private static final String LOCAL = "https://anthostudio.ga";
    public static final String IP = LOCAL + "/Conexiones";
    public static final String IP_IMAGENES_ACTIVIDADES = LOCAL + "/imagenes-actividades";
    public static final String IMAGENES_ACTIVIDADES_GUARDADAS = IP_IMAGENES_ACTIVIDADES + "/imagenes-subidas/";
}