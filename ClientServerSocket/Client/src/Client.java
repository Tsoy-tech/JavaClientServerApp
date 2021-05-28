import com.weather.tsoy.Example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Example example = new Example("127.0.0.1", 8000))
        {
            System.out.println("Connected to server");
            String request = "Visaginas";
            example.writeLine(request);

            String response = example.readLine();
            System.out.println("Response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try (
                Socket socket = new Socket("127.0.0.1", 8000);
                //OutputStream outputStream = socket.getOutputStream();
                BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                //InputStream inputStream = socket.getInputStream();
                BufferedReader reader =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
                System.out.println("Connected to server");
                String request = "Visaginas";

                writer.write(request);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                System.out.println("Response: " + response);

        } catch(IOException e) {
            e.printStackTrace();
        }*/
    }
}
