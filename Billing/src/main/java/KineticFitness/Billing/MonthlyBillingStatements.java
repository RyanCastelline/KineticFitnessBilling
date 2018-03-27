package KineticFitness.Billing;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import billingDaos.ClientBillingDao;
import billingVos.StudentBillingVo;

public class MonthlyBillingStatements {
	final public static double DROPIN_FEE = 15;
	public static ArrayList<StudentBillingVo> studentVoList;
	public static ClientBillingDao billingDao;
	public static File monthlyBillingStatementFile; 
	
	public static void main(String[] args) {
		try {
			doMain();
		}
		finally {
			try {
				if(monthlyBillingStatementFile != null) {
					monthlyBillingStatementFile.close();
				}
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

			do {
				createBill(studentVoList);
			} while (!studentVoList.isEmpty()); // ToDo: Verify if isEmpty is correct way to iterate through list.
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
			monthlyBillingStatementFile.append(vos.toString());
		}
	}	
}
