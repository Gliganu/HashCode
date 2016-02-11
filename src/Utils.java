
public class Utils {

    public static double calculateCellsDistance(int rowA, int colA, int rowB, int colB) {
        return Math.sqrt( Math.pow(Math.abs(rowA - rowB),2) + Math.pow(Math.abs(colA - colB),2) );
    }
}
