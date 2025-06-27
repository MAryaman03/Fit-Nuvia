package com.nuvia.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PersonalTrainingRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "\\+?\\d{7,15}", message = "Contact number invalid")
    private String contactNumber;

    @NotBlank(message = "WhatsApp number is mandatory")
    @Pattern(regexp = "\\+?\\d{7,15}", message = "WhatsApp number invalid")
    private String whatsappNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email invalid")
    private String email;

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getWhatsappNumber() { return whatsappNumber; }
    public void setWhatsappNumber(String whatsappNumber) { this.whatsappNumber = whatsappNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
