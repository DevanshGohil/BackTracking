import java.util.Stack;


public class Board{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int n,m;
    char b[][];
    static int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
    Board(int n,int m){
    	this.n=n;
    	this.m=m;
        b=new char[n][m];
    }

    public void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }
    
    public boolean backtrack(int botx,int boty,Point destination,int lastx,int lasty, Stack<String> list){
	    if(botx==destination.x && boty==destination.y)
	        return true;
	   
	    int flag=0;
	    for(int i=0;i<4;i++){
	    	if(dir[i][0]==-1 && dir[i][1]==0 && botx>0 && this.b[botx-1][boty]==' '){
	    		this.b[botx][boty]='*';
	    		if(backtrack(botx-1,boty,destination,botx,boty, list)){
	    			list.push("UP");
	    			return true;
	    		}
	    		flag=1;
	    	}else if(dir[i][0]==1 && dir[i][1]==0 && botx<n && this.b[botx+1][boty]==' '){
	    		this.b[botx][boty]='*';
	    		if(backtrack(botx+1,boty,destination,botx,boty, list)){
	    			list.push("DOWN");
	    			return true;
	    		}
	    		flag=1;
	    	}else if(dir[i][0]==0 && dir[i][1]==1 && boty<m && this.b[botx][boty+1]==' '){
	    		this.b[botx][boty]='*';
	    		if(backtrack(botx,boty+1,destination,botx,boty, list)){
	    			list.push("RIGHT");
	    			return true;
	    		}
	    		flag=1;
	    	}else if(dir[i][0]==0 && dir[i][1]==-1 && boty>0 && this.b[botx][boty-1]==' '){
	    		this.b[botx][boty]='*';
	    		if(backtrack(botx,boty-1,destination,botx,boty, list)){
	    			list.push("LEFT");
	    			return true;
	    		}
	    		flag=1;
	    	}
	    }
	    
	    if(flag==0){
	    	this.b[botx][boty]='*';
	    	return false;
	    }
	    
	    return false;
	}

	public Stack<String> backTrack(int botx, int boty, Point destination, int botx2,int boty2) {
		// TODO Auto-generated method stub
		Stack<String> list=new Stack<String>();
		backtrack(botx,boty,destination,botx2,boty2,list);
		return list;
	}

	public void printPath(Stack<String> path) {
		// TODO Auto-generated method stub
		if(path.isEmpty()){
			System.out.println("there doesn't exist such a path");
			return ;
		}
		
		while(!path.isEmpty()){
			System.out.println(path.pop());
		}
	}
}
