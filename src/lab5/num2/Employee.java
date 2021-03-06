public class Employee extends Person{
	private double payRate;
	private double hoursWorked;
	private String deparment;
	
	private final int HOURS = 40;
	private final double OVERTIME = 1.5;
	
	//Default constructor
	public Employee(){
		super();
		payRate = 0;
		hoursWorked = 0;
		deparment = "";
	}

	//Alternate constructor 
	public Employee(String firstName, String lastName, double payRate, double hoursWorked, String deparment){
		super.setName(firstName, lastName);
		
		this.payRate = payRate;
		this.hoursWorked = hoursWorked;
		this.deparment = deparment;
	}

	public void setAll(String firstName, String lastName, double payRate, double hoursWorked, String deparment){
		super.setName(firstName, lastName);
		this.payRate = payRate;
		this.hoursWorked = hoursWorked;
		this.deparment = deparment;
	}

	public double getPayRate(){
		return payRate;
	}

	public double getHoursWorked(){
		return hoursWorked;
	}

	public String getDept(){
		return deparment;
	}

	public String toString(){
		return "The wages for " + super.toString() + " from " + this.deparment + " department are " + calculateWage();
	}

	public void print(){
		System.out.print("The employee " );
		super.print();
		System.out.print(" from the " + this.deparment + " worked " + this.hoursWorked 
						+ " with a pay of $" + this.payRate + ". The wages for ");
		super.print();
		System.out.print(" are $" + calculateWage());
	//	System.out.println("The employe " + super.toString() + " from the department " + deparment + " worked " + hoursWorked + " with the pay rate of $" + payRate + "." + " The wages for " + super.print() + " are " + calculateWage());
	}
	
	public double calculateWage(){
		double overTimeHours;
		double totalWage;
		double regularPay;
		double totalOverWage;
		double totalOverTime;

		//overtime
		if(hoursWorked > HOURS){
			overTimeHours = hoursWorked - HOURS;
			totalOverTime = payRate * OVERTIME * overTimeHours;
			totalWage = (payRate * HOURS) + totalOverTime;
		//no overtime
		}else{
			totalWage =  payRate *  HOURS;
		}
		return totalWage;
	}

	public boolean equals(Object obj){
		if(obj instanceof Employee){
			Employee e = (Employee) obj;
			return payRate == (e.payRate) && hoursWorked == (e.hoursWorked) && deparment.equals(e.deparment);
		}else
			return false;
	}

	public Employee getCopy(){
		return new  Employee(super.getLastName(), super.getFirstName(), payRate, hoursWorked, deparment);
	}

	public void copy(Employee e){
		payRate = e.payRate;
		hoursWorked = e.hoursWorked;
		deparment = e.deparment;
	}
}
