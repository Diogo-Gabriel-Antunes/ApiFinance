package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Client.CoinClient;
import org.example.DTO.ResponseCoin;
import org.example.DTO.ResponseCoinAvailable;

import java.util.List;

@ApplicationScoped
public class CoinService {


    public ResponseCoin getCoin(List<String> currency) {
        return new CoinClient().getCoin(currency);
    }

    public ResponseCoinAvailable getCoinAvailable(String search) {
        return new CoinClient().getCoinAvailable(search);
    }
}
