package intro;

import java.util.ArrayList;

public class Josephus {
    public static int josephus(int size) {
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            elements.add(i);
        }
        int cur = 0;
        while (elements.size() > 1) {
            if (cur == elements.size() - 1) {
                elements.remove(0);
                cur = 0;
                continue;
            }
            if (cur == elements.size()) {
                cur = 0;
            }
            elements.remove(cur + 1);
            cur++;
        }
        return elements.get(0);
    }

    public static void main(String[] args) {
        System.out.println(josephus(6));
    }
}
