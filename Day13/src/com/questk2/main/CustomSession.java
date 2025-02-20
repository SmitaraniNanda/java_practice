package com.questk2.main;

/**
 * Represents a custom session with a name, preference, and status.
 */
public class CustomSession {
    private String name;
    private String preference;
    private String status;

    /**
     * Constructs a new CustomSession with the given name, preference, and status.
     *
     * @param name       the name of the session
     * @param preference the preference associated with the session
     * @param status     the status of the session
     */
    public CustomSession(String name, String preference, String status) {
        this.setName(name);
        this.setPreference(preference);
        this.setStatus(status);
    }

    /**
     * Returns a string representation of the session.
     *
     * @return a formatted string containing session details
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Preference: " + preference + ", Status: " + status;
    }

    /**
     * Sets the preference for the session.
     *
     * @param preference the new preference to set
     */
    public void setPreference(String preference) {
        this.preference = preference;
    }

    /**
     * Sets the name of the session.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the status of the session.
     *
     * @param status the new status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
