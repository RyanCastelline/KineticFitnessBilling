package KineticFitness.Billing;
import java.util.ArrayList;
import billingVos.StudentBillingVo;

public class MonthlyBillingStatements {
	public ArrayList<StudentBillingVo> studentVo;
	public int classesTakenMinusMembershipMaxClasses;
	//public File monthlyBillingStatementFile; //Commented out until I learn to properly use
	//files in code.
	
	private void initialize() {
		studentVo = new ArrayList<StudentBillingVo>();
		classesTakenMinusMembershipMaxClasses = 0;
	}
	
	//ToDo: determine how to properly call getter methods. Most likely doesn't like that
	//studentVo is an ArrayList and will need to call on the individual objects' methods.
	public void doMain() {
		try {
			initialize();
			if(studentVo.getPromotionalNumber() > 0) {
				calculatePromo(studentVo.getPromotionalNumber());
			}
			classesTakenMinusMembershipMaxClasses = (studentVo.getClassesTaken() - 
					studentVo.getMembershipMaxClasses());
			if(classesTakenMinusMembershipMaxClasses > 0) {
				calculateDropinFee(classesTakenMinusMembershipMaxClasses,
						studentVo.getExtraClassFee());
			}
			do {
				createBill(studentVo.toString());
			} while (!studentVo.isEmpty()); //ToDo: Verify if isEmpty is correct way to iterate through list.
			do {
				setClassesTakenToZero();
			} while (!studentVo.isEmpty()); //ToDo: Verify if isEmpty is correct way to iterate through list.
		} catch(Exception e) {
			System.out.println(e);
		}
		
		finally {
			//monthlyBillingStatementFile.close(); //Commented out until I learn to properly
			//use files in code.
		}
		
	}
	
	private double calculatePromo(int promoNumber) { //ToDo: determine exception to throw
		final int NEW_STUDENT = 1;
		final int REFERRAL = 2;
		double discountPercent = 0;
		
		if (promoNumber == NEW_STUDENT) {
			discountPercent = 0.25; //ToDo: use DAO to draw this from the database.
		}
		
		else if(promoNumber == REFERRAL){
			discountPercent = 0.25; //ToDo: use DAO to draw this from the database.
		}
		//else {throw "Error: Invalid promotional number : " + promoNumber}
		return discountPercent;
	}
	
	private double calculateDropinFee(int totalDropin, double dropinFee) {
		return (totalDropin * dropinFee);
	}
	
	private static void createBill(String voToString) {
		/**
		 * This section will need to append each Vo's toString to the end of the monthly bill
		 * file. Unsure how to do this and I'll need to research how to properly do so later
		 * in the project.
		 */
		//monthlyBillingStatementFile.append(voToString);
	}
	
	private static void setClassesTakenToZero() {
		/**
		 * Since the bill is run at the end of the month, it can also be used to set the
		 * monthly counter for total classes taken to zero in the database. This will be
		 * completed after learning how to properly change information on a database.
		 */
	}
	
}
