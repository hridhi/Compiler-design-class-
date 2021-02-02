import java.util.ArrayList;
import java.util.HashMap;
public class DFA {
	String [][] TransitionTable=new String[100][100];
	HashMap<String, String> CharcatTable = new HashMap<String, String>();
	HashMap<String, String> TokenTable = new HashMap<String, String>();
	
	public void ReadTransition(ArrayList<String> arr,int n, int m) {
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				TransitionTable[i][j]=arr.get(cnt);
				cnt=cnt+1;
			}
		}
	}
	
	public void ReadToken(ArrayList<String> arr,int st,int n) {
		for(int i=0;i<n;i++) {
			TokenTable.put(arr.get(st+i), arr.get(n+st+i));
		}
	}
	
	public void ReadCharcat(ArrayList<String> arr,int l,int st) {
		int m=l/2;
		for(int i=0;i<m;i++) {
			CharcatTable.put(arr.get(st+i),arr.get(st+i+m));
		}
	}
	
	public void PrintTransition(int n ,int m ) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(TransitionTable[i][j]+' ');
			}
			System.out.println("\n");
		}
	}
	
	public void PrintToken() {
		System.out.println(TokenTable);
	}
	
	public void PrintCharcat() {
		System.out.println(CharcatTable);
	}
	
	public void GetState(ArrayList<String> a1) {
		String s="error state";
		int state=1;
		int sz=a1.size();
		for(int i=0;i<sz;i++) {
			int cat=Integer.parseInt(CharcatTable.get(a1.get(i)));
			state=Integer.parseInt(TransitionTable[state][cat]);
			if (state==0) {
				s="error state";
				break;
			}
		}
		s=String.valueOf(state);
		s=TokenTable.get(s);
		System.out.println("The final state that it reaches is: "+s);
	}
}
