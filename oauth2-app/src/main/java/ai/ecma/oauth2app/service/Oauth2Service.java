package ai.ecma.oauth2app.service;

import ai.ecma.oauth2app.entity.User;
import ai.ecma.oauth2app.entity.enums.AuthTypeEnum;
import ai.ecma.oauth2app.payload.ApiResponse;
import ai.ecma.oauth2app.payload.UserDto;
import ai.ecma.oauth2app.repository.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * BY ISLOM UZDEV 12/1/2020 10:02 AM
 */

@Service
public class Oauth2Service {
    final
    UserRepository userRepository;

    public Oauth2Service(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ApiResponse registerOrLoginOauth(OAuth2User oAuth2User, AuthTypeEnum authTypeEnum) {
        UserDto userDtoByAuthType = getUserDtoByAuthType(oAuth2User, authTypeEnum);
        User user = userRepository.findByEmail(
                userDtoByAuthType != null ? userDtoByAuthType.getEmail() :
                        UUID.randomUUID().toString()).orElse(new User());
        user.setEmail(userDtoByAuthType.getEmail());
        if (user.getFirstName() == null)
            user.setFirstName(userDtoByAuthType.getFirstName());
        if (user.getLastName() == null)
            user.setLastName(userDtoByAuthType.getLastName());
        if (user.getPhotoUrl() == null)
            user.setPhotoUrl(userDtoByAuthType.getPhotoUrl());
        userRepository.save(user);
        return new ApiResponse(
                "xush kelibsiz",
                true,
                "token");
    }

    private UserDto getUserFromOauth2Google(OAuth2User oAuth2User) {
        String email = Objects.requireNonNull(oAuth2User.getAttribute("email")).toString();
        String firstName = Objects.requireNonNull(oAuth2User.getAttribute("given_name")).toString();
        String lastName = Objects.requireNonNull(oAuth2User.getAttribute("family_name")).toString();
        String photoUrl = Objects.requireNonNull(oAuth2User.getAttribute("picture")).toString();
        return new UserDto(
                firstName,
                lastName,
                email,
                photoUrl);
    }

    private UserDto getUserDtoByAuthType(OAuth2User oAuth2User, AuthTypeEnum authTypeEnum) {
        switch (authTypeEnum) {
            case GOOGLE:
                return getUserFromOauth2Google(oAuth2User);
            default:
                return null;
        }
    }

    public ApiResponse register(UserDto userDto) {

        return new ApiResponse();
    }
}
