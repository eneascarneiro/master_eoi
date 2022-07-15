package com.example.apirestbiblioteca.api;

import org.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/json1")
public class Json1 {
    @GET
    @Produces("text/json")
    public String miJson() {
        JSONObject obj=new JSONObject();
        obj.put("name","sonoo");
        obj.put("age",new Integer(27));
        obj.put("salary",new Double(600000));
        return (obj.toString());
    }

}
