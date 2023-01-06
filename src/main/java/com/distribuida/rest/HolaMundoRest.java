package com.distribuida.rest;

import com.distribuida.servicios.ServicioHolaMundo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
import java.time.LocalTime;
@ApplicationScoped
@Path(value = "/")
public class HolaMundoRest {

   @Inject
    private ServicioHolaMundo servicio;
    @GET
    @Path("/Hola")
    public String hola(){
        return servicio.hola();

    }
}
