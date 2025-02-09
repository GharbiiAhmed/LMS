package com.avaxia.lms.dtos;

import com.avaxia.lms.entities.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainerDTO extends UserDTO {
    Set<Long> coursesTaught; // Set of course IDs the trainer is teaching
    Set<Role> roles; // Handling enum role in DTO

}
