import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testGetLinks1() throws IOException{
        String file = Files.readString(Path.of("test-file.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }

    @Test 
    public void testSnippet2() throws IOException{
        String file = Files.readString(Path.of("C:\\Users\\padsp\\Documents\\GitHub\\markdown-parse\\testSnippet2.md"));
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(file));
    }

    @Test
    public void testSnippet3() throws IOException{
        String file = Files.readString(Path.of("C:\\Users\\padsp\\Documents\\GitHub\\markdown-parse\\testSnippet3.md"));
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"), MarkdownParse.getLinks(file));
    }

}
