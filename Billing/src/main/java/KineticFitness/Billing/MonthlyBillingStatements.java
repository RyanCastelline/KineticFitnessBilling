package KineticFitness.Billing;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import billingDaos.ClientBillingDao;
import billingVos.StudentBillingVo;

public class MonthlyBillingStatements {
	final private static double DROPIN_FEE = 15;
	final private static String PATH = "C:\\Users\\Ryan\\Documents\\ClassProject\\" +
			"KineticFitness\\Billing\\MonthlyBillingStatement";
	private static ArrayList<StudentBillingVo> studentVoList;
	private static ClientBillingDao billingDao;
	private static File monthlyBillingStatementFile; 
	private static FileWriter fileWriter;
	private static BufferedWriter buffWriter;
	
	public static void main(String[] args) {
		try {
			doMain();
		}
		finally {
			try {
				if(buffWriter != null) {
					buffWriter.close();
				}
				else { throw new IOException(); }
			}
			catch(IOException ioEx) {
				System.err.println("Error attempting to close file stream.");
			}
		}
	}

	private static void doMain() {
		
		studentVoList = new ArrayList<StudentBillingVo>();
		billingDao = new ClientBillingDao();
		
		try {
			billingDao.getClientVoInformation(studentVoList);

			for (StudentBillingVo vos : studentVoList) {
				vos.setExtraClassFee(calculateDropinFee(vos));
			}
			
			setUpFilePath();
			do {
				createBill(studentVoList);
			} while (!studentVoList.isEmpty());
		} 
		catch(SQLException sqlEx) {
			System.err.println("Exception found in ClientBillingDao: " + sqlEx);
		}
		catch(ClassNotFoundException cnfEx) {
			System.err.println("Exception found in ClientBillingDao: " + cnfEx);
		}
		catch(IOException ioEx) {
			System.err.println("Exception found in MonthlyBillingStatements: " + ioEx);
		}
	}
	
	private static void setUpFilePath() throws IOException {
		monthlyBillingStatementFile = new File(PATH);
		fileWriter = new FileWriter(monthlyBillingStatementFile.getAbsoluteFile());
		buffWriter = new BufferedWriter(fileWriter);
	}
	
	private static double calculateDropinFee(StudentBillingVo vo) {
		double dropinFee = 0;
		int totalDropin = ((vo.getClassesTaken()) - vo.getMembershipMaxClasses());
		
		if(totalDropin > 0) {
			dropinFee = (totalDropin * DROPIN_FEE);
		}
		return dropinFee;
	}
	
	private static void createBill(ArrayList<StudentBillingVo> voList) throws IOException{
		for(StudentBillingVo vos : voList) {
			buffWriter.write(vos.toString());
		}
	}	
}
