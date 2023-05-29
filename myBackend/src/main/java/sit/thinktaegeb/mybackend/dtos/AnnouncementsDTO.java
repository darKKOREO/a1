package sit.thinktaegeb.mybackend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AnnouncementsDTO {
    private Integer id;
    private String announcementTitle;
    private String announcementCategory = CategoryDTO.getCategoryName();
    private Integer categoryId;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    private String announcementDisplay;


}
