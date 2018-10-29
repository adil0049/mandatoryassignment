import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main (String args[]){

        try{
            System.out.println("Online");
            ServerSocket serverSocket = new ServerSocket(5535);
            Socket socket = serverSocket.accept();

            BufferedReader typer = new BufferedReader(new InputStreamReader(System.in));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String message;
            while(true){
                if(bufferedReader.ready()){
                    System.out.println(bufferedReader.readLine());
                }
                if(typer.ready()){
                    message = typer.readLine();
                    printWriter.println(message);
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }

    }
}
