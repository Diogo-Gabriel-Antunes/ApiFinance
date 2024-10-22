package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Client.ActiveClient;
import org.example.DTO.Enum.Sector;
import org.example.DTO.Enum.Type;
import org.example.DTO.Enum.TypeInterval;
import org.example.DTO.ResponseQuote;
import org.example.DTO.ResponseQuoteAvailable;
import org.example.DTO.ResponseQuoteList;

import java.util.List;

@ApplicationScoped
public class ActiveService {

    public ResponseQuote getQuote(List<String> stickers,Boolean dividends,Boolean fundamental,List<String> modules,Integer range,Integer interval,TypeInterval typeRange,TypeInterval typeInterval){
        return new ActiveClient().getTicketQuote(stickers,dividends,fundamental,modules,range,interval,typeRange,typeInterval);
    }

    public ResponseQuoteList getQuoteList(String search ,String sortBy ,String sortOrder ,Integer limit ,Integer page ,Type type ,Sector sector) {
        return new ActiveClient().getQuoteList(search,sortBy,sortOrder,limit,page,type,sector);
    }

    public ResponseQuoteAvailable getQuoteAvailable(String search) {
        return new ActiveClient().GetAvaible(search);
    }
}
