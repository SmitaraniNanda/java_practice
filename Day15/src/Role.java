enum Role {
    ADMIN(1, true),
    MANAGER(2, true),
    DEVELOPER(3, true),
    GUEST(4, false);

    private final int level;
    private final boolean hasPermissions;

    Role(int level, boolean hasPermissions) {
        this.level = level;
        this.hasPermissions = hasPermissions;
    }

    public int getLevel() {
        return level;
    }

    public boolean hasPermissions() {
        return hasPermissions;
    }

    public void performTask() {
        switch (this) {
            case ADMIN -> System.out.println("ADMIN: Can manage users.");
            case MANAGER -> System.out.println("MANAGER: Can manage projects.");
            case DEVELOPER -> System.out.println("DEVELOPER: Can develop features.");
            case GUEST -> System.out.println("GUEST: Can view public information.");
        }
    }

    public static Role getRoleByLevel(int level) {
        for (Role role : Role.values()) {
            if (role.getLevel() == level) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role found with level: " + level);
    }

    public static void displayAllRoles() {
        for (Role role : Role.values()) {
            System.out.println("Role: " + role + ", Level: " + role.getLevel() + ", Has Permissions: " + role.hasPermissions());
            role.performTask();
        }
    }

    public static void main(String[] args) {
        displayAllRoles();
        System.out.println("Fetching Role by Level 2: " + getRoleByLevel(2));
    }
}
