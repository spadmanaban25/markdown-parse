
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkdownParse {

    public static Map<String, List<String>> getLinks(File dirOrFile) throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        if(dirOrFile.isDirectory()) {
            for(File f: dirOrFile.listFiles()) {
                result.putAll(getLinks(f));
            }
            return result;
        }
        else {
            Path p = dirOrFile.toPath();
            int lastDot = p.toString().lastIndexOf(".");
            if(lastDot == -1 || !p.toString().substring(lastDot).equals(".md")) {
                return result;
            }
            ArrayList<String> links = getLinks(Files.readString(p));
            result.put(dirOrFile.getPath(), links);
            return result;
        }
    }
    public static ArrayList<String> getLinks(String markdown) {
        /**
         The implementation of stack data structure was considered because of the extra
         parantheses showing in the link when asserted into the arraylist and returned.
         What is advantageous of the stack is that after it receives the link extracted
         from the markdown substring after indexOf operations applied, it can remove or 
         pop out any extraneous parantheses that might prompt in the beginning or end of 
         the link. Due to time, my lab group wasn't able to fully implement the stack,
         and so this implementation was done by memory models to get a conceptual
         understanding.
         */
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket < 0 || nextCloseBracket < 0 || openParen < 0 || closeParen < 0){
                break;
            } else {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        File file = new File(fileName.toString());
        if(file.isDirectory()){
            Map<String, List<String>> map = getLinks(file);
            System.out.println(map);
        } else {
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
        }
    }
}