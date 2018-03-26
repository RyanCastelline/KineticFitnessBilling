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
		StudentBillingVo studentVo = null;
		
		try {
			ps = conn.prepareStatement(
					"select" + CLIENT_COLUMNS + "from" + CLIENT_TABLE);
			rs = ps.executeQuery();
			while(rs.next()) {
				studentVo = clientParser(conn, rs, studentVo);
				voList.add(studentVo);
				}
			
			for(StudentBillingVo vos : voList) {
				if(vos.getMembershipTier() > 0) {
					determineMembership(conn, vos);
				}

				if(vos.getPromotionalNumber() > 0) {
					determinePromotionalDiscount(conn, vos);
				}
			}
			
			return voList;
		}
		finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
	
	private StudentBillingVo clientParser(Connection conn, ResultSet rs, 
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
	
	private StudentBillingVo determineMembership(Connection conn, StudentBillingVo vo) throws SQLException {
		int membershipTier = vo.getMembershipTier();
		
		ps = conn.prepareStatement("select" + MEMBERSHIP_COLUMNS + "from" + MEMBERSHIP_TABLE + "where "
				+ "MEMBERSHIP_TIER = " + membershipTier);
		rs = ps.executeQuery();

		vo.setMembershipTierName(rs.getString("NAME"));
		vo.setMembershipBaseFee(rs.getDouble("PRICE"));
		vo.setMembershipMaxClasses(rs.getInt("CLASSES_PER_MONTH"));

		return vo;
	}
	
	private StudentBillingVo determinePromotionalDiscount(Connection conn, StudentBillingVo vo) throws SQLException {
		int promoTier = vo.getPromotionalNumber();
		
		ps = conn.prepareStatement("select" + PROMOTIONS_COLUMNS + "from" + PROMOTIONS_TABLE + "where "
				+ "MEMBERSHIP_TIER = " + promoTier);
		rs = ps.executeQuery();

		vo.setPromotionalName(rs.getString("NAME"));
		vo.setPromotionalDiscount(rs.getDouble("PERCENT_DISCOUNT"));
		vo.setCostAfterPromoDiscount((vo.getMembershipBaseFee()) * (vo.getPromotionalDiscount()));

		return vo;
	}
}
