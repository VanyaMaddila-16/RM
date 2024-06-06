package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class UsersDto {
    
    private int id;

    private int employeeId;

    private String username;

    private String password;

    private String resetToken;

    private LocalDateTime resetTokenExpiresAt;


    public UsersDto() {
    }

    public UsersDto(int id, int employeeId, String username, String password, String resetToken,
            LocalDateTime resetTokenExpiresAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.resetToken = resetToken;
        this.resetTokenExpiresAt = resetTokenExpiresAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getResetTokenExpiresAt() {
        return resetTokenExpiresAt;
    }

    public void setResetTokenExpiresAt(LocalDateTime resetTokenExpiresAt) {
        this.resetTokenExpiresAt = resetTokenExpiresAt;
    }


    
}
