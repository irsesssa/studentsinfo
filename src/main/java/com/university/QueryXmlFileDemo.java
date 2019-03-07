package com.university;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class QueryXmlFileDemo {
    public static void main(String argv[]) {
        try {
                File inputFile = new File("developer.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();


               //System.out.print("Root element: ");
                //System.out.println(doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("company");
                //System.out.println("Current Element :");
                //System.out.print(doc.getDocumentElement().getNodeName());
                //NodeList nList1 = doc.getElementsByTagName("employee");
                //System.out.println();

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);



                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.print("empId: ");
                        System.out.println(eElement.getAttribute("empId"));
                        System.out.println(eElement.getTextContent());

                       // for (int k = 0; k < nList1.getLength();k++) {
                           // Node nNode1 = nList1.item(k);
                           // System.out.println("\nLastName :" + nNode1.getNodeName());
                            //System.out.print(nNode1.getNodeName());


                        }
                    }
               // }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




