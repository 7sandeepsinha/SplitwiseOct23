package com.scaler.Splitwise.controller;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.exception.GroupNotFoundException;
import com.scaler.Splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/settleUp/{groupId}")
    public ResponseEntity settleUpForGroup(@PathVariable("groupId") int groupId) throws GroupNotFoundException {
        List<TransactionDTO> transactions = groupService.settleUpByGroupId(groupId);
        return ResponseEntity.ok(transactions);
    }
}

// GET , POST , PUT , DELETE, PATCH
// HTTP Status and Object -> send to users
// ResponseEntity -> HTTP Status Code and Object
