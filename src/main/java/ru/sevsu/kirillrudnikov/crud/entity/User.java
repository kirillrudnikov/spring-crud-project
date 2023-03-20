package ru.sevsu.kirillrudnikov.crud.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity(
        name = "app_user"
)
@Table(
        name = "app_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "user_phone_unique",
                        columnNames = "phone_number"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "fullname"
    )
    private String fullName;

    @Column(
            name = "email"
    )
    private String email;

    @Column(
            name = "phone_number"
    )
    private String phoneNumber;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Car> cars;

    @Column(
            name = "user_role"
    )
    @Enumerated(
            value = EnumType.STRING
    )
    private UserRole role;

}