package day3;

public class TreeCounter {

    private static char tree = '#';

    public static int countTrees(String[]lines, int intHorizontalPos, int headRight, int headDown) {
        int treeCounter = 0;
        int lineLength = lines[0].length();

        for (int i = headDown; i<lines.length; i+=headDown) {
            if (intHorizontalPos < lineLength-headRight) {
                intHorizontalPos += headRight;
            } else {
                intHorizontalPos = intHorizontalPos - lineLength + headRight;
            }

            char position = lines[i].toCharArray()[intHorizontalPos];

            if (position == tree) treeCounter++;
        }

        return treeCounter;
    }

}
