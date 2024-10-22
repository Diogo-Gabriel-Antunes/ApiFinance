package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Client.InflationClient;
import org.example.Client.TaxFeesClient;
import org.example.DTO.PrimeRate;
import org.example.DTO.ResponseInflation;
import org.example.DTO.ResponseInflationAvaible;
import org.example.DTO.ResponsePrimeRateAvailable;

import java.util.List;

@ApplicationScoped
public class TaxFeesService {


    public List<PrimeRate> getTaxFees(String country ,String start ,String end ,String sortBy ,String sortOrder) {
        return new TaxFeesClient().getPrimeRate(country,start,end,sortBy,sortOrder);
    }

    public ResponsePrimeRateAvailable getTaxFeesAvailable(String search) {
        return new TaxFeesClient().getPrimeRateAvailable(search);
    }
}
