package com.university;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonEncodeDemo {
    public static void main(String[] args) {
        Map<Object,Object> map = new LinkedHashMap<>();
        map.put("Employee empId", "001");
        map.put("Last Name", "LastName1");
        map.put("First Name","FirstName1");
        map.put("Birth Date", "01.01.00");
        map.put("Position", "Department Manager");
        map.put("Skill3", "Communication");
        map.put("Skill0","Java");
        map.put("ManagerId","0");

        JSONObject obj = new JSONObject();
        System.out.print(obj.toJSONString(map));

        map.put("Employee empId", "002");
        map.put("Last Name", "LastName2");
        map.put("First Name","FirstName2");
        map.put("Birth Date", "01.01.01");
        map.put("Position", "Developer");
        map.put("Skill", "Sleeps only 2 hours per day");
        map.put("Skill1", "Works for food");
        map.put("Skill2","Overtimes without concerns");
        map.put("ManagerId","001");

        JSONObject obj1 = new JSONObject();
        System.out.print(obj1.toJSONString(map));
    }
}
