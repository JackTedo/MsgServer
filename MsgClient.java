
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MsgClient {

    private static Socket socket;

    public static void main(String[] args) throws Exception {

	socket = new Socket(InetAddress.getByName(args[0]), Integer.parseInt(args[1]));

	System.out.println("\r\nConnected.");

	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	out.println(args[2]);

    }

}
