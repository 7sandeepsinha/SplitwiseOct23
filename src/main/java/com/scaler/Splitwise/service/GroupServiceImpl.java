package com.scaler.Splitwise.service;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.exception.GroupNotFoundException;
import com.scaler.Splitwise.model.Group;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.service.strategy.SettleUpStrategy;
import com.scaler.Splitwise.service.strategy.SettleUpStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException {
        SettleUpStrategy strategy = SettleUpStrategyFactory.getSettleUpStrategy();
        Optional<Group> savedGroup = groupRepository.findById(groupId);
        if(savedGroup.isEmpty()){
            throw new GroupNotFoundException("Group for the given id was not found. Id : " + groupId);
        }
        return strategy.settleUp(savedGroup.get().getExpenses());
    }
}
