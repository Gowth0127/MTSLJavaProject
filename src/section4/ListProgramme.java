package section4;

import java.util.*;

public class ListProgramme {

    public static List<String> sortAndFilterNames(List<String> names, char startLetter) {      
        Collections.sort(names);      
        List<String> filteredNames = new ArrayList<>();
  
        for (String name : names) {
            if (Character.toLowerCase(name.charAt(0)) == Character.toLowerCase(startLetter)) {
                filteredNames.add(name); 
            }
        }

        return filteredNames;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Amanda");
        names.add("Charlie");
        names.add("Brian");
        names.add("David");
        names.add("Daniel");

        char startLetter = 'A';

        List<String> result = sortAndFilterNames(names, startLetter);

        System.out.println("Sorted and filtered names: " + result);
    }
}

