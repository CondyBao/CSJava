package intro;

import java.util.ArrayList;
import java.util.HashMap;

public class PQ<auto> {
    ArrayList<E> pq = new ArrayList<>();
    HashMap<auto, Integer> map = new HashMap<>();

    public void push(auto element, int p) {
        if (map.containsKey(element)) {
            pq.remove((int)map.get(element));
        }
        int l = 0, r = pq.size() - 1, ans = pq.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (pq.get(mid).p > p) {
                r = mid - 1;
                ans = mid;
            } else l = mid + 1;
        }
        for (int i = ans; i < pq.size(); i++) {
            map.put(pq.get(i).element, map.get(pq.get(i).element) + 1);
        }
        map.put(element, ans);
        pq.add(ans, new E(element, p));
    }

    public String toString() {
        String returnString = "";
        for (E i : pq) {
            returnString += i.toString() + "\n";
        }
        return returnString;
    }

    public E pop() {
        E info = pq.get(0);
        pq.remove(0);
        return info;
    }

    public int getSize() {
        return pq.size();
    }

    private class E {
        auto element;
        int p;

        public String toString() {
            return element + ": " + p;
        }
        public E(auto element, int p) {
            this.element = element;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        PQ<String> newPQ = new PQ<>();
        newPQ.push("Condy", 15);
        newPQ.push("x", 1);
        newPQ.push("xx", 2);
        newPQ.push("xxx", 17);
        System.out.println(newPQ);
        System.out.println(newPQ.getSize());
        newPQ.push("Condy", 14);
        System.out.println(newPQ);
    }
}
