/*
Problem: https://open.kattis.com/problems/opensource
Author: Adrian Reithaug
Submitted: June 3rd, 2017
Time: 0.24s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class OpenSource {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> projects = new HashMap<>();
        Map<String, String> students = new HashMap<>();

        String currentProject = "";
        while (true) {
            String data = reader.readLine();
            if ('0' == data.charAt(0)) {
                break;
            }

            if ('1' == data.charAt(0)) {
                Map<String, Integer> sortedMap = new TreeMap<>(new CompareValueKey(projects));
                sortedMap.putAll(projects);

                sortedMap.entrySet().forEach((entry) -> {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                });

                projects = new HashMap<>();
                students = new HashMap<>();
                continue;
            }

            if (data.charAt(0) >= 'A' && data.charAt(0) <= 'Z') {
                currentProject = data;
                projects.put(data, 0);
                continue;
            }

            if (students.containsKey(data)) {
                String studentProject = students.get(data);
                if (!studentProject.equals("0") && !studentProject.equals(currentProject)) {
                    projects.put(studentProject, projects.get(studentProject) - 1);
                    students.put(data, "0");
                }
            } else {
                students.put(data, currentProject);
                projects.put(currentProject, projects.get(currentProject) + 1);
            }

        }
    }

    static class CompareValueKey implements Comparator<String> {

        Map<String, Integer> map;

        public CompareValueKey(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            if (Objects.equals(map.get(o2), map.get(o1))) {
                return o1.compareTo(o2);
            } else {
                return (map.get(o2)).compareTo(map.get(o1));
            }
        }

    }

}
