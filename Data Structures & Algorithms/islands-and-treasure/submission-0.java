class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int distance = 1;

        while (!q.isEmpty()) {
            int length = q.size();
            for(int i=0;i<length;i++){
                int[] currCell = q.poll();
                if(currCell[0]-1>=0 && grid[currCell[0]-1][currCell[1]]==2147483647){
                    grid[currCell[0]-1][currCell[1]]=distance;
                    q.add(new int[]{currCell[0]-1,currCell[1]});
                }
                if(currCell[0]+1<grid.length && grid[currCell[0]+1][currCell[1]]==2147483647){
                    grid[currCell[0]+1][currCell[1]]=distance;
                    q.add(new int[]{currCell[0]+1,currCell[1]});
                }
                if(currCell[1]-1>=0 && grid[currCell[0]][currCell[1]-1]==2147483647){
                    grid[currCell[0]][currCell[1]-1]=distance;
                    q.add(new int[]{currCell[0],currCell[1]-1});
                }
                if(currCell[1]+1<grid[0].length && grid[currCell[0]][currCell[1]+1]==2147483647){
                    grid[currCell[0]][currCell[1]+1]=distance;
                    q.add(new int[]{currCell[0],currCell[1]+1});
                }

            }
            distance++;
        }

    }
}
