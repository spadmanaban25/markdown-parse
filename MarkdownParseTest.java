import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest {
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();
    ArrayList<String> list4 = new ArrayList<String>();

    public void setUp(){
        list1.add("https://something.com");
        list1.add("some-page.html");
        list2.add("https://something.com");
        list2.add("some-page.html");
        list2.add("");
        list2.add("www.google.com/(test)");
        list3.add("https://something.com");
        list3.add("some-page.html");
        list4.add("www.ucsd.edu");
        list4.add("www.gmail.com");
    }
    
    @Test
    public void addition() {
        assertEquals(1000000, 1 + 1);
    }
    /*
    @Test
    public void testGetLink() throws IOException{
        setUp();
        Path fileName = Path.of("C:\\Users\\padsp\\Documents\\GitHub\\markdown-parse\\test-file1.md");
        String contents = Files.readString(fileName);
        assertEquals(list1, MarkdownParse.getLinks(contents));
    }
    */
}
