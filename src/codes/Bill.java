package codes;

public class Bill {
	private String name;
	private String flatNo;
	private String password;
	
	private double gasBill;
	private double electicityBill;
	private double waterBill;
	private double serviceCharge;
	private double due=0;
	private double totalBill;
	
	
	
	public Bill(String name, String flatNo, String password, double gasBill,
			double electicityBill, double waterBill, double serviceCharge) {
		
		this.name = name;
		this.flatNo = flatNo;
		this.password = password;
		this.gasBill = gasBill;
		this.electicityBill = electicityBill;
		this.waterBill = waterBill;
		this.serviceCharge = serviceCharge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getGasBill() {
		return gasBill;
	}
	public void setGasBill(double gasBill) {
		this.gasBill = gasBill;
	}
	public double getElecticityBill() {
		return electicityBill;
	}
	public void setElecticityBill(double electicityBill) {
		this.electicityBill = electicityBill;
	}
	public double getWaterBill() {
		return waterBill;
	}
	public void setWaterBill(double waterBill) {
		this.waterBill = waterBill;
	}
	public double getDue() {
		return due;
	}
	public void setDue(double pay) {
		due=totalBill-pay;
	}
	public double getTotalBill() {
		totalBill= gasBill+ electicityBill+waterBill+ serviceCharge+due;
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	
	
	public double getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String toString() {
		return "Bill [name=" + name + ", flatNo=" + flatNo + ", password="
				+ password + ", gasBill=" + gasBill + ", electicityBill="
				+ electicityBill + ", waterBill=" + waterBill + ", due=" + due
				+ ", totalBill=" + totalBill + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// For Admin only*********
	
	
	private String adminName="Monzurul";
	private String adminPass= "123456";



	public String getAdminName() {
		return adminName;
	}
	
	public String getAdminPass() {
		return adminPass;
	}
	
	
	
	
	
	
	

}
