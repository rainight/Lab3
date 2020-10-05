import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Lab3 {

	private static BufferedReader br = null;
	private static PrintWriter out = null;
	private static ArrayList<String[]> recordArr = new ArrayList<String[]>();

	public static void main(String [] args) {
		
		String line = "";
		String csvSplit = ",";
		
				
			try {
			    out = new PrintWriter(new PrintWriter("ArtistsSorted-10042020.txt","UTF-8"));
				br = new BufferedReader(new FileReader("regional-global-daily-latest.csv"));
					
				while((line = br.readLine()) != null ) {
					
					String[] recCopyToBePushed = new String[5];
					String[] recordExtracted = line.split(csvSplit, 5);
					for(int x = 0; x < recordExtracted.length; x++){
						recCopyToBePushed[x] = recordExtracted[x];
					}				
					recordArr.add(recCopyToBePushed);
					
					for (int i=0; i<recordArr.size(); i++) {
						recordArr.get(i)[2] = recordArr.get(i)[2].replaceAll("\"", ""); //remove the double quotes
					  }
						
				}

			for (int i=1; i <recordArr.size(); i++)
			{
				 for(int j=i+1;j<recordArr.size();j++)
				 {
				
					 if(recordArr.get(i)[2].compareToIgnoreCase(recordArr.get(j)[2])>0) //compare two strings lexicographically
					 {
						 String temp;
						 temp=recordArr.get(i)[2];
						 recordArr.get(i)[2]=recordArr.get(j)[2];
						 recordArr.get(j)[2]=temp;
					 }
				 }
			} 
		
				
				for( int rows = 0; rows< recordArr.size(); rows++){
				
					out.print(recordArr.get(rows)[2]); //print out the column of Artist 
					out.println("");
				}
				
			} catch(FileNotFoundException fnfe ){
					fnfe.printStackTrace();
			} catch(IOException ie) {
					ie.printStackTrace();
			} finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(out != null) {
					out.close();
				}
			}
		
	}
	
}