public class HashMap{
        
    int[][] hashmap;
        
    public HashMap(){
        this.hashmap = new int[256][2];
        for (int i = 0; i< this.hashmap.length; i++) {
            hashmap[i][0]=-1;
        }
    }

    public void put(char index, int val){
        hashmap[(int)index][0]=1;
        hashmap[(int)index][1]=val;
    }
    
    public int get(char index){
        if (this.containsKey(index)) {
            return hashmap[(int)index][1];
        }else {
            return -1;
        }
    }

    public boolean containsKey(char index){
        if (hashmap[(int)index][0]==1) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((int)'a');        
    }
}  