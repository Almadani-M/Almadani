import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {

    public static void main(String[] args) {
        List<String> studentNames = readStudentNamesFromFile("D:\\UNI\\206\\lab\\Lab03\\src\\Student List.txt");
        
        System.out.println("List of Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        List<String> studentName = readStudentNamesFromFile("D:\\\\UNI\\\\206\\\\lab\\\\Lab03\\\\src\\\\Student List.txt");
        
        int groupSize = 2; 
        List<List<String>> groups = createRandomGroups(studentName, groupSize);
        
        System.out.println("Random Groups:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groups.get(i));
        }
    }

    public static List<String> readStudentNamesFromFile(String fileName) {
        List<String> studentName = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                studentName.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return studentName;
    }


    public static void second(String[] args) {
        
    }

    public static List<List<String>> createRandomGroups(List<String> studentNames, int groupSize) {
        
        Collections.shuffle(studentNames);
        
        List<List<String>> groups = new ArrayList<>();
        int numGroups = studentNames.size() / groupSize;
        
        for (int i = 0; i < numGroups; i++) {
            List<String> group = new ArrayList<>();
            for (int j = 0; j < groupSize; j++) {
                group.add(studentNames.remove(0)); 
            }
            groups.add(group);
        }
        
        
        if (!studentNames.isEmpty()) {
            groups.add(studentNames);
        }
        
        return groups;
}
}



