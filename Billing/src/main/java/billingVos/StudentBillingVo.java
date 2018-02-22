package billingVos;

public class StudentBillingVo {
	
	private int clientNumber;
	private String lastName;
	private String firstName;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private int membershipTier;
	private String membershipTierName;
	private double membershipBaseFee;
	private int membershipMaxClasses;
	private int promotionalNumber;
	private String promotionalName;
	private double promotionalDiscount;
	private double costAfterPromoDiscount;
	private int classesTaken;
	private double extraClassFee;
	
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getMembershipTier() {
		return membershipTier;
	}
	public void setMembershipTier(int membershipTier) {
		this.membershipTier = membershipTier;
	}
	public String getMembershipTierName() {
		return membershipTierName;
	}
	public void setMembershipTierName(String membershipTierName) {
		this.membershipTierName = membershipTierName;
	}
	public double getMembershipBaseFee() {
		return membershipBaseFee;
	}
	public void setMembershipBaseFee(double membershipBaseFee) {
		this.membershipBaseFee = membershipBaseFee;
	}
	public int getMembershipMaxClasses() {
		return membershipMaxClasses;
	}
	public void setMembershipMaxClasses(int membershipMaxClasses) {
		this.membershipMaxClasses = membershipMaxClasses;
	}
	public int getPromotionalNumber() {
		return promotionalNumber;
	}
	public void setPromotionalNumber(int promotionalNumber) {
		this.promotionalNumber = promotionalNumber;
	}
	public String getPromotionalName() {
		return promotionalName;
	}
	public void setPromotionalName(String promotionalName) {
		this.promotionalName = promotionalName;
	}
	public double getPromotionalDiscount() {
		return promotionalDiscount;
	}
	public void setPromotionalDiscount(double promotionalDiscount) {
		this.promotionalDiscount = promotionalDiscount;
	}
	public double getCostAfterPromoDiscount() {
		return costAfterPromoDiscount;
	}
	public void setCostAfterPromoDiscount(double costAfterPromoDiscount) {
		this.costAfterPromoDiscount = costAfterPromoDiscount;
	}
	public int getClassesTaken() {
		return classesTaken;
	}
	public void setClassesTaken(int classesTaken) {
		this.classesTaken = classesTaken;
	}
	public double getExtraClassFee() {
		return extraClassFee;
	}
	public void setExtraClassFee(double extraClassFee) {
		this.extraClassFee = extraClassFee;
	}

	@Override
	public String toString() { //ToDo: Format toString to look like a bill.
		return "StudentBillingVo [clientNumber=" + clientNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", membershipTier=" + membershipTier + ", membershipTierName=" + membershipTierName
				+ ", membershipBaseFee=" + membershipBaseFee + ", membershipMaxClasses=" + membershipMaxClasses
				+ ", promotionalNumber=" + promotionalNumber + ", promotionalName=" + promotionalName
				+ ", promotionalDiscount=" + promotionalDiscount + ", costAfterPromoDiscount=" + costAfterPromoDiscount
				+ ", classesTaken=" + classesTaken + ", extraClassFee=" + extraClassFee + "]";
	}

}
