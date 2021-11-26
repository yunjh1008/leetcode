// 994. Rotting Oranges
class Solution {
    class Orange {
        int r;
        int c;
        
        public Orange(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int minutes = -1;
        int r = grid.length;
        int c = grid[0].length;
        // North, South, East, West
        int[] rDirection = {-1, 1, 0, 0};
        int[] cDirection = {0, 0, 1, -1};
        Queue<Orange> queue = new LinkedList<>();
        ArrayList<Orange> rottenOranges = new ArrayList<Orange>();
        
        // Add initial rotten oranges to the queue
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 2) {
                    Orange rottenOrange = new Orange(i, j);
                    queue.offer(rottenOrange);
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        // add round delimiter
        queue.offer(new Orange(-1, -1));
        
        while(!queue.isEmpty()) {
            Orange orange = queue.poll();
            if(orange.r == -1 && orange.c == -1) {
                minutes++;
                
                if(!queue.isEmpty()) {
                    queue.offer(new Orange(-1, -1));
                }
            }
            else {
                for(int i = 0; i < 4; i++) {
                    int nextR = orange.r + rDirection[i];
                    int nextC = orange.c + cDirection[i];
                    
                    if(nextR >= 0 && nextR < r && nextC >=0 && nextC < c) {
                        if(grid[nextR][nextC] == 1) {
                            grid[nextR][nextC] = 2;
                            freshOranges--;
                            queue.offer(new Orange(nextR, nextC));
                        }
                    }
                }
            }
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
}
