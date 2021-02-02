import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		//C:\\Users\\HRIDHI SETHI\\Downloads\\test2.csv
		//C:\\Users\\HRIDHI SETHI\\Downloads\\inputfile.csv
		Scanner sc = new Scanner(new File("inputfile.csv"));
		sc.useDelimiter(",");
		ArrayList<String> arr = new ArrayList<String>();
		while (sc.hasNext()){  
		arr.add(sc.next().trim());  
		}   
		sc.close(); 
		
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int m = s.nextInt();
		DFA Trans = new DFA();
		Trans.ReadTransition(arr,n,m);
		Trans.PrintTransition(n, m);
		
		int st=n*m;
		Trans.ReadToken(arr,st,n-2);
		Trans.PrintToken();
		
		st=(st+(2*(n-2)));
		int sz=arr.size();
		int l=sz-st+1;
		Trans.ReadCharcat(arr,l,st);
		Trans.PrintCharcat();
		//"C:\Users\HRIDHI SETHI\Downloads\test2.csv"
		//C:\\Users\\HRIDHI SETHI\\Downloads\\InStr.csv
		Scanner scan=new Scanner(new File("InStr.csv"));
		scan.useDelimiter(",");
		ArrayList<String> a1 = new ArrayList<String>();
		while (scan.hasNext()){  
			a1.add(scan.next().trim());  
		}   
		scan.close(); 
		
		Trans.GetState(a1);
		
		TableDrivenScanner tds=new TableDrivenScanner();
		String str =s.next();
		tds.next_token(str, Trans);
		//pass string,dfa
		//keep calling next-token,print statements until end of the file 
		
		MaximalMunch maxm=new MaximalMunch(str,Trans);
		maxm.next_token();
		
		String str2 =s.next();
		DirectCoded dc=new DirectCoded(str2,Trans);
		dc.next_token();
		
		long endTime = System.nanoTime();
        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;
        System.out.println("");
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                                timeElapsed / 1000000);
	}

}
