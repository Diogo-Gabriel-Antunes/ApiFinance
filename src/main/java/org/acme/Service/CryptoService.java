package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.Client.ActiveClient;
import org.example.Client.CryptoClient;
import org.example.DTO.*;
import org.example.DTO.Enum.Sector;
import org.example.DTO.Enum.Type;
import org.example.DTO.Enum.TypeInterval;

import java.util.List;

@ApplicationScoped
public class CryptoService {


    public ResponseCrypto getCrypto(List<String> coin ,String currency) {
        return new CryptoClient().GetCrypto(coin,currency);
    }

    public ResponseCryptoAvailable getCryptoAvailable(String search) {
        return new CryptoClient().GetCryptoAvailable(search);
    }
}
