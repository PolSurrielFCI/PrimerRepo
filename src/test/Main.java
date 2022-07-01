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


    public static void main(String [] args) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, TransformerException {


        ArrayList<Peli> pelis = new ArrayList<>();
        pelis.add(new Peli("toy story",200, "dsdsdd", 5.0));
        pelis.add(new Peli("el pieanista",50, "dsdsdd", 5.6));
        pelis.add(new Peli("aventuras en el espacio",10, "dsdsdd", 5.0));
        pelis.add(new Peli("espacio en las aventuras",200, "dsdsdd", 5.0));


        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src/test/pelidata.bin"));
        writer.writeObject(pelis);
        writer.close();

        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("src/test/pelidata.bin"));

        ArrayList<Peli> readedpelis = new ArrayList<>();
        readedpelis = (ArrayList<Peli>) reader.readObject();

        for (var peli : readedpelis) {
            System.out.println(peli.name);
        }



    }




}