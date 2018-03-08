package billingDaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import billingVos.StudentBillingVo;
import java.util.ArrayList;

public class ClientBillingDao implements IClientBillingDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private final static String CLIENT_TABLE = " CLIENT ";
	private final static String CLIENT_COLUMNS = " CLIENT_NUMBER, LAST_NAME, FIRST_NAME, STREET1, STREET2," +
			" CITY, STATE, ZIP, MEMBERSHIP_TIER, PROMOTIONAL_NUMBER, CLASSES_TAKEN ";
	
	private final static String MEMBERSHIP_TABLE = " MEMBERSHIP ";
	private final static String MEMBERSHIP_COLUMNS = " NAME, PRICE, CLASSES_PER_MONTH ";
	
	private final static String PROMOTIONS_TABLE = " PROMOTIONS ";
	private final static String PROMOTIONS_COLUMNS = " NAME, PERCENT_DISCOUNT ";
	
	public ArrayList<StudentBillingVo> getClientVoInformation(ArrayList<StudentBillingVo> voList) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kinetic_fitness?autoReconnect=true&useSSL=false",
				"root",	"");
		ps = conn.prepareStatement(
				"select" + CLIENT_COLUMNS + "from" + CLIENT_TABLE);
		rs = ps.executeQuery();
		
		try {
			while(rs.next()) {
				StudentBillingVo studentVo = null;
				
				studentVo = clientParser(conn, rs, studentVo);
				voList.add(studentVo);
				}
			
			return voList;
		}
		finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
	
	public StudentBillingVo clientParser(Connection conn, ResultSet rs, 
			StudentBillingVo vo) throws SQLException {
		
		vo.setClientNumber(rs.getInt("CLIENT_NUMBER"));
		if(rs.getString("LAST_NAME") != null) {
			vo.setLastName(rs.getString("LAST_NAME"));
		}
		if(rs.getString("FIRST_NAME") != null) {
			vo.setFirstName(rs.getString("FIRST_NAME"));
		}
		if(rs.getString("STREET1") != null) {
			vo.setStreet1(rs.getString("STREET1"));
		}
		if(rs.getString("STREET2") != null) {
			vo.setStreet2(rs.getString("STREET2"));
		}
		if(rs.getString("CITY") != null) {
			vo.setCity(rs.getString("CITY"));
		}
		if(rs.getString("STATE") != null) {
			vo.setState(rs.getString("STATE"));
		}
		if(rs.getString("ZIP") != null) {
			vo.setZip(rs.getString("ZIP"));
		}
		vo.setMembershipTier(rs.getInt("MEMBERSHIP_TIER"));
		vo.setPromotionalNumber(rs.getInt("PROMOTIONAL_NUMBER"));
		vo.setClassesTaken(rs.getInt("CLASSES_TAKEN"));
		
		return vo;
	}
}
