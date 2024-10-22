package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Client.ActiveClient;
import org.example.Client.InflationClient;
import org.example.DTO.*;
import org.example.DTO.Enum.Sector;
import org.example.DTO.Enum.Type;
import org.example.DTO.Enum.TypeInterval;

import java.util.List;

@ApplicationScoped
public class InflationService {

    public ResponseInflation getInflation(String country ,String start ,String end ,String date ,String sortOrder) {
        return new InflationClient().getInflation(country ,start ,end ,date ,sortOrder);
    }

    public ResponseInflationAvaible getInflationAvailable(String search) {
        return new InflationClient().getInflation(search);
    }
}
