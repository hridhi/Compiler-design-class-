# Compiler-design-class

# Compiler 
Compilers is a compiler program that translates a program in one language into another language program. It can also be said as a large software system with many internal components and algorithms and complex interactions between them. In other words translating the computer program to make it ready for execution.
 It is basically the mix of front end (source code) and back end (maps to target code) . For better translation it also uses the optimizer that analyses and rewrites the intermediate form. 


![alt text](https://github.com/hridhi/Compiler-design-class-/blob/main/image/compiler.PNG)
# Front end
Front end contains the scanners , parsers 

# Main program
1) The main program read a csv file which contains the token table , charcat table and transition table and stores their values 
2) Reads the input String and gives the final state 
3) Table driven scanner 
4) Maximal munch algorithm 
5) Direct coded scanner 

# Initial DFA 
This has the instances of transition table , charcat table , token table and it also prints the respective table. It also has a method to which if inputed a string gives the final state. 

# Table driven scanner 
This is the place where table driven scanner is implemented 


![alt text](https://github.com/hridhi/Compiler-design-class-/blob/main/image/tabledrivenscanner.PNG)
# Direct coded Scanner 
This file has the code for direct coded scanner implementation whch differes for dfa to dfa 


![alt text](https://github.com/hridhi/Compiler-design-class-/blob/main/image/directcoded.PNG)
# Maximal munch algorithm 
This file has the code for the maximal munch algorithm. We use 3 variables to keep track of the input that is being accesed and 2 variables to keep track of the states. So, in total of we are using 5 variables in here.  

# inputfile.csv 
This file contaisn transition table , token table and charcat table as input 

# InstStr.csv 
This is a file that has an input string for which final state need to be determined. 
