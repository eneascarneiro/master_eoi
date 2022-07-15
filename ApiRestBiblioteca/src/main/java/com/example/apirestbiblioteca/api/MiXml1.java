package com.example.apirestbiblioteca.api;

import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


@Path("/xml1")
public class MiXml1 {
    @GET
    @Produces("text/xml")
    public String miXML() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Elemento raíz
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("root");
        doc.appendChild(rootElement);
        //Primer elemento
        Element elemento1 = doc.createElement("elemento1");
        rootElement.appendChild(elemento1);
        //Se agrega un atributo al nodo elemento y su valor
        Attr attr = doc.createAttribute("id");
        attr.setValue("valor del atributo");
        elemento1.setAttributeNode(attr);
        Element elemento2 = doc.createElement("elemento2");
        elemento2.setTextContent("Contenido del elemento 2");
        rootElement.appendChild(elemento2);


        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();

            // Uncomment if you do not require XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            //A character stream that collects its output in a string buffer,
            //which can then be used to construct a string.
            StringWriter writer = new StringWriter();

            //transform document to string
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            String xmlString = writer.getBuffer().toString();
            return (xmlString);            //Print to console or logs
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
