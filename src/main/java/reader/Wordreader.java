package reader;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class element{
    String style;
    String value;
    public element(String style, String value) {
        this.style = style;
        this.value = value;
    }
}

public class Wordreader {
    public static  ArrayList<element> processFile(String path) throws IOException {
        String pfad = path;
        System.out.println("Starte mit Import der Datei Datei " + pfad);
        System.out.println("********************************************************************");
        ArrayList<element> Elements = new ArrayList<element>();
        FileInputStream fis = new FileInputStream(pfad);
        XWPFDocument doc = new XWPFDocument(fis);
        Iterator<IBodyElement> iter = doc.getBodyElementsIterator();
        while (iter.hasNext()) {
            IBodyElement elem = iter.next();
            if (elem instanceof XWPFParagraph){
                if(!(((XWPFParagraph) elem).getText()).equals("")) {
                    System.out.println(((XWPFParagraph) elem).getStyle() + " " + ((XWPFParagraph) elem).getText());
                }
            }
        }
        return Elements;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<element> Elements = processFile(args[0]);
    }
}
