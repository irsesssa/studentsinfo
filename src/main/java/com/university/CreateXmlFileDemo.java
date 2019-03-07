package com.university;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class CreateXmlFileDemo {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            // создаем корневой элемент
         Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);
            Element department = doc.createElement("department");
            rootElement.appendChild(department);
            Attr attr1 = doc.createAttribute("depId");
            attr1.setValue("1");
            Attr attr = doc.createAttribute("name");
            attr.setValue("Development");
            department.setAttributeNode(attr1);
            department.setAttributeNode(attr);

            Element employee = doc.createElement("employee");
            department.appendChild(employee);
            Attr attrType = doc.createAttribute("empId");
            attrType.setValue("001");
            employee.setAttributeNode(attrType);
            employee.appendChild(getCompanyElements(doc, "lastName", "LastName"));
            employee.appendChild(getCompanyElements(doc, "firstName", "FirstName"));
            employee.appendChild(getCompanyElements(doc, "birthDate", "01.01.2000"));
            employee.appendChild(getCompanyElements(doc, "position", "Department Manager"));
            Element skills = doc.createElement("skills");
            employee.appendChild(skills);
            skills.appendChild(getCompanyElements(doc, "skill", "Communication"));
            skills.appendChild(getCompanyElements(doc, "skill", "Java"));
            employee.appendChild(getCompanyElements(doc, "managerId", "0"));

            Element employee1 = doc.createElement("employee");
            department.appendChild(employee1);
            Attr attr5 = doc.createAttribute("empId");
            attr5.setValue("002");
            employee1.setAttributeNode(attr5);
            employee1.appendChild(getCompanyElements(doc, "lastName", "LastName2"));
            employee1.appendChild(getCompanyElements(doc, "firstName", "FirstName2"));
            employee1.appendChild(getCompanyElements(doc, "birthDate", "01.01.2001"));
            employee1.appendChild(getCompanyElements(doc, "position", "Developer"));
            Element skills1 = doc.createElement("skills");
            employee1.appendChild(skills1);
            skills1.appendChild(getCompanyElements(doc, "skill", "Sleeps only 2 hours per day"));
            skills1.appendChild(getCompanyElements(doc, "skill", "Overtimes without concerns"));
            skills1.appendChild(getCompanyElements(doc, "skill", "Works for food"));
            employee1.appendChild(getCompanyElements(doc, "managerId", "001"));

           Element employee2 = doc.createElement("employee");
            department.appendChild(employee2);
            Attr attr6 = doc.createAttribute("empId");
            attr6.setValue("003");
            employee2.setAttributeNode(attr6);
            employee2.appendChild(getCompanyElements(doc, "lastName", "LastName3"));
            employee2.appendChild(getCompanyElements(doc, "firstName", "FirstName3"));
            employee2.appendChild(getCompanyElements(doc, "birthDate", "01.01.2002"));
            employee2.appendChild(getCompanyElements(doc, "position", "Tester"));
            Element skills2 = doc.createElement("skills");
            employee2.appendChild(skills2);
            skills2.appendChild(getCompanyElements(doc, "skill", "Self-motivation"));
            skills2.appendChild(getCompanyElements(doc, "skill", "Creativity"));
            skills2.appendChild(getCompanyElements(doc, "skill", "Sherlock Holmes"));
            skills2.appendChild(getCompanyElements(doc, "managerId", "002"));


            Element department1 = doc.createElement("department");
            rootElement.appendChild(department1);
            Attr attr11 = doc.createAttribute("depId");
            attr11.setValue("2");
            Attr attr10 = doc.createAttribute("name");
            attr10.setValue("Accounting");
            department1.setAttributeNode(attr11);
            department1.setAttributeNode(attr10);

            Element employee11 = doc.createElement("employee");
            department1.appendChild(employee11);
            Attr attr12 = doc.createAttribute("empId");
            attr12.setValue("04");
            employee11.setAttributeNode(attr12);
            employee11.appendChild(getCompanyElements(doc, "lastName", "LastName4"));
            employee11.appendChild(getCompanyElements(doc, "firstName", "FirstName4"));
            employee11.appendChild(getCompanyElements(doc, "birthDate", "01.01.2004"));
            employee11.appendChild(getCompanyElements(doc, "position", "Department Manager"));
            Element skills12 = doc.createElement("skills");
            employee11.appendChild(skills12);
            skills12.appendChild(getCompanyElements(doc, "skill", "Leadership"));
            skills12.appendChild(getCompanyElements(doc, "skill", "Decision Making"));
            employee11.appendChild(getCompanyElements(doc, "managerId", "0"));

            Element employee12 = doc.createElement("employee");
            department1.appendChild(employee12);
            Attr attr13 = doc.createAttribute("empId");
            attr13.setValue("05");
            employee12.setAttributeNode(attr13);
            employee12.appendChild(getCompanyElements(doc, "lastName", "LastName4"));
            employee12.appendChild(getCompanyElements(doc, "firstName", "FirstName4"));
            employee12.appendChild(getCompanyElements(doc, "birthDate", "01.01.2005"));
            employee12.appendChild(getCompanyElements(doc, "position", "Test Automator"));
            Element skills13 = doc.createElement("skills");
            employee12.appendChild(skills13);
            skills13.appendChild(getCompanyElements(doc, "skill", "Adaptability"));
            skills13.appendChild(getCompanyElements(doc, "skill", "Java"));
            employee12.appendChild(getCompanyElements(doc, "managerId", "04"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("developer.xml"));
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // утилитный метод для создание нового узла XML-файла
    private static Node getCompanyElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}

