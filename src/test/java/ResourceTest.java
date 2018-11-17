import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourceTest {
    private Properties properties = new Properties();
    @Test

    public void test() throws IOException {
        final InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        properties.load(fis);
        System.out.println(properties.get("dbUser"));

        URL resource = Thread.currentThread().getContextClassLoader().getResource("test.html");
        File file1 = new File(resource.getFile());
        System.out.println(file1.getName());



    }
}
