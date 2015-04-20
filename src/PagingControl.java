import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class PagingControl {
	public static void main(String[] args) {
		File file=new File("PracticeInput.txt");
		try {
			readFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		
		int C=0;
		int L=0;
		int X=0;
		int dot=0;
		while ((line = br.readLine()) != null) {
			//System.out.println(line);
			
			String inputline[] =line.split(",");
			C=Integer.parseInt(inputline[0]);
			L=Integer.parseInt(inputline[1]);
			X=Integer.parseInt(inputline[2]);
			
			if(C<1 || C>L){
				System.out.println("ERR");
			}
			else{
				//System.out.print(1+" ");
				int startNumber = C-X;
				if(startNumber<1)
					startNumber = 1;
				int tempNumber = startNumber;
				int endNumber = C+X;
				if(endNumber > L)
					endNumber = L;
				if(startNumber!=1)
				{
					if(startNumber == 2)
						System.out.print("1 ");
					else
						System.out.print("1 ... ");
				}
					 
				StringBuilder numberRange = new StringBuilder(Integer.toString(startNumber)+" ");
				while(tempNumber<endNumber)
				{
					
					numberRange.append(Integer.toString(++tempNumber)+" ");
				}
				System.out.print(numberRange);
				for(int i=1;i<L;i++){
					
				}
				if(endNumber!=L)
				{
					if((L-endNumber) != 1)
					{
						System.out.print("... "+L);
					}
				}
				System.out.print("\n");
			
			}
		}
		
	 
		br.close();
	}
}
