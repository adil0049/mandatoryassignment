import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

    public static void main(String args[]){
        try {

            String ip = InetAddress.getLocalHost().getHostAddress();
            Socket socket = new Socket(ip, 5535);

            BufferedReader typer = new BufferedReader(new InputStreamReader(System.in));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printwriter = new PrintWriter(outputStream, true);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Chat online");

            String message;
            while(true){
                if(bufferedReader.ready()){ System.out.println(bufferedReader.readLine());
                }
                if(typer.ready()){ message = typer.readLine();
                printwriter.println(message);
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}
