import static java.lang.Math.max;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCSS{
        private String[] Text,Pattern;
        String c,d;
		private int Doc;
		private int[][] cc;
		private ArrayList Tracking;
		static String Delimiter="\\s+|(?=[,.])";
		static String FStr5 = null,FStr4 = null,FStr3 = null,FStr = null,FStr1 = null,FStr2 = null;
		static String strLine1;
 //LCSS constructor
        public LCSS(String[] from, String[] to, int Doc) {
                this.Text = from;
                this.Pattern = to;
                this.Doc = Doc;
        }
 // Function to calculate the length of string
        public void CalculateLCS() {
            if(cc != null) {
                return;
            }
            cc = new int[lengthOfText()+1][];
            for(int i = 0; i < cc.length; i++) {
                cc[i] = new int[lengthOfPattern()+1];
            }

            for(int i = 1; i < cc.length; i++) {
                for(int j = 1; j < cc[i].length; j++) {
                        if(texteqlpat(i, j)) {
                                cc[i][j] = cc[i-1][j-1] + 1;
                        } else {
                                cc[i][j] = max(cc[i][j-1], cc[i-1][j]);
                        }
                }
            }
            }
// Retrieves value of text        
         String valueOfText(int index) {
        	for(int i =0 ;i<Text.length;i++)
        	{
        		if(i == index)
        		{
        		c= Text[i];
        		}
        	}
                return c;
            }
// Retrives value of pattern         
         String valueOfPattern(int index) {
        	for(int i =0 ;i<Pattern.length;i++)
        	{
        		if(i == index)
        		{
        			        		d= Pattern[i];
        		}
        	}
        	    return d;
        }
// Returns true if both the string matches
        boolean equals(String x1, String y1) {
        return (null == x1 && null == y1) || x1.equals(y1);
        }

//Returns true if pattern value equals text value
        private boolean texteqlpat(int i, int j) {
        return equals(valueOfTextInternal(i),valueOfPatternInternal(j));
        }
//Returns value of text
        private String valueOfTextInternal(int i) {
        return valueOfText(i-1);
        }
//Returns value of pattern
        private String valueOfPatternInternal(int j) {
        return valueOfPattern(j-1);
        }
//Returns pattern length
        int lengthOfPattern() { return Pattern.length; }
//Returns Text length
        int lengthOfText() { return Text.length; }

        public List Tracking() {
        CalculateLCS();
        if(this.Tracking == null) {
            this.Tracking = new ArrayList();
            Tracking(lengthOfText(),lengthOfPattern());
        }
        return this.Tracking;
        }
//Function to find longest common sequence
        public void Tracking(int i, int j) {
        CalculateLCS();

        if (i == 0 || j == 0) {
           return;
        }
        else if (texteqlpat(i, j)) {
            Tracking(i-1,j-1);
            Tracking.add(valueOfTextInternal(i));
        } 
        else {
            if(cc[i][j-1] > cc[i-1][j]) {
                    Tracking(i,j-1);
            } else {
                    Tracking(i-1,j);
            }
        }
        }
//Begin of main function
  public static void main(String[] args) throws IOException {
        	long endTime;
        	long startTime = System.currentTimeMillis();
        	String fileName1=null,fileName2=null,fileName3=null,fileName4=null,fileName5=null;
// Assign the path to variable
        	Scanner in = new Scanner(System.in);
	        System.out.println("This program takes one plagarised document and compares with 5 documents. The output retrives the percentage of plagarism. ");
	        System.out.println("Enter a plagarised test file path:");
	        String fileName = in.nextLine();
	        
	        System.out.println("Enter a test1 file path:");
	        fileName1 = in.nextLine();
	        System.out.println("Enter a test2 file path:");
	        fileName2 = in.nextLine();
	        System.out.println("Enter a test3 file path:");
	        fileName3 = in.nextLine();
	        System.out.println("Enter a test4 file path:");
	        fileName4 = in.nextLine();
	        System.out.println("Enter a test5 file path:");
	        fileName5 = in.nextLine();
    String fileName6 = "E:\\originalworkspace1\\P5\\outputLSS.txt";
    
// Reads from file and store in database
    BufferedReader plaigdoc =  new BufferedReader(new FileReader(fileName));
    BufferedReader in1 =  new BufferedReader(new FileReader(fileName1));
    BufferedReader in2 =  new BufferedReader(new FileReader(fileName2));
    BufferedReader in3 =  new BufferedReader(new FileReader(fileName3));
    BufferedReader in4 =  new BufferedReader(new FileReader(fileName4));
    BufferedReader in5 =  new BufferedReader(new FileReader(fileName5));
    BufferedWriter out =  new BufferedWriter(new FileWriter(fileName6));

 while ((strLine1 = plaigdoc.readLine()) != null) {
	 if (FStr == null)
	 {
		 FStr = strLine1;
	 }
	 else
	 {
	 FStr  =FStr  + strLine1;
	 }
 }
 while ((strLine1 = in1.readLine()) != null) {
	 if (FStr1 == null)
	 {
		 FStr1 = strLine1;
	 }
	 else
	 {
	 FStr1 =FStr1 + strLine1;
	 }

 }
 while ((strLine1 = in2.readLine()) != null) {
	 if (FStr2 == null)
	 {
		 FStr2= strLine1;
	 }
	 else
	 {
	 FStr2 =FStr2 + strLine1;
	 }

 }
 while ((strLine1 = in3.readLine()) != null) {
	 if (FStr3 == null)
	 {
		 FStr3 = strLine1;
	 }
	 else
	 {
	 FStr3 =FStr3 + strLine1;
	 }

 }
 while ((strLine1 = in4.readLine()) != null) {
	 if (FStr4 == null)
	 {
		 FStr4 = strLine1;
	 }
	 else
	 {
	 FStr4=FStr4 + strLine1;
	 }

 }
 while ((strLine1 = in5.readLine()) != null) {
	 if (FStr5 == null)
	 {
		 FStr5 = strLine1;
	 }
	 else
	 {
	 FStr5 =FStr5 + strLine1;
	 }

 }
 //Assign each sentence  to string array
    	String[] comparee = FStr.split(Delimiter);    	
    	String[] compared = FStr1.split(Delimiter);
    	String[] compared1 = FStr2.split(Delimiter);
    	String[] compared2 = FStr3.split(Delimiter);
    	String[] compared3 = FStr4.split(Delimiter);	
    	String[] compared4 = FStr5.split(Delimiter);
    	String x ;
 // perform the substring comparision   	
    	LCSS seq = new LCSS(comparee,compared,1);
                x = seq.Tracking()+" found plagiarised with document 1 ";
                endTime = System.currentTimeMillis();
   	         x=x+"\n\t Total execution time for 1 file: " + (endTime - startTime)+" ms \n";
                LCSS seq1 = new LCSS(comparee,compared1,2);
                x = x + "\n"+seq1.Tracking()+" found plagiarised with document 2 ";
                endTime = System.currentTimeMillis();
   	         x=x+"\n\t Total execution time for 2 file: " + (endTime - startTime)+" ms \n";
                LCSS seq2 = new LCSS(comparee,compared2,3);
                x = x + "\n"+seq2.Tracking()+" found plagiarised with document 3 ";
                endTime = System.currentTimeMillis();
   	          x=x+"\n\t Total execution time for 3 file: " + (endTime - startTime)+" ms \n";
                LCSS seq3 = new LCSS(comparee,compared3,4);
                x = x + "\n"+seq3.Tracking()+" found plagiarised with document 4 ";
                endTime = System.currentTimeMillis();
   	          x=x+"\n\t Total execution time for 4 file: " + (endTime - startTime)+" ms \n";
                LCSS seq4 = new LCSS(comparee,compared4,5);
                x = x + "\n"+seq4.Tracking()+" found plagiarised with document 5 ";
                endTime = System.currentTimeMillis();
   	          x=x+"\n\t Total execution time for 5 file: " + (endTime - startTime)+" ms \n";
            
               out.write(x);
               out.flush();
                
        }}
 
        
        

