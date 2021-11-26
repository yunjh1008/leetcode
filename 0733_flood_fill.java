// 733. Flood Fill
class Solution {
    class Node {
        public int r;
        public int c;
        
        public Node(int r, int c) {
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
        boolean[][] visit = new boolean[row][col];
        Queue<Node> queue = new LinkedList<>();
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        visit[sr][sc] = true;
        Node node = new Node(sr, sc);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int r = current.r;
            int c = current.c;
            
            for(int i = 0; i < 4; i++) {
                int nextR = r + rDirection[i];
                int nextC = c + cDirection[i];
                
                if(nextR >= 0 && nextR < row && nextC >= 0 && nextC < col
                   && image[nextR][nextC] == oldColor && !visit[nextR][nextC]) {
                    Node nextNode = new Node(nextR, nextC);
                    image[nextR][nextC] = newColor;
                    visit[nextR][nextC] = true;
                    queue.add(nextNode);
                }
            }
        }
        
        return image;
    }
}
