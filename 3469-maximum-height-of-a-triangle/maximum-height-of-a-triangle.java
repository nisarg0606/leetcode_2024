class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    private int maxHeight(int red, int blue) {
        int row = 1;
        int height = 0;
        while (true) {
            if (row % 2 != 0) {
                if (red >= row)
                    red = red - row;
                else
                    break;
            } else {
                if (blue >= row)
                    blue = blue - row;
                else
                    break;
            }
            row++;
            height++;
        }
        return height;
    }
}