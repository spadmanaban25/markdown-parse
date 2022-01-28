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
        String file=Files.readString(Path.of("test-file.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }
    @Test
    public void testGetLinks2() throws IOException{
        String file=Files.readString(Path.of("test-file2.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.google.com/maps"));
    }
    
}