package com.internship.trueclub.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {
    @JsonIgnore
    private Long id;
    private String name;
    private String address;
    private String pincode;
    private String state;
    @JsonIgnore
    private Timestamp row_creation_timestamp;
}
