package com.internship.trueclub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
private String address;
private String pincode;
private String state;
private Timestamp row_creation_timestamp;

}
