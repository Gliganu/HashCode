package controller;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static double calculateCellsDistance(int rowA, int colA, int rowB, int colB) {
        return Math.sqrt( Math.pow(Math.abs(rowA - rowB),2) + Math.pow(Math.abs(colA - colB),2) );
    }

    // chops a list into non-view sub-lists of length L
    public static <T> List<List<T>> chop(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
}
