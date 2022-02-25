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
    public void testSnippet1() throws IOException{
        String file = Files.readString(Path.of("C:\\Users\\padsp\\Documents\\GitHub\\markdown-parse\\testSnippet1.md"));
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
        MarkdownParse.getLinks(file));
    }

    @Test 
    public void testSnippet2() throws IOException{
        String file = Files.readString(Path.of("C:\\Users\\padsp\\Documents\\GitHub\\markdown-parse\\testSnippet2.md"));
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(file));
    }

}
