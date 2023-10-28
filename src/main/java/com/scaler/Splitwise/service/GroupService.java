package com.scaler.Splitwise.service;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException;
}
