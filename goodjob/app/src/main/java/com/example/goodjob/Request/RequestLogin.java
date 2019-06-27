package com.example.goodjob.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RequestLogin extends StringRequest {

    private static final String ruta="https://192.168.1.108/login/conexion.php";
    private Map<String, String> parametros;


    public RequestLogin(String Ucorreo, String Upass, Response.Listener<String> listener){
        super(Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("Ucorreo", Ucorreo);
        parametros.put("Upass", Upass);
    }

    @Override
    protected Map<String, String> getParams(){
        return parametros;
    }
}
