package com.internship.trueclub.Servive;

import com.internship.trueclub.dto.request.AssignmentRequest;
import com.internship.trueclub.dto.response.ApiResponse;

import java.util.List;

public interface AssignmentService {
    //insert new record in database
    AssignmentRequest insertNewRecord(AssignmentRequest assignmentRequest);
    //Get the record based on given id
    AssignmentRequest getRecordBasedOnId(Long id);
    //Update the existing record
    AssignmentRequest updateRecord(Long id,AssignmentRequest assignmentRequest);
    //Delete the record based on given id
    ApiResponse deleteRecordAccordingToId(Long id);
    //Get all records
    List<AssignmentRequest> getAllRecords(int pageSize,int pageOffset,String feild);
}
