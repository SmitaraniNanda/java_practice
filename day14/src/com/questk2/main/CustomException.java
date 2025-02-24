package com.questk2.main;

class CustomException extends Exception {

    /**
     * Constructs a new CustomException with the specified detail message.
     * This exception is used to provide custom error messages in the application.
     *
     * @param message The detail message for this exception, providing more information about the error.
     */
    public CustomException(String message) {
        super(message);
    }
}
