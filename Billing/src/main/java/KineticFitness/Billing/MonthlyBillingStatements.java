package KineticFitness.Billing;
import java.awt.List;
import java.util.ArrayList;

import billingDaos.ClientBillingDao;
import billingVos.StudentBillingVo;

public class MonthlyBillingStatements {
	final public static double DROPIN_FEE = 15;
	public static ArrayList<StudentBillingVo> studentVoList;
	public static ClientBillingDao billingDao;
	//public File monthlyBillingStatementFile; //Commented out until I learn to properly use
	//files in code.
	
	public static void main(String[] args) {
		try {
			doMain();
		}
		catch(Exception e) {
			System.out.println("Error found in main: " + e);
		}

	}
	
	//ToDo: determine how to properly call getter methods. Most likely doesn't like that
	//studentVo is an ArrayList and will need to call on the individual objects' methods.
	private static void doMain() throws Exception {
		
		studentVoList = new ArrayList<StudentBillingVo>();
		billingDao = new ClientBillingDao();
		
		try {
			billingDao.getClientVoInformation(studentVoList);
			
			for (StudentBillingVo vos : studentVoList) {
				vos.setExtraClassFee(calculateDropinFee(vos));
			}

			do {
				createBill(studentVoList.toString());
			} while (!studentVoList.isEmpty()); //ToDo: Verify if isEmpty is correct way to iterate through list.
		} catch(Exception e) {
			throw e;
		}
		
		finally {
			//monthlyBillingStatementFile.close(); //Commented out until I learn to properly
			//use files in code.
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
	
	private static void createBill(String voToString) {
		/**
		 * This section will need to append each Vo's toString to the end of the monthly bill
		 * file. Unsure how to do this and I'll need to research how to properly do so later
		 * in the project.
		 */
		//monthlyBillingStatementFile.append(voToString);
	}	
}
