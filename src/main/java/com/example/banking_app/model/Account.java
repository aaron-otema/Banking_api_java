package com.example.banking_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")

public class Account {
    @Id
    private UUID id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double accountBalance;

}
