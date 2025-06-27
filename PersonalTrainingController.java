package com.nuvia.backend.controller;
import com.nuvia.backend.dto.PersonalTrainingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonalTrainingController {

    @PostMapping("/personal-training")
    public ResponseEntity<?> submitPersonalTraining(@Valid @RequestBody PersonalTrainingRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
            });
            return ResponseEntity.badRequest().body(new ErrorResponse(errors.toString()));
        }

        // TODO: Here you could add storing the personal training data or sending emails, etc.
        String message = String.format("Thank you, %s! Your personal training request has been received. We will contact you soon at %s or %s.",
                request.getName(),
                request.getContactNumber(),
                request.getWhatsappNumber());

        return ResponseEntity.ok(new SuccessResponse(message));
    }

    static class SuccessResponse {
        private String message;
        public SuccessResponse(String message) { this.message = message; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    static class ErrorResponse {
        private String error;
        public ErrorResponse(String error) { this.error = error; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
    }
}
