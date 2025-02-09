package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.LearnerDTO;
import com.avaxia.lms.dtos.UserDTO;
import com.avaxia.lms.entities.Learner;
import com.avaxia.lms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LearnerMapperImpl {

    public LearnerDTO fromLearner(Learner learner) {
        LearnerDTO learnerDTO = new LearnerDTO();
        BeanUtils.copyProperties(learner, learnerDTO);
        return learnerDTO;
    }

    public Learner fromLearnerDTO(LearnerDTO learnerDTO) {
        Learner learner = new Learner();
        BeanUtils.copyProperties(learnerDTO, learner);
        return learner;
    }

    public Learner fromUserDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        Learner learner = new Learner();
        learner.setId(userDTO.getId());
        learner.setUsername(userDTO.getUsername());
        learner.setFirstName(userDTO.getFirstName());
        learner.setLastName(userDTO.getLastName());
        learner.setEmail(userDTO.getEmail());
        learner.setPassword(userDTO.getPassword());
        learner.setRoles(userDTO.getRoles());
        return learner;
    }
}
