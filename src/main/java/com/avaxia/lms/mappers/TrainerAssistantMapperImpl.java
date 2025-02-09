package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.TrainerAssistantDTO;
import com.avaxia.lms.dtos.UserDTO;
import com.avaxia.lms.entities.TrainerAssistant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TrainerAssistantMapperImpl {

    // Convert TrainerAssistant entity to DTO
    public TrainerAssistantDTO fromTrainerAssistant(TrainerAssistant trainerAssistant) {
        TrainerAssistantDTO trainerAssistantDTO = new TrainerAssistantDTO();
        BeanUtils.copyProperties(trainerAssistant, trainerAssistantDTO);
        return trainerAssistantDTO;
    }

    // Convert TrainerAssistantDTO to TrainerAssistant entity
    public TrainerAssistant fromTrainerAssistantDTO(TrainerAssistantDTO trainerAssistantDTO) {
        TrainerAssistant trainerAssistant = new TrainerAssistant();
        BeanUtils.copyProperties(trainerAssistantDTO, trainerAssistant);
        return trainerAssistant;
    }

    // Convert UserDTO to TrainerAssistant entity
    public TrainerAssistant fromUserDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        TrainerAssistant trainerAssistant = new TrainerAssistant();
        trainerAssistant.setId(userDTO.getId());
        trainerAssistant.setUsername(userDTO.getUsername());
        trainerAssistant.setFirstName(userDTO.getFirstName());
        trainerAssistant.setLastName(userDTO.getLastName());
        trainerAssistant.setEmail(userDTO.getEmail());
        trainerAssistant.setPassword(userDTO.getPassword());
        trainerAssistant.setRoles(userDTO.getRoles());
        return trainerAssistant;
    }
}
