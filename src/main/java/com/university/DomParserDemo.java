package com.university;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class DomParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("developer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element:");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("employee empId: "
                            + eElement.getAttribute("empId"));
                    System.out.println("Last Name : "
                            + eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    System.out.println("birthDate : "
                            + eElement
                            .getElementsByTagName("birthDate")
                            .item(0)
                            .getTextContent());
                    System.out.println("position : "
                            + eElement
                            .getElementsByTagName("position")
                            .item(0)
                            .getTextContent());
                    System.out.println("skills : "
                            + eElement
                            .getElementsByTagName("skills")
                            .item(0)
                            .getTextContent());
                    System.out.println("managerId : "
                            + eElement
                            .getElementsByTagName("managerId")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
