package billingDaos;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import billingVos.StudentBillingVo;

public class MockClientBillingDaoTest {

	MockClientBillingDao dao;
	
	@Test
	public void testGetClientInformation() throws Exception {
		dao = new MockClientBillingDao();
		ArrayList<StudentBillingVo> voList = new ArrayList<StudentBillingVo>();
		
		voList = dao.getClientVoInformation(voList);
		assertEquals(voList.size(), 3); //Mock adds 3 Vos to the list. Logic in the real code simply adds
		//and populates Vos.
	}
	
	@Test
	public void testClientParser() throws SQLException {
		dao = new MockClientBillingDao();
		StudentBillingVo vo = new StudentBillingVo();
		Connection conn = null;
		ResultSet rs = null;
		
		vo = dao.clientParser(conn, rs, vo);
		
		assertEquals(1, vo.getClientNumber());
		assertEquals("Doe", vo.getLastName());
		assertEquals("John", vo.getFirstName());
		assertEquals("123 Main St", vo.getStreet1());
		assertEquals("Apt 1", vo.getStreet2());
		assertEquals("Albany", vo.getCity());
		assertEquals("NY", vo.getState());
		assertEquals("11111", vo.getZip());
		assertEquals(1, vo.getMembershipTier());
		assertEquals(0, vo.getPromotionalNumber());
		assertEquals(4, vo.getClassesTaken());
	}

}
