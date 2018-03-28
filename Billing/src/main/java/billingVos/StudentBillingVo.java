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
	private double totalBilled;
	
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

	public double getTotalBilled() {
		return totalBilled;
	}
	public void setTotalBilled(double totalBilled) {
		this.totalBilled = totalBilled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + classesTaken;
		result = prime * result + clientNumber;
		long temp;
		temp = Double.doubleToLongBits(costAfterPromoDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(extraClassFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		temp = Double.doubleToLongBits(membershipBaseFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + membershipMaxClasses;
		result = prime * result + membershipTier;
		result = prime * result + ((membershipTierName == null) ? 0 : membershipTierName.hashCode());
		temp = Double.doubleToLongBits(promotionalDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((promotionalName == null) ? 0 : promotionalName.hashCode());
		result = prime * result + promotionalNumber;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
		result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
		temp = Double.doubleToLongBits(totalBilled);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentBillingVo other = (StudentBillingVo) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (classesTaken != other.classesTaken)
			return false;
		if (clientNumber != other.clientNumber)
			return false;
		if (Double.doubleToLongBits(costAfterPromoDiscount) != Double.doubleToLongBits(other.costAfterPromoDiscount))
			return false;
		if (Double.doubleToLongBits(extraClassFee) != Double.doubleToLongBits(other.extraClassFee))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(membershipBaseFee) != Double.doubleToLongBits(other.membershipBaseFee))
			return false;
		if (membershipMaxClasses != other.membershipMaxClasses)
			return false;
		if (membershipTier != other.membershipTier)
			return false;
		if (membershipTierName == null) {
			if (other.membershipTierName != null)
				return false;
		} else if (!membershipTierName.equals(other.membershipTierName))
			return false;
		if (Double.doubleToLongBits(promotionalDiscount) != Double.doubleToLongBits(other.promotionalDiscount))
			return false;
		if (promotionalName == null) {
			if (other.promotionalName != null)
				return false;
		} else if (!promotionalName.equals(other.promotionalName))
			return false;
		if (promotionalNumber != other.promotionalNumber)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street1 == null) {
			if (other.street1 != null)
				return false;
		} else if (!street1.equals(other.street1))
			return false;
		if (street2 == null) {
			if (other.street2 != null)
				return false;
		} else if (!street2.equals(other.street2))
			return false;
		if (Double.doubleToLongBits(totalBilled) != Double.doubleToLongBits(other.totalBilled))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() { //ToDo: Format toString to look like a bill.
		String toString = "";
		
		toString = String.format("%s%d%20s%n", "Client number: ", clientNumber, firstName + " " + lastName);
		if(street2 != null) {
			toString += String.format("%s%n%s,%2s %s%n%n", street1 + " " + street2, city, state, zip);
		} else {
			toString += String.format("%s%n%s,%2s %s%n%n", street1 + ",", city + ",", state, zip);
		}
		toString += String.format("%s%n%s%6.2f%20s%2d%n%n", membershipTierName, "Membership Fee: ",
				membershipBaseFee, "Max Classes: ", membershipMaxClasses);
		if(promotionalNumber != 0) {
			toString += String.format("%s%s%n%s%4.2f%s%n%s%6.2f%n%n", "Promotion: ", promotionalName, 
				"Discount: ", promotionalDiscount, " off!", "Membership fee after discount: ", 
				costAfterPromoDiscount);
		}
		toString += String.format("%s%2d%n%s%6.2f%n%s%n%n", "Total classes taken: ", classesTaken,
				"Extra class fee: ", extraClassFee, "Cost is $15.00 per class above max classes in your membership.");
		if(promotionalNumber != 0) {
			toString += String.format("%s%n%-20s%6.2f%n%-20s%6.2f%n%-20s%6.2f%n%n", "Summary of bill:",
					"Fee after discount: ", costAfterPromoDiscount, "Extra class fee: ", extraClassFee,
					"Total due: ", totalBilled);
		} else {
			toString += String.format("%s%n%-20s%6.2f%n%-20s%6.2f%n%-20s%6.2f%n%n", "Summary of bill:",
					"Membership fee: ", membershipBaseFee, "Extra class fee: ", extraClassFee,
					"Total due: ", totalBilled);
		}
		toString += String.format("%s%n%n", "------------------------------");
		
		return toString;
	}

}
