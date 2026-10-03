class Solution {

    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int time = 0, fresh = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty() && fresh>0) {
            int currLength = q.size();
            for(int i=0;i<currLength;i++){
                int[] qEle = q.poll();
                if(qEle[0]-1>=0 && grid[qEle[0]-1][qEle[1]]==1){
                    grid[qEle[0]-1][qEle[1]]=2;
                    q.add(new int[]{qEle[0]-1,qEle[1]});
                    fresh--;
                }
                if(qEle[0]+1<grid.length && grid[qEle[0]+1][qEle[1]]==1){
                    grid[qEle[0]+1][qEle[1]]=2;
                    q.add(new int[]{qEle[0]+1,qEle[1]});
                    fresh--;
                }
                if(qEle[1]-1>=0 && grid[qEle[0]][qEle[1]-1]==1){
                    grid[qEle[0]][qEle[1]-1]=2;
                    q.add(new int[]{qEle[0],qEle[1]-1});
                    fresh--;
                }
                if(qEle[1]+1<grid[0].length && grid[qEle[0]][qEle[1]+1]==1){
                    grid[qEle[0]][qEle[1]+1]=2;                    
                    q.add(new int[]{qEle[0],qEle[1]+1});
                    fresh--;
                }
            }
            time++;
        }
        if(fresh==0){
            return time;
        }
        return -1;
    }
}