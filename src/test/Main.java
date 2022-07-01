package test;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void ejercicioXML1() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Peli> pelis = new ArrayList<>();
        pelis.add(new Peli("toy story",200, "dsdsdd", 5.0));
        pelis.add(new Peli("el pieanista",50, "dsdsdd", 5.6));
        pelis.add(new Peli("aventuras en el espacio",10, "dsdsdd", 5.0));
        pelis.add(new Peli("espacio en las aventuras",200, "dsdsdd", 5.0));


        File inputFile = new File("src/test/pelis.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        System.out.println("----------------------");
        NodeList pelisLeidas = doc.getElementsByTagName("peli");

        for (int i = 0; i < pelisLeidas.getLength(); i++) {
            Element currentNode = (Element) pelisLeidas.item(i);
            String name = currentNode.getElementsByTagName("name").item(0).getTextContent();
            int duration = Integer.parseInt(currentNode.getElementsByTagName("duration").item(0).getTextContent());
            String description = currentNode.getElementsByTagName("description").item(0).getTextContent();
            Double rating = Double.parseDouble(currentNode.getElementsByTagName("rating").item(0).getTextContent());
            int year = Integer.parseInt(currentNode.getAttribute("year"));

            System.out.println("name: "+name);
            System.out.println("duration: "+duration);
            System.out.println("description: "+description);
            System.out.println("rating: "+rating);
            System.out.println("year: "+year);

            System.out.println("\n");

        }
    }


    public static void addFilmToRoot(Element root, Document doc, Peli peliData){
        Element peli = doc.createElement("peli");
        root.appendChild(peli);

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(peliData.name));
        peli.appendChild(name);

        Element duration = doc.createElement("duration");
        duration.appendChild(doc.createTextNode(peliData.duration+""));
        peli.appendChild(duration);

        Element description = doc.createElement("description");
        description.appendChild(doc.createTextNode(peliData.description));
        peli.appendChild(description);

        Element rating = doc.createElement("rating");
        rating.appendChild(doc.createTextNode(peliData.valoracion+""));
        peli.appendChild(rating);

        Attr yeatAttr = doc.createAttribute("year");
        yeatAttr.setValue("2020");
        peli.setAttributeNode(yeatAttr);

    }

    public static void main(String [] args) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, TransformerException {


        ArrayList<Peli> pelis = new ArrayList<>();
        pelis.add(new Peli("toy story",200, "dsdsdd", 5.0));
        pelis.add(new Peli("el pieanista",50, "dsdsdd", 5.6));
        pelis.add(new Peli("aventuras en el espacio",10, "dsdsdd", 5.0));
        pelis.add(new Peli("espacio en las aventuras",200, "dsdsdd", 5.0));


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element root = doc.createElement("root");
        doc.appendChild(root);

        for (var peli : pelis) {
            addFilmToRoot(root, doc, peli);
        }




        // GUARDAR EN ARCHIVO
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/test/pelis2.xml"));
        transformer.transform(source, result);

        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);



//        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src/test/pelidata.bin"));
//        writer.writeObject(pelis);
//        writer.close();
//
//        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("src/test/pelidata.bin"));
//
//        ArrayList<Peli> readedpelis = new ArrayList<>();
//        readedpelis = (ArrayList<Peli>) reader.readObject();
//
//        for (var peli : readedpelis) {
//            System.out.println(peli.name);
//        }



    }




}