package intro;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class moreMaps {
    public static void company(HashMap<String, Integer> values) {
        int size = values.size(), sum = 0, maxV = 0;
        for (Integer v : values.values()) {
            sum += v;
            maxV = Math.max(maxV, v);
        }
        Scanner input = new Scanner(System.in);
        String inp;
        while(true) {
            System.out.println("Type in the company name, type average to return average value, type STOP to stop.");
            inp = input.nextLine();
            if (Objects.equals(inp, "STOP")) return;
            if (Objects.equals(inp, "average")) {
                System.out.println(sum * 1.0 / size);
                continue;
            }
            if (values.containsKey(inp)) {
                System.out.println(values.get(inp));
            }
            else System.out.println(maxV);
        }
    }

    public static void target(HashMap<String, String> map) {
        Scanner input = new Scanner(System.in);
        String value, ogValue;
        while (true) {
            System.out.println("Print the starting person, print STOP to stop: ");
            value = input.nextLine();
            if (Objects.equals(value, "STOP")) return;
            ogValue = value;
            if (map.containsKey(value)) {
                do {
                    System.out.println(value + " ");
                    value = map.get(value);
                } while (!Objects.equals(ogValue, value));
            }
        }
    }

    public static int fibonacciSolver(int x, HashMap<Integer, Integer> fibonacci) {
        if (fibonacci.containsKey(x)) return x;
        int xVal = fibonacciSolver(x - 1, fibonacci) + fibonacciSolver(x - 2, fibonacci);
        fibonacci.put(x, xVal);
        return xVal;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> comps = new HashMap<>();
        comps.put("apple", 700);
        comps.put("ibm", 400);
        comps.put("tesla", 1000);
        company(comps);
        HashMap<String, String> people = new HashMap<>();
        people.put("Ryan", "Yumna");
        people.put("Cooper", "Anika");
        people.put("Anika", "Ryan");
        people.put("Yumna", "Cooper");
        target(people);
        HashMap<Integer, Integer> fibonacci = new HashMap<>();
        fibonacci.put(1, 1);
        fibonacci.put(2, 1);
        System.out.println(fibonacciSolver(10, fibonacci));
    }
}
