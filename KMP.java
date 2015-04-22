

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

public class KMP {
	static java.util.Date date= new java.util.Date();
	static String x = null;
	int i, j,PatternLen,  Len;
	static String delimiter = "\\."; 
	static String FStr5 = null,FStr4 = null,FStr3 = null,FStr = null,FStr1 = null,FStr2 = null;
	static String Line;
	//Function to find the pattern match
    public int[] COMPUTEPREFIXFUNCTION(String[] Pattern) {
    	i=0;
    	j=-1;
	    PatternLen = Pattern.length;
	        int[] Begin = new int[PatternLen + 1];
	        Begin[i] = j;
	        while (i < PatternLen) {   	        	
	            while (j >= 0 && !(Pattern[i].equals(Pattern[j]))) {	               
	                j = Begin[j];
	            }
	            i++;
	            j++;
	            Begin[i] = j;
	        }
	       System.out.println("Index table");         
	        for (int tmp : Begin) {
	            System.out.print(tmp + "   ");
	        }
	        System.out.print("\n ");
	        for (int l = 0; l < Pattern.length; l++) {
	            System.out.print(l + "   ");				
	        }
	        return Begin;
	    }
	 
	   //Function to check plagarism using KMP
	    public void KMPMATCHER(String[] M, String[] Pattern,int doc) throws FileNotFoundException {
	    	i=0;
	    	j=0;
	        PatternLen = Pattern.length;
	        Len = M.length;	        
	        int[] b = COMPUTEPREFIXFUNCTION(Pattern);
	        while (i < Len) {	        	
	            for( j=0;j<Pattern.length;j++)
	            {
	            	if( (M[i].equals(Pattern[j])))	            	
	             { 	              
	            		if( x == null)
	            		{
	            				x = " PLAGARISED WITH DOCUMENT # "+doc+" AT LINE #" + i+"\n PATTERN IS : "+Pattern[j]+"\n" ;
	            		}
	            		else
	            		{
	            			x= x + "\n"+" PLAGARISED WITH DOCUMENT # "+doc+" AT LINE #" + i+"\n PATTERN IS : "+Pattern[j]+"\n" ;
	            		}	            			             
	             }
	            }
	            i++;	
	        }	       
	    }
	  
	    //Main function begins
	    public static void main(String[] args) throws IOException {
	    	KMP	  stm = new KMP();
	    	String fileName1=null,fileName2=null,fileName3=null,fileName4=null,fileName5=null;
	    	long endTime;
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
	        
            String fileNameoutput = "E:\\originalworkspace1\\P5\\outputkmp.txt";
            //Read all file and store it in buffer	
            BufferedReader plaigdoc =  new BufferedReader(new FileReader(fileName));
            BufferedReader in1 =  new BufferedReader(new FileReader(fileName1));
            BufferedReader in2 =  new BufferedReader(new FileReader(fileName2));
            BufferedReader in3 =  new BufferedReader(new FileReader(fileName3));
            BufferedReader in4 =  new BufferedReader(new FileReader(fileName4));
            BufferedReader in5 =  new BufferedReader(new FileReader(fileName5));
            BufferedWriter output2 =  new BufferedWriter(new FileWriter(fileNameoutput));        
       
         //Read each line from the buffer and concatenate to string
         while ((Line = plaigdoc.readLine()) != null) {
        	 if (FStr == null)
        	 {
        		 FStr = Line;
        	 }
        	 else
        	 {
        	 FStr  =FStr  + Line;
        	 }
         }
         while ((Line = in1.readLine()) != null) {
        	 if (FStr1 == null)
        	 {
        		 FStr1 = Line;
        	 }
        	 else
        	 {
        	 FStr1 =FStr1 + Line;
        	 }

         }
         while ((Line = in2.readLine()) != null) {
        	 if (FStr2 == null)
        	 {
        		 FStr2= Line;
        	 }
        	 else
        	 {
        	 FStr2 =FStr2 + Line;
        	 }

         }
         while ((Line = in3.readLine()) != null) {
        	 if (FStr3 == null)
        	 {
        		 FStr3 = Line;
        	 }
        	 else
        	 {
        	 FStr3 =FStr3 + Line;
        	 }

         }
         while ((Line = in4.readLine()) != null) {
        	 if (FStr4 == null)
        	 {
        		 FStr4 = Line;
        	 }
        	 else
        	 {
        	 FStr4=FStr4 + Line;
        	 }

         }
         while ((Line = in5.readLine()) != null) {
        	 if (FStr5 == null)
        	 {
        		 FStr5 = Line;
        	 }
        	 else
        	 {
        	 FStr5 =FStr5 + Line;
        	 }

         }
         //Copy each sentence into array using the delimiter
	        String[] sentence1 = FStr1.split(delimiter);
	        String[] sentence2 =FStr2.split(delimiter);	        
	        String[] sentence3 = FStr3.split(delimiter);
	        String[] sentence4 =FStr4.split(delimiter);	        
	        String[] sentence5 = FStr5.split(delimiter);
	        String[] plaigsent =FStr.split(delimiter);	        
	      //Check for pattern matching
	         stm.KMPMATCHER(sentence1,plaigsent,1);
	         endTime = System.currentTimeMillis();
	         x=x+"\n\t Total execution time for 1 file: " + (endTime - startTime)+" ms \n";
	         stm.KMPMATCHER(sentence2,plaigsent,2);
	         endTime = System.currentTimeMillis();
	         x=x+"\n\t Total execution time for 2 file: " + (endTime - startTime)+" ms \n";
	         stm.KMPMATCHER(sentence3,plaigsent,3);
	         endTime = System.currentTimeMillis();
	         x=x+"\n\t Total execution time for 3 files : " + (endTime - startTime)+" ms \n";
	         stm.KMPMATCHER(sentence4,plaigsent,4);
	         endTime = System.currentTimeMillis();
	         x=x+"\n\t Total execution time for 4 files: " + (endTime - startTime)+" ms \n";
	         stm.KMPMATCHER(sentence5,plaigsent,5);
	         endTime = System.currentTimeMillis();
	         x=x+"\n\t Total execution time for 5 files: " + (endTime - startTime)+" ms \n";
	         if(x != null)
	         {
	      	 output2.write(x);
	         }
	         else
	         {
	         output2.write("Document has not been plaigiarised");
	         }
	      	output2.flush();
	      	plaigdoc.close();
	      	in1.close();
	    	in2.close();
	    	in3.close();
	    	in4.close();	    	
	    	in5.close();
	    	output2.close();
	    }
	    }




