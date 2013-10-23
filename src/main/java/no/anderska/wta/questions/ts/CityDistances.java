package no.anderska.wta.questions.ts;

import java.util.HashMap;
import java.util.Map;

public class CityDistances {
    private static class Pair {
        private final int a;
        private final int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) obj;
            return ((a == p.a  && b == p.b) || (a == p.b && b == p.a));
        }

        @Override
        public int hashCode() {
            return new Integer(a).hashCode() + new Integer(b).hashCode();
        }
    }
    private Map<Pair,Integer> distances = new HashMap<>();

    public void add(int from, int to, int distance) {
        distances.put(new Pair(from,to),distance);
    }

    public int get(int from, int to) {
        return distances.get(new Pair(from,to));
    }
}
