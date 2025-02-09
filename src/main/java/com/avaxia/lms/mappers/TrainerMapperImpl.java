package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.TrainerDTO;
import com.avaxia.lms.dtos.UserDTO;
import com.avaxia.lms.entities.Trainer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TrainerMapperImpl {

    // Convert Trainer entity to DTO
    public TrainerDTO fromTrainer(Trainer trainer) {
        TrainerDTO trainerDTO = new TrainerDTO();
        BeanUtils.copyProperties(trainer, trainerDTO);
        return trainerDTO;
    }

    // Convert TrainerDTO to Trainer entity
    public Trainer fromTrainerDTO(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        BeanUtils.copyProperties(trainerDTO, trainer);
        return trainer;
    }

    // Convert UserDTO to Trainer entity
    public Trainer fromUserDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        Trainer trainer = new Trainer();
        trainer.setId(userDTO.getId());
        trainer.setUsername(userDTO.getUsername());
        trainer.setFirstName(userDTO.getFirstName());
        trainer.setLastName(userDTO.getLastName());
        trainer.setEmail(userDTO.getEmail());
        trainer.setPassword(userDTO.getPassword());
        trainer.setRoles(userDTO.getRoles());
        return trainer;
    }
}
