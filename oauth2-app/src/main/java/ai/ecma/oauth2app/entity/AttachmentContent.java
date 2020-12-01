package ai.ecma.oauth2app.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * BY ISLOM UZDEV 12/1/2020 10:16 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private byte[] bytes;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;
}
