package ru.sevsu.kirillrudnikov.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity(
        name = "app_car"
)
@Table(
        name = "app_car",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "car_license_plate_unique",
                        columnNames = "license_plate"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @SequenceGenerator(
            name = "app_car_sequence",
            sequenceName = "app_car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_car_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private User user;

    @Column(
            name = "brand"
    )
    @Enumerated(
            value = EnumType.STRING
    )
    private CarBrand brand;

    @Column(
            name = "license_plate"
    )
    private String licensePlate;

}