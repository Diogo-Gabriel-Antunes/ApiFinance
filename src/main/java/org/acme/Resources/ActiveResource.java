package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jdk.jfr.ContentType;
import org.acme.Service.ActiveService;
import org.example.DTO.Enum.Sector;
import org.example.DTO.Enum.Type;
import org.example.DTO.Enum.TypeInterval;
import org.example.DTO.ResponseQuote;
import org.example.DTO.ResponseQuoteAvailable;
import org.example.DTO.ResponseQuoteList;
import org.wildfly.common.annotation.NotNull;

import java.util.List;

@Path("active")
public class ActiveResource {

    @Inject
    private ActiveService activeService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response get(@NotNull @QueryParam(value = "stickers")List<String> stickers,
                                       @QueryParam(value = "dividends")Boolean dividends,
                                       @QueryParam(value = "fundamental")Boolean fundamental,
                                       @QueryParam(value = "modules") List<String> modules,
                                       @QueryParam(value = "range")Integer range,
                                       @QueryParam(value = "interval")Integer interval,
                                       @QueryParam(value = "typeRange")TypeInterval typeRange,
                                       @QueryParam(value = "typeInterval")TypeInterval typeInterval){
        ResponseQuote result = activeService.getQuote(stickers ,dividends ,fundamental ,modules ,range ,interval ,typeRange ,typeInterval);
        return Response.ok(result).build();
    }

    @GET
    @Path("list")
    public Response getQuoteList(@QueryParam(value = "search")String search,
                                 @QueryParam(value = "sortBy")String sortBy,
                                 @QueryParam(value = "sortOrder") String sortOrder,
                                 @QueryParam(value = "limit") Integer limit,
                                 @QueryParam(value = "page")Integer page,
                                 @QueryParam(value = "type")Type type,
                                 @QueryParam(value = "sector")Sector sector){
       ResponseQuoteList result =  activeService.getQuoteList(search,sortBy,sortOrder,limit,page,type,sector);
       return Response.ok(result).build();
    }


    @GET
    @Path("available")
    public Response getQuoteAvailable(@QueryParam(value = "search")String search){
        ResponseQuoteAvailable result =  activeService.getQuoteAvailable(search);
        return Response.ok(result).build();
    }

}
