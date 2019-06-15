package ru.parhomych;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/add/{a}/{b}")
    public String doAdd(@Context HttpHeaders httpHeaders, @PathParam("a") String a, @PathParam("b") String b){
        if (StringUtils.isNumeric(a) && StringUtils.isNumeric(b)){
            double aDouble = Double.valueOf(a);
            double bDouble = Double.valueOf(b);
            Double result = aDouble + bDouble;
            return "<h1>Result of " + aDouble + " + " + bDouble + " is " + result + "</h1>";
        }else {
            return "Bad format";
        }

    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/mult/{a}/{b}")
    public String doMult(@Context HttpHeaders httpHeaders, @PathParam("a") String a, @PathParam("b") String b){
        if (StringUtils.isNumeric(a) && StringUtils.isNumeric(b)){
            double aDouble = Double.valueOf(a);
            double bDouble = Double.valueOf(b);
            Double result = aDouble * bDouble;
            return "<h1>Result of " + aDouble + " * " + bDouble + " is " + result + "</h1>";
        }else {
            return "Bad format";
        }
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/sub/{a}/{b}")
    public String doSub(@Context HttpHeaders httpHeaders, @PathParam("a") String a, @PathParam("b") String b){
        if (StringUtils.isNumeric(a) && StringUtils.isNumeric(b)){
            double aDouble = Double.valueOf(a);
            double bDouble = Double.valueOf(b);
            Double result = aDouble - bDouble;
            return "<h1>Result of " + aDouble + " - " + bDouble + " is " + result + "</h1>";
        }else {
            return "Bad format";
        }
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/div/{a}/{b}")
    public String doDiv(@Context HttpHeaders httpHeaders, @PathParam("a") String a, @PathParam("b") String b){
        if(Double.valueOf(a).equals(0.0)){
            return "You can't divide a zero, you bastard";
        } else if (StringUtils.isNumeric(a) && StringUtils.isNumeric(b)){
            double aDouble = Double.valueOf(a);
            double bDouble = Double.valueOf(b);
            Double result = aDouble / bDouble;
            return "<h1>Result of " + aDouble + " / " + bDouble + " is " + result + "</h1>";
        } else {
            return "Bad format";
        }
    }

}
