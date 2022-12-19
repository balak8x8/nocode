package com.nocode.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.nocode.util.pojo.Address;
import com.nocode.util.pojo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeUtilTest {

    private MergeUtilImpl mergeUtil;
    private JsonUtil jsonUtil;

    @BeforeEach
    public void setup() {
        jsonUtil = new JsonUtil();
        mergeUtil = new MergeUtilImpl(jsonUtil);

    }

    @Test
    void testDeepMerge() throws Exception {
        Employee tobeUpdatedEmployee = new Employee();
        tobeUpdatedEmployee.setAddress(new Address("1718 fairhill drive", "milpitas", "95035"));
        tobeUpdatedEmployee.setSalary(3000);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("first", "first");
        map.put("second", "second");
        tobeUpdatedEmployee.setHobbies(map);

        System.out.println("input json: " + tobeUpdatedEmployee);
        Map<String, String> existingMap = new LinkedHashMap<>();
        existingMap.put("second", "2");
        existingMap.put("third", "third");

        Employee existingEmployee = new Employee("John", "Dev", 1000, "222-222-222",
                new Address("101 Blue Dr", "SunBridge", "23456"),
                existingMap);
        System.out.println("existing object: " + existingEmployee);
        System.out.println("existing object hashCode: " + System.identityHashCode(existingEmployee));
        System.out.println("existing nested object 'address' hashCode: " + System
                .identityHashCode(existingEmployee.getAddress()));

        existingEmployee = mergeUtil.mergeObject(existingEmployee, tobeUpdatedEmployee);

        System.out.println("result" + jsonUtil.toJSON(existingEmployee));
    }

    <T> T merge(T existingEmployee, String inputJson) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerForUpdating(existingEmployee);
        T updatedEmployee = objectReader.readValue(inputJson);
        return updatedEmployee;
    }
}
