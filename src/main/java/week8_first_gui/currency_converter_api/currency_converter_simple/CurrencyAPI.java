package week8_first_gui.currency_converter_api.currency_converter_simple;

import com.google.gson.Gson;
import week8_first_gui.currency_converter_api.currency_converter_simple.model.ExchangeRateResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyAPI {

    public double getDollarsToEuros() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.exchangeratesapi.io/latest?base=USD&symbols=EUR"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseText = response.body();

            Gson gson = new Gson();
            ExchangeRateResponse rates = gson.fromJson(responseText, ExchangeRateResponse.class);
            return rates.getRates().getEUR();

        } catch (IOException | InterruptedException e) {
            return -1;
        }


    }

}
