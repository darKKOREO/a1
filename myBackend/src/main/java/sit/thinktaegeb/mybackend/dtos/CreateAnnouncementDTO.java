package sit.thinktaegeb.mybackend.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class CreateAnnouncementDTO {
    private Integer id;
    private String announcementTitle;
    @Column(name = "CategoryId")
    private Integer CategoryId;
    private String announcementDescription;

    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    private String announcementDisplay;
    @Column(name = "announcementCategory", nullable = false)
    private String announcementCategory = CategoryDTO.getCategoryName();


}
