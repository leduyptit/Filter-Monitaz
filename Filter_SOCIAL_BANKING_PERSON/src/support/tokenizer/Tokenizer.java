
package tokenizer;
import java.util.Calendar;
import java.io.*;
public class Tokenizer {
    
    public static void main(String [] args){
    	long begin = Calendar.getInstance().getTimeInMillis();
        if (args.length != 2){
            displayHelp();
            return;
        }
        
        //Read the input data
        try{
            String option = args[0];
            if (option.equalsIgnoreCase("-inputfile")){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(new FileInputStream(args[1]), "UTF-8"));
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(args[1]+".tkn") , "UTF-8"));

                String line = "";
                while ((line = in.readLine()) != null){                
                    out.write(PennTokenizer.tokenize(line).trim());
                    out.write("\n");
                }
                
                in.close();
                out.close();
            }
            
            else if (option.equalsIgnoreCase("-inputdir")){
                System.out.println("Tokenize input");
                //segment only files ends with .sent
                File inputDir = new File(args[1]);
                File [] childrent = inputDir.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".txt");
                    }
                });
                
                for (int i = 0; i < childrent.length; ++i){                    
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(new FileInputStream(childrent[i]), "UTF-8"));
                    BufferedWriter out = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream(childrent[i] + ".tkn") , "UTF-8"));

                    String line = "";
                    while ((line = in.readLine()) != null){
                        out.write(PennTokenizer.tokenize(line));
                        out.write("\n");
                    }

                    in.close();
                    out.close();    
                }
            }           
        } catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Executed Time:  "+ (end - begin)+"/1000(s)"); 
    }
    
    /**
     * Display help.
     */
    public static void displayHelp(){
        System.out.println("Usage:");
	System.out.println("\tCase 1: Tokenizer -inputfile <input data file>");
	System.out.println("\tCase 2: Tokenizer -inputdir <input data directory>");
	System.out.println("\tVd:java -mx2G -cp bin;lib/args4j.jar;lib/htmlparser.jar;lbfgs.jar  >");
	System.out.println();
    }
    
}
