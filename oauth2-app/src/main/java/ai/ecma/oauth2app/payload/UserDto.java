package ai.ecma.oauth2app.payload;

import ai.ecma.oauth2app.entity.Attachment;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * BY ISLOM UZDEV 12/1/2020 10:29 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String photoUrl;

    private Integer photoId;

    public UserDto(String firstName, String lastName, String email, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoUrl = photoUrl;
    }
}
