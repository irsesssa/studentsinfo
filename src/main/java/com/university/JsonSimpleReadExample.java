package com.university;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonSimpleReadExample {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object map = parser.parse(new FileReader("developer.json"));

            JSONObject jsonObject = (JSONObject) map;
            System.out.println(jsonObject);

            String employee= (String) jsonObject.get("Employee empId");
            System.out.println(employee);
            String lastName= (String) jsonObject.get("Last Name");
            System.out.println(lastName);
            String firstName= (String) jsonObject.get("First Name");
            System.out.println(firstName);
            String birthDate = (String) jsonObject.get("01.01.00"); //не понимаю,почему не считывает birthDate,position
            System.out.println( birthDate);
            String position= (String) jsonObject.get("Department Manager");
            System.out.println(position);
            // loop array
          /* JSONArray skill3 = (JSONArray) jsonObject.get("skills");
            Iterator<String> iterator = skill3.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());

           }
*/
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
