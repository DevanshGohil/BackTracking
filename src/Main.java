import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		File f=new File("E:/JAVA/java_pro/BackTrack/src/input2.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("file not found");
			return;
		}
		String s[]=scan.nextLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		Board board=new Board(n,m);
	    for(int i=0;i<n;i++){
	    	String st =scan.nextLine();
	    	for(int j=0;j<m;j++){
	    		board.b[i][j]=st.charAt(j);
	    	}
	    }
	    
	    s=scan.nextLine().split(" ");
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
	    Point start=new Point(n,m);
	    
	    s=scan.nextLine().split(" ");
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
	    Point destination=new Point(n,m);
	    
	    int botx=start.x;
	    int boty=start.y;
	    board.b[botx][boty]='B';
	    
	    board.print();
	    Stack<String> path=board.backTrack(botx,boty,destination,botx,boty);
	    board.printPath(path);
	}

}


