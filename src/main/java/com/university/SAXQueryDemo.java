package com.university;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class SAXQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("developer.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandlerQuery userhandlerquery = new UserHandlerQuery();
            saxParser.parse(inputFile, userhandlerquery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

