package org.acme.Resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.acme.Service.CryptoService;
import org.example.DTO.ResponseCrypto;
import org.example.DTO.ResponseCryptoAvailable;

import java.util.List;

@Path("crypto")
public class CryptoResource {

    @Inject
    private CryptoService cryptoService;

    @GET
    public Response get(@QueryParam(value = "coin")List<String> coin,
                        @QueryParam(value = "currency")String currency){
        ResponseCrypto result = cryptoService.getCrypto(coin,currency);
        return Response.ok(result).build();
    }

    @GET
    @Path("available")
    public Response get(@QueryParam(value = "search")String search){
        ResponseCryptoAvailable result = cryptoService.getCryptoAvailable(search);
        return Response.ok(result).build();
    }
}
