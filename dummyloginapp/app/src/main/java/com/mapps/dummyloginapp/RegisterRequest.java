package com.mapps.dummyloginapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by melvin on 18/2/17.
 */

public class RegisterRequest extends StringRequest {


    private static final String REGISTER_REQUEST_URL = "https://terbic-cliff.000webhostapp.com/";

    private Map<String , String> params;

    public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener)
    {

    super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("age",age+"");

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return params;

    }
}
