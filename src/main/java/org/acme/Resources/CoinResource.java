package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.acme.Service.CoinService;
import org.example.DTO.ResponseCoin;
import org.example.DTO.ResponseCoinAvailable;

import java.util.List;

@Path("coin")
public class CoinResource {

    @Inject
    private CoinService coinService;

    @GET
    public Response get(@QueryParam(value = "currency") List<String> currency){
        ResponseCoin result = coinService.getCoin(currency);
        return Response.ok(result).build();
    }

    @GET
    @Path("available")
    public Response get(@QueryParam(value = "search") String search){
        ResponseCoinAvailable result = coinService.getCoinAvailable(search);
        return Response.ok(result).build();
    }
}
