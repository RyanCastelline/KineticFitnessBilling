package KineticFitness.Billing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import billingDaos.ClientBillingDao;
import billingVos.StudentBillingVo;

public class MonthlyBillingStatements {
	final private static double DROPIN_FEE = 15;
	final private static String PATH = "C:\\Users\\Ryan C\\Documents\\ClassProject\\"
			+ "KineticFitness\\Billing\\MonthlyBillingStatement";
	private static ArrayList<StudentBillingVo> studentVoList;
	private static ClientBillingDao billingDao;
	private static File monthlyBillingStatementFile;
	private static FileWriter fileWriter;
	private static BufferedWriter buffWriter;
	private static PrintWriter out;

	public static void main(String[] args) {
		try {
			doMain();
		} finally {
			try {
				if (buffWriter != null) {
					buffWriter.close();
					System.out.println("Billing statement created.");
				}
			} catch (IOException ioEx) {
				System.err.println("Error attempting to close file stream.");
			}
		}
	}

	private static void doMain() {

		studentVoList = new ArrayList<StudentBillingVo>();
		billingDao = new ClientBillingDao();

		try {
			studentVoList = billingDao.getClientVoInformation();
			System.out.println("Size of array list is: " + studentVoList.size());

			for (StudentBillingVo vos : studentVoList) {
				vos.setExtraClassFee(calculateDropinFee(vos));
			}

			setUpFilePath();
			for (StudentBillingVo vos : studentVoList) {
				createBill(vos);
			}
		} catch (SQLException sqlEx) {
			System.err.println("Exception found in ClientBillingDao: " + sqlEx);
		} catch (ClassNotFoundException cnfEx) {
			System.err.println("Exception found in ClientBillingDao: " + cnfEx);
		} catch (IOException ioEx) {
			System.err.println("Exception found in MonthlyBillingStatements: " + ioEx);
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}

	private static void setUpFilePath() throws IOException {
		monthlyBillingStatementFile = new File(PATH);
		fileWriter = new FileWriter(monthlyBillingStatementFile, true);
		buffWriter = new BufferedWriter(fileWriter);
		out = new PrintWriter(buffWriter);
	}

	private static double calculateDropinFee(StudentBillingVo vo) {
		double dropinFee = 0;
		int totalDropin = ((vo.getClassesTaken()) - vo.getMembershipMaxClasses());

		if (totalDropin > 0) {
			dropinFee = (totalDropin * DROPIN_FEE);
		}
		return dropinFee;
	}

	private static void createBill(StudentBillingVo vos) throws IOException {

		out.write(vos.toString());
	}
}
