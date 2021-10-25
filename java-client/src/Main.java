import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String HOST = "http://127.0.0.1";
    private static final int PORT = 3420;
    private static final String ENDPOINT = "RPC2";
    private static final String URL = String.format("%s:%d/%s", HOST, PORT, ENDPOINT);


    public static void main(String[] args) throws Exception {

        // Setting up and running the client
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(URL));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        // Initializing scanner
        Scanner scanner = new Scanner(System.in);

        // Calling the iris authentication on the server
        System.out.print("Path to image to authenticate: ");
        String imagePath = scanner.nextLine();
        Object[] params = new Object[]{imagePath};
        System.out.printf("· Asking the server to authenticate the image [%s]...\n", imagePath);
        String result = (String) client.execute("iris", params);
        System.out.printf("*** The server has returned: \"%s\" ***\n", result);

    }

}
