package Lesson9;

import java.io.*;
import java.util.*;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Lesson9/urls.txt");
        Scanner scanner = new Scanner(file);
        Map<String, Integer> tempMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String tempStr = scanner.nextLine();
            if (tempStr.charAt(0) == ' ')
                tempStr = tempStr.split(" ")[1];
            if (tempMap.containsKey(tempStr))
                tempMap.put(tempStr, tempMap.get(tempStr) + 1);
            else
                tempMap.put(tempStr, 1);
        }
        ValueComparator VC = new ValueComparator(tempMap);
        TreeMap<String, Integer> sortedTempMap = new TreeMap<>(VC);
        sortedTempMap.putAll(tempMap);

        int i = 0;

        for (Map.Entry<String, Integer> set : sortedTempMap.entrySet()) {
            if (i == 10)
                break;
            System.out.println("Link:" + set.getKey() + "\tCount:" + set.getValue());
            i++;
        }
    }

    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
