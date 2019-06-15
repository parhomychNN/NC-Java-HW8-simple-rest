package ru.parhomych;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class CalculationRestClient {

    public static void checkResponse(Response response){
        System.out.println("**************");
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            System.out.println("Success! "  + response.getStatus());
            String s = response.readEntity(String.class);
            System.out.println(s);

        } else {
            System.out.println("Error! "  + response.getStatus());
            System.out.println(response.getEntity());
        }
        System.out.println("**************");
    }


    public static void main(String[] args) {
        String baseUrl = "http://localhost:8081/HW8_simpleRestService_war_exploded/rest/calc/";

        Client client = ClientBuilder.newClient();
        WebTarget targetAdd = client.target(baseUrl + "add/12333/1222");
        WebTarget targetMult = client.target(baseUrl + "mult/43/1222");
        WebTarget targetSub = client.target(baseUrl + "sub/34/4");
        WebTarget targetDiv = client.target(baseUrl + "div/22/12");

        Invocation.Builder requestAdd = targetAdd.request();
        requestAdd.accept(MediaType.TEXT_PLAIN_TYPE);
        Invocation.Builder requestMult = targetMult.request();
        requestAdd.accept(MediaType.TEXT_PLAIN_TYPE);
        Invocation.Builder requestSub = targetSub.request();
        requestAdd.accept(MediaType.TEXT_PLAIN_TYPE);
        Invocation.Builder requestDiv = targetDiv.request();
        requestAdd.accept(MediaType.TEXT_HTML);

        Response responseAdd = requestAdd.get();
        Response responseMult = requestMult.get();
        Response responseSub = requestSub.get();
        Response responseDiv = requestDiv.get();

        checkResponse(responseAdd);
        checkResponse(responseMult);
        checkResponse(responseSub);
        checkResponse(responseDiv);


    }

}
