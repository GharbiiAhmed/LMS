package com.avaxia.lms.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.avaxia.lms.dtos.*;
import com.avaxia.lms.dtos.UserDTO;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {

    private String accessToken;
    private String refreshToken;
    private UserDTO userDetails;
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setUserDetails(UserDTO userDetails) {
        this.userDetails = userDetails;
    }
}