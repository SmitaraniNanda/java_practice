package com.questk2.main;


	public class Manager extends Employee {
	    private Integer teamSize;

	    public Manager(Integer id, String name, Integer age, Double salary, String department, Integer teamSize) throws InvalidAgeException, LowSalaryException {
	        super(id, name, age, salary, department);
	        this.teamSize = teamSize;
	    }

	    public Integer getTeamSize() {
	    	return teamSize; 
	    	}

	    public void setTeamSize(int teamSize) {
	    	this.teamSize = teamSize; 
	    	}

		@Override
		public String toString() {
			return "Manager [teamSize=" + teamSize + "]";
		}

	   
	

}
