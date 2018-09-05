
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MsgServer {
    private ServerSocket server;

    public MsgServer() throws Exception {

	this.server = new ServerSocket(0, 0, InetAddress.getLoopbackAddress());

    }

    private void listen() throws Exception {
	String data = "Start";
	Socket client = this.server.accept();
	String clientAddress = client.getInetAddress().getHostAddress();
	System.out.println("\r\nNew connection from " + clientAddress);

	BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

	data = in.readLine();
	System.out.println("\r\n" + data);

    }

    public InetAddress getSocketAddress() {
	return this.server.getInetAddress();
    }

    public int getPort() {
	return this.server.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
	MsgServer app = new MsgServer();
	System.out.println(
		"\r\nRunning Server: " + "Host=" + app.getSocketAddress().getHostAddress() + " Port=" + app.getPort());

	app.listen();
    }
}