import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

public class RK {
    private  String Pattern;      
    private long PatternHash;   
    private int len;        
    private long Prime;         
    private int R;           
    private long RM;         
    static String x = null;
  //Initialize the string 
static String FinalStr4 = null,Line, FinalStr5 = null, FinalStr2 = null, FinalStr1 = null, FinalStr3 = null,FinalStr=null;	
  
 // Multiply each character by its place value and obtain the hash value
    public RK(String Pattern) {
        this.Pattern = Pattern;     
        R = 256;
        len = Pattern.length();
        Prime = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= len-1; i++)
           RM = (R * RM) % Prime;
        PatternHash = hash(Pattern, len);
    } 

 // Initial Hash values of current sliding text window and the Patterntern is being calculated
    private long hash(String keypttrn, int M) { 
        long h = 0; 
        for (int j = 0; j < M; j++) 
            h = (R * h + keypttrn.charAt(j)) % Prime; 
        return h; 
    } 

 // Check if all characters are same
    private boolean check(String txt, int i) {
        for (int j = 0; j < len; j++) 
            if (Pattern.charAt(j) != txt.charAt(i + j)) 
                return false; 
        return true;
    }
//Function to search the Patterntern
    public int search(String matchee) {
        int N = matchee.length(); 
        if (N < len) return N;
        long txtHash = hash(matchee, len); 
        if ((PatternHash == txtHash) && check(matchee, 0))
            return 0;
        for (int i = len; i < N; i++) {
            txtHash = (txtHash + Prime - RM*matchee.charAt(i-len) % Prime) % Prime; 
            txtHash = (txtHash*R + matchee.charAt(i)) % Prime; 
            int offset = i - len + 1;
            if ((PatternHash == txtHash) && check(matchee, offset))
                return offset;
        }
      return N;
    }
