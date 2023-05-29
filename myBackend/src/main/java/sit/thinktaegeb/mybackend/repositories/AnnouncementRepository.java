package sit.thinktaegeb.mybackend.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import sit.thinktaegeb.mybackend.entities.Announcement;

import java.time.ZonedDateTime;
import java.util.List;


@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {


    Page<Announcement> findAllByCategoryId(Integer categoryId, PageRequest of);

    @Query("SELECT a FROM Announcement a WHERE a.announcementDisplay = :display and ((a.publishDate is null and a.closeDate is null) or (a.publishDate <= :currentTime and a.closeDate > :currentTime) or (a.publishDate <= :currentTime and a.closeDate is null) or (a.closeDate > :currentTime and a.publishDate is null)) ORDER BY a.id DESC")
    List<Announcement> listFindAllByActiveModeWithNoCategory(@RequestParam String display, @RequestParam ZonedDateTime currentTime);

    @Query("SELECT a FROM Announcement a WHERE a.announcementDisplay = :display and a.closeDate <= :currentTime ORDER BY a.id DESC")
    List<Announcement> listFindAllByCloseModeWithNoCategory(@RequestParam String display, @RequestParam ZonedDateTime currentTime);

    @Query("SELECT a FROM Announcement a WHERE a.categoryId = :categoryId and a.announcementDisplay = :display and a.closeDate <= :currentTime ORDER BY a.id DESC")
    Page<Announcement> findAllByCloseModeWithCategory(@RequestParam Integer categoryId, PageRequest of, @RequestParam String display, @RequestParam ZonedDateTime currentTime);

    // active mode with category
    @Query("SELECT a FROM Announcement a WHERE a.categoryId = :categoryId and a.announcementDisplay = :display and ((a.publishDate is null and a.closeDate is null) or (a.publishDate <= :currentTime and a.closeDate > :currentTime) or (a.publishDate <= :currentTime and a.closeDate is null) or (a.closeDate > :currentTime and a.publishDate is null)) ORDER BY a.id DESC")
    Page<Announcement> findAllByActiveModeWithCategory(@RequestParam Integer categoryId, PageRequest of, @RequestParam String display, @RequestParam ZonedDateTime currentTime);

    // active mode with no category
    @Query("SELECT a FROM Announcement a WHERE a.announcementDisplay = :display and ((a.publishDate is null and a.closeDate is null) or (a.publishDate <= :currentTime and a.closeDate > :currentTime) or (a.publishDate <= :currentTime and a.closeDate is null) or (a.closeDate > :currentTime and a.publishDate is null)) ORDER BY a.id DESC")
    Page<Announcement> findAllByActiveModeWithNoCategory(PageRequest of, @RequestParam String display, @RequestParam ZonedDateTime currentTime);

    // active mode with no category
    @Query("SELECT a FROM Announcement a WHERE a.announcementDisplay = :display and a.closeDate <= :currentTime ORDER BY a.id DESC")
    Page<Announcement> findAllByCloseModeWithNoCategory(PageRequest of, @RequestParam String display, @RequestParam ZonedDateTime currentTime);

}
