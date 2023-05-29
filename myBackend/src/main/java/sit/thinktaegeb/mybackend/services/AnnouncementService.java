package sit.thinktaegeb.mybackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.thinktaegeb.mybackend.entities.Announcement;
import sit.thinktaegeb.mybackend.repositories.AnnouncementRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository AnnouncementRepo;
    @Autowired
    private CategoryService categoryService;

    //    Get All Announcement (unused)
    public List<Announcement> getAnnouncement(String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        return AnnouncementRepo.findAll(sort);
    }

    //    Get Announcement By Mode (sprint III)
    public List<Announcement> getAnnouncementByMode(String mode) {
        return this.getAllAnnouncementByMode(mode);
    }

    // Get Announcement By Category (sprint III)
    public Page<Announcement> getAnnouncementByCategory(String mode, Integer categoryId, Integer page, Integer size) {
        return this.findByModeAndCategoryId(mode, categoryId, page, size);
    }

    //    Get Announcement By id
    public Announcement getAnnouncementById(Integer id) {
        return AnnouncementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "does not exist !!' to include 'Announcement id") {
        });
    }

    //    Update Announcement
    public Announcement updateAnnouncement(Integer id, Announcement announcement) {
        Announcement updateAnnouncement = AnnouncementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "does not exist !!' to include 'Announcement id") {
        });
        updateAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
        updateAnnouncement.setAnnouncementDescription(announcement.getAnnouncementDescription());
        updateAnnouncement.setAnnouncementCategory(categoryService.getCategoryById(announcement.getCategoryId()));
        updateAnnouncement.setCategoryId(announcement.getCategoryId());
        updateAnnouncement.setPublishDate(announcement.getPublishDate());
        updateAnnouncement.setCloseDate(announcement.getCloseDate());
        updateAnnouncement.setAnnouncementDisplay(announcement.getAnnouncementDisplay());
        return AnnouncementRepo.saveAndFlush(updateAnnouncement);
    }

    //   Delete Announcement
    public Announcement deleteAnnouncement(Integer id) {
        Announcement deleteAnnouncement = AnnouncementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "does not exist !!' to include 'Announcement id") {
        });
        AnnouncementRepo.delete(deleteAnnouncement);
        return deleteAnnouncement;
    }

    //   Create Announcement
    public Announcement create(Announcement newAnnouncement) {
        newAnnouncement.setAnnouncementCategory(categoryService.getCategoryById(newAnnouncement.getCategoryId()));
        return AnnouncementRepo.saveAndFlush(newAnnouncement);
    }


    List<Announcement> getAllAnnouncementByMode(String mode) {
        if (mode.equals("admin")) {
            return AnnouncementRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        } else if (mode.equals("active")) {
            return AnnouncementRepo.listFindAllByActiveModeWithNoCategory("Y", ZonedDateTime.now());
        } else if (mode.equals("close")) {
            return AnnouncementRepo.listFindAllByCloseModeWithNoCategory("Y", ZonedDateTime.now());
        }
        return AnnouncementRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }


    Page<Announcement> findByModeAndCategoryId(String mode, Integer categoryId, Integer page, Integer size) {
        if (mode.equals("admin")) {
            if (categoryId == null)
                return AnnouncementRepo.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
            else
                return AnnouncementRepo.findAllByCategoryId(categoryId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
        } else if (mode.equals("active")) {
            if (categoryId == null)
                return AnnouncementRepo.findAllByActiveModeWithNoCategory(PageRequest.of(page, size), "Y", ZonedDateTime.now());

            else
                return AnnouncementRepo.findAllByActiveModeWithCategory(categoryId, PageRequest.of(page, size), "Y", ZonedDateTime.now());

        } else if (mode.equals("close")) {
            if (categoryId == null)
                return AnnouncementRepo.findAllByCloseModeWithNoCategory(PageRequest.of(page, size), "Y", ZonedDateTime.now());

            else
                return AnnouncementRepo.findAllByCloseModeWithCategory(categoryId, PageRequest.of(page, size), "Y", ZonedDateTime.now());

        } else {
            if (categoryId == null)
                return AnnouncementRepo.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
            else
                return AnnouncementRepo.findAllByCategoryId(categoryId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
        }
    }

}
