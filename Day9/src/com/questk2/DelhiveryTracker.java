package com.questk2;

class DeliveryTracker implements User {
    @Override
    public void login() {
        System.out.println("Delivery tracker logged in.");
    }

    @Override
    public void register() {
        System.out.println("Delivery tracker registered successfully.");
    }

    @Override
    public void viewProfile() {
        System.out.println("Viewing delivery tracker profile.");
    }

}
