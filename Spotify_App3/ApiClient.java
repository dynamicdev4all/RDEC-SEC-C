import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class ApiClient {
    public static void main(String[] args) {
        String address = "https://itunes.apple.com/search?term=arijit+singh&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();

        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
