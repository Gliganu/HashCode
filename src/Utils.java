
public class Utils {

    public static double calculateCellsDistance(int rowA, int colA, int rowB, int colB) {
        return Math.sqrt( Math.pow((rowA - rowB),2) + Math.pow((rowA - rowB),2) );
    }
}
