package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.acme.Service.TaxFeesService;
import org.example.DTO.PrimeRate;
import org.example.DTO.ResponsePrimeRateAvailable;

import java.util.List;

@Path("taxFees")
public class TaxFeesResource {

    @Inject
    private TaxFeesService taxFeesService;

    @GET
    public Response get(@QueryParam(value = "country")String country,
//                        @QueryParam(value = "historical") Boolean historical,
                        @QueryParam(value = "start") String start,
                        @QueryParam(value = "end")String end,
                        @QueryParam(value = "sortBy")String sortBy,
                        @QueryParam(value = "sortOrder")String sortOrder){
        List<PrimeRate> result = taxFeesService.getTaxFees(country,start,end,sortBy,sortOrder);
        return Response.ok(result).build();
    }

    @GET
    @Path("available")
    public Response get(@QueryParam(value = "search")String search){
        ResponsePrimeRateAvailable result = taxFeesService.getTaxFeesAvailable(search);
        return Response.ok(result).build();
    }
}
