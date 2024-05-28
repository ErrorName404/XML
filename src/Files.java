import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;


public class Files {
    public void write() throws Exception {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element root = document.createElement("library");
            document.appendChild(root);

            Element book1 = document.createElement("Nombre");
            book1.appendChild(document.createTextNode("JOSE CIRILO\n"));
            Element book2 = document.createElement("FECHA");
            book2.appendChild(document.createTextNode("2024-05-27\n"));
            Element book3 = document.createElement("TOTAL");
            book3.appendChild(document.createTextNode("$55\n"));
            root.appendChild(book1);
            root.appendChild(book2);
            root.appendChild(book3);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult("output.xml");
            transformer.transform(source, result);

            System.out.println("XML file created successfully!");
        }


        public void read() throws Exception {
            File xmlFile = new File("output.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("library");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getTextContent());

            }
    }
}
