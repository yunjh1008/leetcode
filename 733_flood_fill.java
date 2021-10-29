// 733. Flood Fill
class Solution {
    class Coordinates {
        public int r;
        public int c;
        
        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    // North, South, West, East
    int[] rDirection = {-1, 1, 0, 0};
    int[] cDirection = {0, 0, -1, 1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] isVisited = new boolean[row][col];
        Queue<Coordinates> queue = new LinkedList<>();
        
        int originalColor = image[sr][sc];
        image[sr][sc] = newColor;
        isVisited[sr][sc] = true;
        Coordinates item = new Coordinates(sr, sc);
        queue.add(item);
        
        while(!queue.isEmpty()) {
            Coordinates current = queue.poll();
            int currentR = current.r;
            int currentC = current.c;
            
            for(int i = 0; i < 4; i++) {
                int nextR = currentR + rDirection[i];
                int nextC = currentC + cDirection[i];
                
                if(nextR >= 0 && nextR < row && nextC >= 0 && nextC < col 
                   && image[nextR][nextC] == originalColor && !isVisited[nextR][nextC]) {
                    Coordinates newItem = new Coordinates(nextR, nextC);
                    image[nextR][nextC] = newColor;
                    isVisited[nextR][nextC] = true;
                    queue.add(newItem);
                }
            }
        }
        
        return image;
    }
}
