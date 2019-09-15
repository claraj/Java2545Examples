package week2_loops_arrays;

import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Created by clara on 2019-09-10.
 */
public class AreYouOnline {
    
    public static void main(String[] args) throws Exception {
        
        String url = "https://google.com";  // if Google is down, the internet is probably down too
        
        while (true) {
    
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("You seem to be online");
            } catch (ConnectException e) {
                System.out.println("You are not online");
            }
    
            Thread.sleep(1000);   // sleep for 1 second
        }
        
    }
}
