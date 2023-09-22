package com.innovan.springbootcomplete.entitiy;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="DEPARTMENT_ID")
    @SequenceGenerator(name = "DEPARTMENT_ID", sequenceName = "DEPARTMENT_DETAILS_SEQ", allocationSize = 1)
    private Long department_Id;

    @NotBlank(message = " Please Add Department name")
    @Column(name = "DEPARTMENT_NAME")
    private String department_Name;

    @Column(name = "DEPARTMENT_ADDRESS")
    private String department_Address;

    @Column(name = "DEPARTMENT_CODE")
    private String department_Code;

}
