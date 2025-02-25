package com.questk2.main;

public class Department {
    private Integer deptId;
    private String deptName;

    /**
     * Constructs a Department object with the specified department ID and name.
     * 
     * @param deptId The ID of the department.
     * @param deptName The name of the department.
     */
    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    /**
     * Gets the ID of the department.
     * 
     * @return The department ID.
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * Gets the name of the department.
     * 
     * @return The department name.
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Returns a string representation of the Department object, including the department ID and name.
     * 
     * @return A string representing the department's ID and name.
     */
    @Override
    public String toString() {
        return "Department{" + "deptId=" + deptId + ", deptName='" + deptName + "'}";
    }
}
