package billingDaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import billingVos.StudentBillingVo;

public class ClientBillingDao implements IClientBillingDao {

	private Connection conn;
	private PreparedStatement statement;
	private ResultSet rs;

	private final static String CLIENT_TABLE = " CLIENT ";
	private final static String CLIENT_COLUMNS = " CLIENT_NUMBER, LAST_NAME, FIRST_NAME, STREET1, STREET2,"
			+ " CITY, STATE, ZIP, MEMBERSHIP_TIER, PROMOTIONAL_NUMBER, CLASSES_TAKEN ";

	private final static String MEMBERSHIP_TABLE = " MEMBERSHIP ";
	private final static String MEMBERSHIP_COLUMNS = " NAME, PRICE, CLASSES_PER_MONTH ";

	private final static String PROMOTIONS_TABLE = " PROMOTIONS ";
	private final static String PROMOTIONS_COLUMNS = " NAME, PERCENT_DISCOUNT ";

	public ArrayList<StudentBillingVo> getClientVoInformation() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/kinetic_fitness?autoReconnect=true&useSSL=false", "root", "Caste-dude1");
		statement = conn.prepareStatement("select" + CLIENT_COLUMNS + "from" + CLIENT_TABLE
				+ "order by CLIENT_NUMBER");
		ResultSet rs = statement.executeQuery();

		ArrayList<StudentBillingVo> voList = new ArrayList<StudentBillingVo>();

		try {
			voList = clientParser(rs);

			for (StudentBillingVo vos : voList) {
				if (vos.getMembershipTier() > 0) {
					determineMembership(conn, vos);
				}

				if (vos.getPromotionalNumber() > 0) {
					determinePromotionalDiscount(conn, vos);
				}
			}
			return voList;
		} catch (SQLException sqlEx) {
			throw sqlEx;
		} finally {
			rs.close();
			statement.close();
			conn.close();
		}
	}

	private ArrayList<StudentBillingVo> clientParser(ResultSet rs) throws SQLException {

		ArrayList<StudentBillingVo> list = new ArrayList<StudentBillingVo>();
		
		while (rs.next()) {
			StudentBillingVo vo = new StudentBillingVo();
			
			vo.setClientNumber(rs.getInt("CLIENT_NUMBER"));
			if (rs.getString("LAST_NAME") != null) {
				vo.setLastName(rs.getString("LAST_NAME"));
			}
			if (rs.getString("FIRST_NAME") != null) {
				vo.setFirstName(rs.getString("FIRST_NAME"));
			}
			if (rs.getString("STREET1") != null) {
				vo.setStreet1(rs.getString("STREET1"));
			}
			if (rs.getString("STREET2") != null) {
				vo.setStreet2(rs.getString("STREET2"));
			}
			if (rs.getString("CITY") != null) {
				vo.setCity(rs.getString("CITY"));
			}
			if (rs.getString("STATE") != null) {
				vo.setState(rs.getString("STATE"));
			}
			if (rs.getString("ZIP") != null) {
				vo.setZip(rs.getString("ZIP"));
			}
			vo.setMembershipTier(rs.getInt("MEMBERSHIP_TIER"));
			vo.setPromotionalNumber(rs.getInt("PROMOTIONAL_NUMBER"));
			vo.setClassesTaken(rs.getInt("CLASSES_TAKEN"));

			list.add(vo);
		}
		return list;
	}

	private void determineMembership(Connection conn, StudentBillingVo vo) throws SQLException {
		int membershipTier = vo.getMembershipTier();

		statement = conn.prepareStatement("select" + MEMBERSHIP_COLUMNS + "from" + MEMBERSHIP_TABLE + "where "
				+ "MEMBERSHIP_TIER = " + membershipTier);
		rs = statement.executeQuery();
		rs.next();

		vo.setMembershipTierName(rs.getString("NAME"));
		vo.setMembershipBaseFee(rs.getDouble("PRICE"));
		vo.setMembershipMaxClasses(rs.getInt("CLASSES_PER_MONTH"));
	}

	private void determinePromotionalDiscount(Connection conn, StudentBillingVo vo) throws SQLException {
		int promoTier = vo.getPromotionalNumber();

		statement = conn.prepareStatement("select" + PROMOTIONS_COLUMNS + "from" + PROMOTIONS_TABLE + "where "
				+ "PROMOTIONAL_NUMBER = " + promoTier);
		rs = statement.executeQuery();
		rs.next();

		vo.setPromotionalName(rs.getString("NAME"));
		vo.setPromotionalDiscount(rs.getDouble("PERCENT_DISCOUNT"));
		vo.setCostAfterPromoDiscount((vo.getMembershipBaseFee())-((vo.getMembershipBaseFee()) * (vo.getPromotionalDiscount())));
	}
}
