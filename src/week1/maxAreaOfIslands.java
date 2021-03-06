package week1;

public class maxAreaOfIslands {
    static int[][] g;

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int t = maAreaOfIslands(grid);
        System.out.println(t);
    }

    private static int maAreaOfIslands(int[][] grid) {
        g = grid;
        int max = 0;
        int currentMax ;
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[i].length ; j++){
                if(grid[i][j]==1){
                    currentMax = check(i,j);
                    if(currentMax>max){
                        max=currentMax;
                    }
                }
            }
        }
        return max;
    }



    private static int check(int i, int j){
        int count = value(i,j);
        if(count==1){
            count += check(i+1,j);
            count += check(i,j+1);
            count += check(i-1,j);
            count += check(i, j-1);
        }
        return count;
    }
    private static int value(int i, int j){
        if(i<0||j<0||i>=g.length||j>=g[i].length){
            return 0;
        }
        int temp = g[i][j];
        g[i][j]=0;
        return temp;
    }
}
