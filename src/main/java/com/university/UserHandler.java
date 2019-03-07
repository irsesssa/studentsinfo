package com.university;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
    boolean bLastName = false;
    boolean bFirstName = false;
    boolean bBirthDate = false;
    boolean bPosition = false;
    boolean bSkill = false;
    boolean bManager = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            String empId = attributes.getValue("empId");
            System.out.println("empId : " + empId);
        } else if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("firstName")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("birthDate")) {
            bBirthDate= true;
        }
        else if (qName.equalsIgnoreCase("position")) {
            bPosition = true;
        }
        else if (qName.equalsIgnoreCase("skill")) {
            bSkill = true;
        }
        else if (qName.equalsIgnoreCase("managerId")) {
            bManager = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if ( bBirthDate) {
            System.out.println(" Birth Date: " + new String(ch, start, length));
            bBirthDate = false;
        } else if ( bPosition) {
            System.out.println(" Position: " + new String(ch, start, length));
            bPosition = false;
        }
        else if ( bSkill) {
            System.out.println(" Skill: " + new String(ch, start, length));
            bSkill = false;
        }
        else if ( bManager) {
            System.out.println(" ManagerId: " + new String(ch, start, length));
            bManager = false;
        }
    }
}
