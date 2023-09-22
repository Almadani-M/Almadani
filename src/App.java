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
        selectionSort(studentNames);
        System.out.println("Selection sort\n");
        studentNames.forEach(System.out::println);
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
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
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
public static void sort(int[] arr) {
    insertionSort(arr);
}
public static void selectionSort(List<String> studentNames) {
    int n = studentNames.size();
    
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        
        for (int j = i + 1; j < n; j++) {
            if (studentNames.get(j).compareTo(studentNames.get(minIndex)) < 0) {
                minIndex = j;
            }
        }
        Collections.swap(studentNames, i, minIndex);
    }
    
}
}




