package com.internship.trueclub.impl;

import com.internship.trueclub.Servive.AssignmentService;
import com.internship.trueclub.domain.Assignment;
import com.internship.trueclub.dto.request.AssignmentRequest;
import com.internship.trueclub.dto.response.ApiResponse;
import com.internship.trueclub.exception.ResourceNotFoundException;
import com.internship.trueclub.repository.AssignmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssignmentRequest insertNewRecord(AssignmentRequest assignmentRequest) {
        Assignment assignment = this.reqToAssignment(assignmentRequest);
        assignment.setRow_creation_timestamp(new Timestamp(System.currentTimeMillis()));
        this.assignmentRepository.save(assignment);
        return assignmentRequest;
    }

    @Override
    public AssignmentRequest getRecordBasedOnId(Long id) {
        Assignment assignment = this.assignmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This Record is Not Found in our DataBase : "+id));
        return this.assignmentToReq(assignment);
    }

    @Override
    public AssignmentRequest updateRecord(Long id, AssignmentRequest assignmentRequest) {
        Assignment assignment = this.assignmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This Record is Not Found in our DataBase : "+id));
        Assignment assignment1 = this.reqToAssignment(assignmentRequest);
        if(assignment1.getAddress()!=null)
        assignment.setAddress(assignment1.getAddress());
        if(assignment1.getName()!=null)
        assignment.setName(assignment1.getName());
        if(assignment1.getPincode()!=null)
        assignment.setPincode(assignment1.getPincode());
        if(assignment1.getState()!=null)
        assignment.setState(assignment1.getState());
        assignment.setRow_creation_timestamp(new Timestamp(System.currentTimeMillis()));
        this.assignmentRepository.save(assignment);
        return this.assignmentToReq(assignment);
    }

    @Override
    public ApiResponse deleteRecordAccordingToId(Long id) {
        if(this.assignmentRepository.existsById(id)) {
            this.assignmentRepository.deleteById(id);
            return ApiResponse.builder().status(HttpStatus.ACCEPTED).message("Deleted Successfully").build();
        }
        return ApiResponse.builder().status(HttpStatus.NOT_FOUND).message("Invalid").build();
    }

    @Override
    public List<AssignmentRequest> getAllRecords(int pageSize,int pageOffset,String feild) {
        Page<Assignment> all = this.assignmentRepository.findAll(PageRequest.of(pageOffset, pageSize).withSort(Sort.by(Sort.Direction.ASC,feild)));
        List<Assignment> assignments = all.toList();
        List<AssignmentRequest> assignmentRequests=new ArrayList<>();
        for(Assignment assignment:assignments)
            assignmentRequests.add(this.assignmentToReq(assignment));

        return assignmentRequests;
    }

    Assignment reqToAssignment(AssignmentRequest request){
        return this.modelMapper.map(request,Assignment.class);
    }

    AssignmentRequest assignmentToReq(Assignment assignment){
        return this.modelMapper.map(assignment,AssignmentRequest.class);
    }
}
