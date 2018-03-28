package billingDaos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import billingVos.StudentBillingVo;

public class MockClientBillingDao implements IClientBillingDao {
	
	public ArrayList<StudentBillingVo> getClientVoInformation() throws Exception {
		StudentBillingVo vo1 = null;
		StudentBillingVo vo2 = null;
		StudentBillingVo vo3 = null;
		ArrayList<StudentBillingVo> voList = new ArrayList<StudentBillingVo>();
		
		voList.add(vo1);
		voList.add(vo2);
		voList.add(vo3);
		
		return voList;
	}
	
	private StudentBillingVo clientParser(Connection conn, ResultSet rs, StudentBillingVo vo) throws SQLException {
		vo.setClientNumber(0);
		vo.setLastName("Doe");
		vo.setFirstName("John");
		vo.setStreet1("123 Main St");
		vo.setStreet2("Apt 1");
		vo.setCity("Albany");
		vo.setState("NY");
		vo.setZip("11111");
		vo.setMembershipTier(1);
		vo.setPromotionalNumber(0);
		vo.setClassesTaken(4);
		
		return vo;
	}

}
