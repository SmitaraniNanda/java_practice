package com.questk2.main;

public class Department {
    private Integer deptId;
    private String deptName;

    /**
     * Constructs a Department object with the specified department ID and name.
     *
     * @param deptId   The ID of the department.
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
     * Sets the ID of the department.
     *
     * @param deptId The new department ID.
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
     * Sets the name of the department.
     *
     * @param deptName The new department name.
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * Returns a string representation of the Department object, including the
     * department ID and name.
     *
     * @return A string representing the department's details.
     */
    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
