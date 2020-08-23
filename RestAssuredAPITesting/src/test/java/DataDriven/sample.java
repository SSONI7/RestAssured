package DataDriven;

import java.io.IOException;

public class sample {

	public static void main(String[] args) throws IOException {


		String file = "C:/Users/Saniket/Desktop/DataFile.xslx";
		int rowcount = XlUtils.getRowCount(file, "Sheet1");
		int colcount = XlUtils.getCellCount(file,"Sheet1", 1);
		
		System.out.println("ROw count is :- "+rowcount);
		System.out.println("Cell Count is :- "+colcount);
		
		

	}

}
