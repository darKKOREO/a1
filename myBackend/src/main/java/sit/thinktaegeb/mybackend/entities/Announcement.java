package sit.thinktaegeb.mybackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.thinktaegeb.mybackend.constraints.CategoryValidate;
import sit.thinktaegeb.mybackend.constraints.CloseDate;
import sit.thinktaegeb.mybackend.constraints.EnumPattern;

import java.time.ZonedDateTime;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@CloseDate(publishDate = "publishDate", closeDate = "closeDate")
@Table(name = "announcement")
public class Announcement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcementId")
    private Integer id;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(name = "announcementTitle", nullable = false, length = 200)
    private String announcementTitle;

    @NotBlank
    @Size(max = 10000)
    @NotNull
    @Column(name = "announcementDescription", nullable = false, length = 10000)
    private String announcementDescription;

    @CategoryValidate
    @NotNull
    @Column(name = "announcementCategory", nullable = false)
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = "announcementCategory", insertable = false, updatable = false)
    private Category announcementCategory;

    @FutureOrPresent
    @Column(name = "publishDate")
    private ZonedDateTime publishDate;

    @Future
    @Column(name = "closeDate")
    private ZonedDateTime closeDate;

    @EnumPattern(enumClass = displayType.class)
    @Column(name = "announcementDisplay")
    private String announcementDisplay;

}
