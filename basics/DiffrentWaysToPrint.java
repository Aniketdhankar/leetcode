import java.util.ArrayList;
import java.util.List;

public class DiffrentWaysToPrint {
    static void print1(int sr,int sc,int er,int ec,String path){
        if(sr==er-1 && sc==ec-1){
            System.out.println(path);
            return ;
        }
        //Base Case
        if(sr>=er || sc>=ec){
            return ;
        }
        //down
        print1(sr+1,sc,er,ec,path+"D");
        //right
        print1(sr,sc+1,er,ec,path+"R");
        
    }
   static List<String> print2(int sr,int sc,int er,int ec,String path){
    if(sr==er-1 && sc==ec-1){
        List<String> list=new ArrayList<>();
        list.add(path);
        return list;
    }

    if(sr>=er || sc>=ec){
        return new ArrayList<>();
    }

    List<String> down = print2(sr+1, sc, er, ec, path+"d");
    List<String> right = print2(sr, sc+1, er, ec, path+"r");

    down.addAll(right);
    return down;
}
static void print3(int sr,int sc,int er,int ec,String path, ArrayList<String> ans){
    if(sr==er-1 && sc==ec-1){
        ans.add(path);
        return;
    }

    if(sr>=er || sc>=ec) return;

    print3(sr+1, sc, er, ec, path+"d", ans);
    print3(sr, sc+1, er, ec, path+"r", ans);

}

    static List<List<String>> print4(int sr, int sc, int er, int ec, List<String> path) {

        // reached destination
        if(sr == er-1 && sc == ec-1){
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>(path)); // storing snapshot copy
            return result;
        }

        // invalid/out of boundary case
        if(sr >= er || sc >= ec){
            return new ArrayList<>();
        }

        // Down move
        List<String> downPath = new ArrayList<>(path);
        downPath.add("d");
        List<List<String>> down = print4(sr+1, sc, er, ec, downPath);

        // Right move
        List<String> rightPath = new ArrayList<>(path);
        rightPath.add("r");
        List<List<String>> right = print4(sr, sc+1, er, ec, rightPath);

        // merge both
        down.addAll(right);
        return down;
    }
    static List<String> print6(int sr,int sc,int er,int ec,String path){
    if(sr==er-1 && sc==ec-1){
        List<String> list=new ArrayList<>();
        list.add(path);
        return list;
    }

    if(sr>=er || sc>=ec){
        return new ArrayList<>();
    }

    List<String> res=new ArrayList<>();

    res.addAll(print6(sr+1, sc, er, ec, path+"d"));
    res.addAll(print6(sr, sc+1, er, ec, path+"r"));

    return res;
}



    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int rowCount=4;
        int columnCount=4;
        print1(0,0,rowCount,columnCount,"");
        print2(0,0,rowCount,columnCount,"");
        ArrayList<String> ans=new ArrayList<>();
        print3(0,0,rowCount,columnCount,"",ans);    
        System.out.println(ans);
        List<List<String>> result = print4(0, 0, rowCount, columnCount, new ArrayList<>());
        System.out.println(result);
        List<String> res=print6(0,0,rowCount,columnCount,"");
        System.out.println(res);

    }
    
}
