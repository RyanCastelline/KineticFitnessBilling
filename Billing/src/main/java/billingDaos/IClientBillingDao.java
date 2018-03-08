package billingDaos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import billingVos.StudentBillingVo;

public interface IClientBillingDao {
	
	public ArrayList<StudentBillingVo> getClientVoInformation(ArrayList<StudentBillingVo> voList) throws Exception;
	
	public StudentBillingVo clientParser(Connection conn, ResultSet rs, StudentBillingVo vo) throws SQLException;

}
