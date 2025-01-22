package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        Set<Employee> seen = new HashSet<>();

        for (Employee employee : employees) {
            if (employee != null && !seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();
        Set<Employee> duplicates = new HashSet<>();

        for (Employee employee : employees) {
            if (employee != null) {
                if (uniques.containsKey(employee.getId())) {
                    duplicates.add(employee);
                    uniques.remove(employee.getId());
                } else if (!duplicates.contains(employee)) {
                    uniques.put(employee.getId(), employee);
                }
            }
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> uniqueList = new LinkedList<>();
        Map<Integer, Integer> idCountMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                idCountMap.put(employee.getId(), idCountMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        for (Employee employee : employees) {
            if (employee != null && idCountMap.get(employee.getId()) == 1) {
                uniqueList.add(employee);
            }
        }

        return uniqueList;
    }
}
