package FileTools;
import java.io.File;


/**
 * check class
 * contains 3 functions: <br>
 * FileCheck- take only CSV files from given folder <br>
 * emptyLine- checks whether a CSV file is OK <br>
 * CheckTimeForWEB- check if time is in a valid format
 * 
 */
public class Checks {

	/**
	 * 
	 * @param file array contains files names
	 * @return new file array contains only csv files
	 */
	public static File[] FileCheck(File[] listOfFiles){
		File[] listOfFilesCSV= new File[listOfFiles.length];
		int position=0;
		for(int i=0; i<listOfFiles.length; i++){
			if(listOfFiles[i].getPath().contains("csv")){
				listOfFilesCSV[position]=listOfFiles[i];
				position++;
			}
		}
		
		return listOfFilesCSV;
	}
	
	
	/**
	 * 
	 * @param string matrix named data
	 * the function checks if file contains empty line
	 * @return true if the file is ok or false if the file contains empty line==not proper
	 */
	public  static boolean emptyLine(String [][] data){
		boolean answer= true;
		for(int i=1; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
				if (data[i][j]==null){
					return answer=false;
				}
			}
		}
		return answer;
	}

	/**
	 * The function get string contains date and check his format,
	 * if it's not in the wanted format->change it to it.
	 * @param time1- String contains time
	 * @return fixing time stored in a String
	 */
	public static String CheckTimeForWEB(String time1){
		time1=time1.replace('-', '/'); //replact - to /
		String[] FixTime=time1.split(" ");
		String time= "";
		String[] FixDate=FixTime[0].split("/");
		if(FixDate[0].length()==4){
			time+= FixDate[2]+"/"+FixDate[1]+"/"+FixDate[0]+" "+FixTime[1];
			return time;
		}

		else
			time+= FixDate[0]+"/"+FixDate[1]+"/"+FixDate[2]+" "+FixTime[1];
		return time;
	}





}
