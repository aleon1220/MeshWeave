package serviceClients.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientPostUserLogin {

    // http://localhost:8080/RESTfulExample/json/product/post
    public static void main(String[] args) {

        try {
            URL url = new URL("https://fahze41owc.execute-api.us-east-1.amazonaws.com/dev/user");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\r\n" +
                    "      \"id\": \"102030\",\r\n" +
                    "      \"firstName\": \"Julito\",\r\n" +
                    "      \"lastName\": \"Schwartzenegger\",\r\n" +
                    "      \"type\": \"administrator\"\r\n" +
                    "}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}