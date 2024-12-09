import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SongClient {
    public static void main(String[] args) {

        ArrayList<SongModel> songList = new ArrayList<>();
        String reqUrl = "https://itunes.apple.com/search?term=arijit+singh&limit=25";

        HttpClient songClient = HttpClient.newHttpClient();

        HttpRequest songRequest = HttpRequest.newBuilder().GET().uri(URI.create(reqUrl)).build();

        try {
            HttpResponse<String> response = songClient.send(songRequest, HttpResponse.BodyHandlers.ofString());

            // System.out.println(response.body());

            JSONObject object = new JSONObject(response.body());

            JSONArray jsonArray = object.getJSONArray("results");

            System.out.println(jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                SongModel song = new SongModel();
                JSONObject singleSong = jsonArray.getJSONObject(i);
                // System.out.println(singleSong.getString("artistName"));
                song.singerName = singleSong.getString("artistName");
                // System.out.println(singleSong.getString("trackName"));
                song.trackName = singleSong.getString("trackName");
                // System.out.println(singleSong.getString("previewUrl"));
                if (singleSong.has("previewUrl")) {
                    song.songUrl = singleSong.getString("previewUrl");
                } else {
                    song.songUrl = "No Url Found";
                }

                song.trackCover = singleSong.getString("artworkUrl100");
                songList.add(song);
            }

            System.out.println(songList.get(0).songUrl);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}