// To find the random prime number 
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

   
    public static void main(String[] args) throws IOException {
    	long endTime;
    	String fileName1=null,fileName2=null,fileName3=null,fileName4=null,fileName5=null;
	  
   	  long startTime = System.currentTimeMillis();
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
        String fileName6 = "E:\\originalworkspace1\\P5\\outputRK.txt";
        
        //Read files into buffer
        BufferedReader plaigdoc =  new BufferedReader(new FileReader(fileName));
        BufferedReader in1 =  new BufferedReader(new FileReader(fileName1));
        BufferedReader in2 =  new BufferedReader(new FileReader(fileName2));
        BufferedReader in3 =  new BufferedReader(new FileReader(fileName3));
        BufferedReader in4 =  new BufferedReader(new FileReader(fileName4));
        BufferedReader in5 =  new BufferedReader(new FileReader(fileName5));
        BufferedWriter out =  new BufferedWriter(new FileWriter(fileName6));	
     //Read each line from buffer to variable
        while ((Line = plaigdoc.readLine()) != null) {
    	 if (FinalStr == null)
    	 {
    		 FinalStr = Line;
    	 }
    	 else
    	 {
    	 FinalStr  =FinalStr  + Line;
    	 }
     }
     while ((Line = in1.readLine()) != null) {
    	 if (FinalStr1 == null)
    	 {
    		 FinalStr1 = Line;
    	 }
    	 else
    	 {
    	 FinalStr1 =FinalStr1 + Line;
    	 }

     }
     while ((Line = in2.readLine()) != null) {
    	 if (FinalStr2 == null)
    	 {
    		 FinalStr2= Line;
    	 }
    	 else
    	 {
    	 FinalStr2 =FinalStr2 + Line;
    	 }

     }
     while ((Line = in3.readLine()) != null) {
    	 if (FinalStr3 == null)
    	 {
    		 FinalStr3 = Line;
    	 }
    	 else
    	 {
    	 FinalStr3 =FinalStr3 + Line;
    	 }

     }
     while ((Line = in4.readLine()) != null) {
    	 if (FinalStr4 == null)
    	 {
    		 FinalStr4 = Line;
    	 }
    	 else
    	 {
    	 FinalStr4=FinalStr4 + Line;
    	 }

     }
     while ((Line = in5.readLine()) != null) {
    	 if (FinalStr5 == null)
    	 {
    		 FinalStr5 = Line;
    	 }
    	 else
    	 {
    	 FinalStr5 =FinalStr5 + Line;
    	 }
     }
     String delimiter = "\\s+|(?=[,.])";                
     FinalStr1 = FinalStr1.replaceAll("\\.","");
     FinalStr1 = FinalStr1.replaceAll("\\s","");
        FinalStr2 =FinalStr2.replaceAll("\\.","");   
        FinalStr2 =FinalStr2.replaceAll("\\s",""); 
        FinalStr3 = FinalStr3.replaceAll("\\.","");
        FinalStr4 =FinalStr3.replaceAll("\\s","");
        FinalStr4 =FinalStr4.replaceAll("\\s","");
        FinalStr4 =FinalStr4.replaceAll("\\.","");
        FinalStr5 = FinalStr5.replaceAll("\\.","");
        FinalStr5 = FinalStr5.replaceAll("\\s","");
        
        System.out.println("FinalStr1"+FinalStr1);
        String[] plaigsent =FinalStr.split(delimiter);
        for (int i = 0; i < plaigsent.length; i++)
        {
            RK searcher = new RK( plaigsent[i]);
            int offset = searcher.search(FinalStr1);
            if (x == null)
            {
            	x = "With document 1 at index: "+offset+" Pattern: "+plaigsent[i];
            }
            else
            {
            	x = x +"\n \t Index: "+offset+" Pattern: "+plaigsent[i];
            }
        }
        endTime = System.currentTimeMillis();
        x=x+"\n\t Total execution time for 1 file: " + (endTime - startTime)+" ms \n";
        x=x+"\n \n \n With document 2";
        for (int i = 0; i < plaigsent.length; i++)
        {
            RK searcher = new RK( plaigsent[i]);
            int offset = searcher.search(FinalStr2);
            	x = x +"\n \t Index: "+offset+" Pattern: "+plaigsent[i];
              	
        }
        endTime = System.currentTimeMillis();
        x=x+"\n\t Total execution time for 2 file: " + (endTime - startTime)+" ms \n";
        x=x+"\n \n \n With document 3";
        for (int i = 0; i < plaigsent.length; i++)
        {
            RK searcher = new RK( plaigsent[i]);
            int offset = searcher.search(FinalStr3);
            	x = x + "\n \t Index: "+offset+" Pattern: "+plaigsent[i];     	
        }
        endTime = System.currentTimeMillis();
        x=x+"\n\t Total execution time for 3 file: " + (endTime - startTime)+" ms \n";
        x=x+"\n \n \n With document 4";
        for (int i = 0; i < plaigsent.length; i++)
        {
            RK searcher = new RK( plaigsent[i]);
            int offset = searcher.search(FinalStr4);
            	
            	x = x +"\n \t Index: "+offset+" Pattern: "+plaigsent[i];            	
        }
        endTime = System.currentTimeMillis();
        x=x+"\n\t Total execution time for 4 file: " + (endTime - startTime)+" ms \n";
        x=x+"\n \n \nWith document 5";
        for (int i = 0; i < plaigsent.length; i++)
        {
            RK searcher = new RK( plaigsent[i]);
            int offset = searcher.search(FinalStr5);
            
            	x = x + "\n\t Index: "+offset+" Pattern: \""+plaigsent[i];
        }
        endTime = System.currentTimeMillis();
        x=x+"\n\t Total execution time for 5 file: " + (endTime - startTime)+" ms \n";
        if( x != null)
        {
        out.write(x);
        }
        else
        {
        	out.write("Document has not been plaigiarised");
        }
        out.flush();
	   	
 }
}
