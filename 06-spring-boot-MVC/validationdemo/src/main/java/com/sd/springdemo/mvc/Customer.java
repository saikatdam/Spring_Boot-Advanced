package com.sd.springdemo.mvc;

import com.sd.springdemo.mvc.validation.MakeItValid;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "Its Required")
    @Size(min = 1,message = "Its required also")
    private String lastName="";
    @Min(value = 0,message = "The number of Ticket must be more than 0")
    @Max(value = 5,message = "Request Rejected:More than 5 is not Allowed")
    private int freeTicket;

    public String getMakeItWork() {
        return makeItWork;
    }

    public void setMakeItWork(String makeItWork) {
        this.makeItWork = makeItWork;
    }

    @MakeItValid(value = "sd",message = "You have to begin with sd")
    private String makeItWork;
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Pattern(regexp = "^[a-bA-Z0-9]{3}",message = "Only 3 Characters/digits")

    private String postalCode;
    public int getFreeTicket() {
        return freeTicket;

    }

    public void setFreeTicket(int freeTicket) {
        this.freeTicket = freeTicket;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}
