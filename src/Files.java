import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;


public class Files {
    // Java Program to Write XML Using DOM Parser
        public void write() throws Exception {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document
            Document document = builder.newDocument();

            // Create root element
            Element root = document.createElement("library");
            document.appendChild(root);

            // Create book elements and add text content
            Element book1 = document.createElement("Nombre");
            book1.appendChild(document.createTextNode("JOSE CIRILO"));
            Element book2 = document.createElement("FECHA");
            book2.appendChild(document.createTextNode("2024-05-27"));
            Element book3 = document.createElement("TOTAL");
            book3.appendChild(document.createTextNode("$55"));
            root.appendChild(book1);
            root.appendChild(book2);
            root.appendChild(book3);

            // Write to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            // Specify your local file path
            StreamResult result = new StreamResult("output.xml");
            transformer.transform(source, result);

            System.out.println("XML file created successfully!");
        }
// Java Program to Read XML Using DOM Parser

        public void read() throws Exception {
            // Specify the file path as a File object
            File xmlFile = new File("output.xml");

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(xmlFile);

            // Access elements by tag name
            NodeList nodeList = document.getElementsByTagName("library");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Element Content: " + node.getTextContent());
        }
    }
}
