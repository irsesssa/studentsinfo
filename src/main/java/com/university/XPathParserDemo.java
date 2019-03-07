package com.university;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
public class XPathParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("developer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

           String expression = "//employee";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee empId :" + eElement.getAttribute("empId"));
                    System.out.println("LastName : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("BirthDate : " + eElement.getElementsByTagName("birthDate").item(0).getTextContent());
                    System.out.println("Position : " + eElement.getElementsByTagName("position").item(0).getTextContent());
                    System.out.println("Skill : " + eElement.getElementsByTagName("skill").item(0).getTextContent());
                    System.out.println("Manager : " + eElement.getElementsByTagName("managerId").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
