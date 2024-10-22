package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.acme.Service.InflationService;
import org.example.DTO.ResponseInflation;
import org.example.DTO.ResponseInflationAvaible;

@Path("inflation")
public class InflationResource {

    @Inject
    private InflationService inflationService;

    @GET
    public Response get(@QueryParam(value = "country") String country,
                        @QueryParam(value = "start") String start,
                        @QueryParam(value = "end") String end,
                        @QueryParam(value = "sortBy")String date,
                        @QueryParam(value = "sortOrder")String sortOrder){
        ResponseInflation result = inflationService.getInflation(country,start,end,date,sortOrder);
        return Response.ok(result).build();
    }

    @GET
    @Path("available")
    public Response getAvailable(@QueryParam(value = "search") String search){
        ResponseInflationAvaible result = inflationService.getInflationAvailable(search);
        return Response.ok(result).build();
    }
}
