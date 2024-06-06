package com.imaginnovate.Entities;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    public String username;

    @Column(name = "password", nullable = false, length = 12)
    public String password;

    @Column(name = "reset_token", nullable = false, length = 10)
    public String resetToken;

    @Column(name = "reset_token_expires_at")
    public LocalDateTime resetTokenExpiresAt;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    public Employees employeeId;

    public Users() {
    }

    public Users(int id,  String username, String password, String resetToken,
            LocalDateTime resetTokenExpiresAt, Employees employeeId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.resetToken = resetToken;
        this.resetTokenExpiresAt = resetTokenExpiresAt;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "Users [id=" + id + ", employeeId=" + employeeId + ", username=" + username + ", password=" + password
                + ", resetToken=" + resetToken + ", resetTokenExpiresAt=" + resetTokenExpiresAt + ", employeeId="
                + employeeId + "]";
    }

    
   
}

