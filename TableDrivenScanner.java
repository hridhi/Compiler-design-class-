import java.util.Stack;
public class TableDrivenScanner {
	int state;
	String lexeme="";
	Stack<String> stk= new Stack<>();
	String cur_int;
	String input;
	int cnt=0;
	public void next_token(String s,DFA Trans) {
		cur_int=s;
		input=cur_int;
		state=1;
		stk.clear();
		stk.add("bad");
		
		while(state!=0) {
			String c=next_char();
			if (c=="done") {
				break;
			}
			lexeme=lexeme+c;
			if(!(Trans.TokenTable.get(String.valueOf(state)).equals("NA"))) {
				stk.clear();
			}
			stk.push(String.valueOf(state));
			int cat;
			cat=Integer.parseInt(Trans.CharcatTable.get(c));
			state=Integer.parseInt(Trans.TransitionTable[state][cat]);
		}
		while((state!=0) &&(Trans.TokenTable.get(String.valueOf(state)).equals("NA"))) {
				state=Integer.parseInt(stk.pop());
				lexeme=lexeme.substring(0,lexeme.length()-1);
				roll_back();
			}
		if(state!=0) {
			if(!(Trans.TokenTable.get(String.valueOf(state)).equals("NA"))) {
				System.out.println("TableDrivenScanner: "+Trans.TokenTable.get(String.valueOf(state)));
		}}
		else {
			System.out.println("TableDrivenScanner:invalid");
		}
	}
	public String next_char() {
		if (cnt==cur_int.length()-1) {
			return("done");
		}
		char c= cur_int.charAt(cnt);
		cnt+=1;
		return String.valueOf(c);
	}
	
	public void roll_back(){
		System.out.println("roll-back");
		lexeme=lexeme.substring(0,lexeme.length()-1);
		cnt-=1;
	}
}
