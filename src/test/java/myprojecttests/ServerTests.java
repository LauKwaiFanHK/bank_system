package myprojecttests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import myproject.EchoClient;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class ServerTests {
	private EchoClient client;

    @Before
    public void setup() throws IOException {
        client = new EchoClient();
        client.startConnection("127.0.0.1", 4444);
    }
    
    @After
    public void tearDown() throws IOException {
        client.stopConnection();
    }
	
	@Test
	public void givenClient_whenServerEchosMessage_thenCorrect() {

		try {
		    String resp1 = client.sendMessage("hello");
		    String resp2 = client.sendMessage("world");
		    String resp3 = client.sendMessage("!");
		    String resp4 = client.sendMessage(".");
		    
		    assertEquals("hello", resp1);
		    assertEquals("world", resp2);
		    assertEquals("!", resp3);
		    assertEquals(".", resp4);
		    
	    } catch (IOException e) {
	    	System.out.println(e);
	    }

	}
	
}
