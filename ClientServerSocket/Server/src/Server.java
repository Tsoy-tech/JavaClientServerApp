import java.io.*;
import java.net.ServerSocket;
import com.weather.tsoy.Example;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started!");
            while (true)
                try (Example example = new Example(server))
                {
                    String request = example.readLine();
                    System.out.println("Request: " + request);
                    String response = (int) (Math.random() * 20 - 10) + "";
                    System.out.println("Response: " + response);

                    example.writeLine(response);
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
        }

        /*try (ServerSocket server = new ServerSocket(8000))
        {
            System.out.println("Server started!");

            while (true)
                try (
                    Socket socket = server.accept();
                    //System.out.println("Client connected");
                    OutputStream outputStream = socket.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                ) {
                    String request = reader.readLine();
                    System.out.println("Request: " + request);
                    String response = (int) (Math.random() * 20 - 10) + "";
                    System.out.println("Response: " + response);

                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }*/
    }
}
