import static org.junit.Assert.assertEquals;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ActiveCookieTest {
    private PrintStream console;
    private ByteArrayOutputStream bytes;

    @Before
    public void setUp() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() {
        System.setOut(console);
    }

    @Test
   public void oneCookieOutputed() throws Exception {
       String[] args = new String[] {
            System.getenv().get("COOKIE_DATA_ABSOLUTE_PATH"),  
            "-d",
            "2018-12-09"
        };
        App.main(args);
        assertEquals(String.format("AtY0laUfhglK3lC7%n"), bytes.toString());
   }

   @Test
   public void multipleCookiesOutputed() throws Exception {
       String[] args = new String[] {
           System.getenv().get("COOKIE_DATA_ABSOLUTE_PATH"),
           "-d",
           "2018-12-08"
        };
        App.main(args);
        assertEquals(String.format(
          "fbcn5UAVanZf6UtG%n" + 
          "SAZuXPGUrfbcn5UA%n" + 
          "4sMM2LxV07bPJzwf%n"), bytes.toString());
   }
}
