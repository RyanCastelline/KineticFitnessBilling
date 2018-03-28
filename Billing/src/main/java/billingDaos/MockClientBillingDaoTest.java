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
		
		voList = dao.getClientVoInformation();
		assertEquals(voList.size(), 3); //Mock adds 3 Vos to the list. Logic in the real code simply adds
		//and populates Vos.
	}
}
