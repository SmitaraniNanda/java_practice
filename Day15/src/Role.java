enum Role {
    ADMIN(1, true),
    MANAGER(2, true),
    DEVELOPER(3, true),
    GUEST(4, false);

    private final int accessLevel;
    private final boolean hasAccessPermissions;

    /**
     * Constructor to initialize the role with its access level and permissions.
     *
     * @param accessLevel         The hierarchical level of the role.
     * @param hasAccessPermissions Boolean indicating if the role has special permissions.
     */
    Role(int accessLevel, boolean hasAccessPermissions) {
        this.accessLevel = accessLevel;
        this.hasAccessPermissions = hasAccessPermissions;
    }

    /**
     * Retrieves the access level of the role.
     *
     * @return The access level of the role.
     */
    public int getAccessLevel() {
        return accessLevel;
    }

    /**
     * Checks if the role has special access permissions.
     *
     * @return True if the role has permissions, false otherwise.
     */
    public boolean hasAccessPermissions() {
        return hasAccessPermissions;
    }

    /**
     * Performs a task specific to the role.
     */
    public void executeRoleTask() {
        switch (this) {
            case ADMIN -> System.out.println("ADMIN: Can manage users.");
            case MANAGER -> System.out.println("MANAGER: Can manage projects.");
            case DEVELOPER -> System.out.println("DEVELOPER: Can develop features.");
            case GUEST -> System.out.println("GUEST: Can view public information.");
        }
    }

    /**
     * Retrieves the role based on the provided access level.
     *
     * @param accessLevel The access level of the role to be fetched.
     * @return The corresponding Role enum.
     * @throws IllegalArgumentException If no role is found with the given level.
     */
    public static Role getRoleByAccessLevel(int accessLevel) {
        for (Role role : Role.values()) {
            if (role.getAccessLevel() == accessLevel) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role found with access level: " + accessLevel);
    }

    /**
     * Displays all roles along with their details and executes their respective tasks.
     */
    public static void displayAllRoles() {
        for (Role role : Role.values()) {
            System.out.println("Role: " + role + ", Access Level: " + role.getAccessLevel() + ", Has Permissions: " + role.hasAccessPermissions());
            role.executeRoleTask();
        }
    }

    public static void main(String[] args) {
        displayAllRoles();
        System.out.println("Fetching Role by Access Level 2: " + getRoleByAccessLevel(2));
    }
}
