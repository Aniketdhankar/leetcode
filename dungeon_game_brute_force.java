public class dungeon_game_brute_force {
    //this is an brute force solution and we take the maximum possible health using the constrains and return the minimum health using binary search;
    boolean cansurive(int[][] dungeon,int mid,int m,int n,int i,int j){
        if(i>=m||j>=n){
            return false;
        }
        mid+=dungeon[i][j];
        if(mid<=0){
            return false;
        }
        if(i==m-1&&j==n-1){
            return true;
        }
        return cansurive(dungeon,mid,m,n,i+1,j)||cansurive(dungeon, mid, m, n, i, j+1);
    }
   public int min_health(int[][] dungeon){
    int m=dungeon.length;//rows
    int n=dungeon[0].length;//cols
    int left=1;//it should start from 1 as health can never be zero
    int right=200*200*1000;//maxhelath 200 max size of m and n and max health is 1000
    int min_health=0;
    while(left<right){
       int mid = left + (right - left) / 2;
        if(cansurive(dungeon,mid,m,n,0,0)){
            min_health=mid;
            right=mid-1;
        }else{
            left=mid+1;
        }//In binary search, if mid works, you want to try a smaller value → update right = mid - 1.

//If it doesn’t work, you need more health → update left = mid + 1.
    }
    return min_health;


   }
    public static void main(String[] args) {
        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        dungeon_game_brute_force sol = new dungeon_game_brute_force();
        int result = sol.min_health(dungeon);
        System.out.println(result);
    }
 
}

    

