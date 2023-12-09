package us.hadam.practice.dynamic;

import java.util.List;

class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int l=triangle.size()-1; l>0; l--) {
            List<Integer> layer = triangle.get(l);
            List<Integer> above = triangle.get(l-1);
            for (int i=0; i<layer.size()-1; i++) {
                int first = layer.get(i);
                int second = layer.get(i+1);
                above.set(i, above.get(i) + Math.min(first, second));
            }
        }
        return triangle.get(0).get(0);
    }
}