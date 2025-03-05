package com.questk2.main;

//Manager Class (Subclass of Employee)
class Manager extends Employee {
	private int teamSize;

	/**
	 * Constructor for Manager class
	 * 
	 * @param id         Employee ID
	 * @param name       Employee Name
	 * @param age        Employee Age
	 * @param salary     Employee Salary
	 * @param department Employee Department
	 * @param teamSize   Size of the team managed
	 * @throws Exception
	 */
	public Manager(Integer id, String name, Integer age, Double salary, String department, Integer teamSize)
			throws Exception {
		super(id, name, age, salary, department);
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return super.toString() + ", Team Size: " + teamSize;
	}
}