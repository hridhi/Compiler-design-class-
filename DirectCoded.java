import java.util.HashMap;
import java.util.Stack;
//r0
public class DirectCoded {
	String lexeme;
	String state;
	int cnt=0;
	Stack<String> stk=new Stack<>();
	String cur_input;
	String name="0123456789";
	DFA Trans;
	HashMap<String, String> Tokens = new HashMap<String, String>();
	DirectCoded(String s,DFA T){
		cur_input=s;
		Trans=T;
		stk.clear();
		stk.push("bad");
		state="0";
		Tokens.put("0", "invalid");
		Tokens.put("1", "invalid");
		Tokens.put("2", "register");
		Tokens.put("-1", "Dead");
	}
	public void next_token() {
		for (int i=0;i<cur_input.length();i++) {
			//System.out.println(state);
			String c =next_char();
			if (state.equals("0")) {
				lexeme=lexeme+c;
				if(state.equals("2")) {
					stk.clear();
				}
				stk.push(state);
				if(c.equals("r")) {
					state="1";
				}
				else {
					state="-1";
				}
			}
			
			else {
				if(state.equals("1")) {
					lexeme=lexeme+c;
					if(state.equals("2")) {
						stk.clear();
					}
					stk.push(state);
					if( name.contains(c)){
						state="2";
					}
					else {
						state="-1";
					}
				}
				else {
					if (state.equals("2")) {
						lexeme=lexeme+c;
						if(state.equals("2")) {
							stk.clear();
						}
						if(name.contains(c)) {
							state="2";
						}
						else {
							state="-1";
						}
					}
					
				}
			}
			if(state.equals("-1")) {
				while(state!="2" && state!="bad") {
					state=stk.pop();
					lexeme=lexeme.substring(0,lexeme.length()-1);
				}
			}
			if(state.equals("2")) {
				System.out.print(Tokens.get(state));
			}
			else {
				System.out.println("invalid");
			}
			}
		}
	public String next_char() {
		char c= cur_input.charAt(cnt);
		cnt+=1;
		return String.valueOf(c);
	}
	
	public void roll_back(){
		System.out.println("roll-back");
		lexeme=lexeme.substring(0,lexeme.length()-1);
		cnt-=1;
	}
}
