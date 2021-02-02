import java.util.Stack;
public class MaximalMunch {
	int curr_state;
	int final_state;
	int final_input_pos;
	int begin_token_pos;
	int char_pos;
	String input;
	DFA Trans;
	MaximalMunch(String str,DFA t){
		Trans=t;
		input=str;
		curr_state=1;
		final_state=0;
		char_pos=0;
		begin_token_pos=0;
		final_input_pos=0;
	}
	public void next_token() {
		String ex,lexeme;
		while(begin_token_pos!=input.length()) {
			ex=Character.toString(input.charAt(char_pos));
			int exm=Integer.parseInt(Trans.CharcatTable.get(ex));
			curr_state=Integer.parseInt(Trans.TransitionTable[curr_state][exm]);
			if(curr_state!=0) {
				char_pos+=1;
				final_state=curr_state;
				final_input_pos=char_pos;
			}
			else {
				lexeme=input.substring(begin_token_pos,final_input_pos);
				begin_token_pos=final_input_pos;
				char_pos=final_input_pos;
				curr_state=1;
				final_state=0;
			}
			if(char_pos==input.length()-1) {
				lexeme=input.substring(begin_token_pos,final_input_pos+1);
				System.out.println("MaximalMunch:"+Trans.TokenTable.get(String.valueOf(curr_state)));
				begin_token_pos=input.length();
			}
			
		}
	}
}
