package com.internship.trueclub.controller;

import com.internship.trueclub.Servive.AssignmentService;
import com.internship.trueclub.dto.request.AssignmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trueclub/api/v1")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/insertRecord")
    ResponseEntity<?> createRecord(@RequestBody AssignmentRequest assignmentRequest){
        return ResponseEntity.ok(this.assignmentService.insertNewRecord(assignmentRequest));
    }

    @GetMapping("/getRecord/{id}")
    ResponseEntity<?> getRecordBasedOnId(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.assignmentService.getRecordBasedOnId(id));
    }
    @PutMapping("/updateRecord/{id}")
    ResponseEntity<?> updateRecord(@PathVariable("id") Long id,@RequestBody AssignmentRequest assignmentRequest){
        return ResponseEntity.ok(this.assignmentService.updateRecord(id,assignmentRequest));
    }

    @DeleteMapping("/deleteRecord/{id}")
    ResponseEntity<?> deleteRecord(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.assignmentService.deleteRecordAccordingToId(id));
    }

    @GetMapping("/getAllRecords/{pageSize}/{pageOffset}/{feild}")
    ResponseEntity<?> getAllRecords(@PathVariable("pageSize") int pageSize,@PathVariable("pageOffset") int pageOffset,@PathVariable("feild") String feild){
        return ResponseEntity.ok(this.assignmentService.getAllRecords(pageSize,pageOffset,feild));
    }


}
