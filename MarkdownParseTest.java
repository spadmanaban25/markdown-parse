import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks1() throws IOException{
        String file=Files.readString(Path.of("test-file1.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }

    //@Test
    //public void testGetLinksImage2()throws IOException{
        //String file=Files.readString(Path.of("test-file9.md"));
        //assertEquals(MarkdownParse.getLinks(file),List.of("https://something.com",
        //"some-page.html","www.google.com/test"));
    //}
}
