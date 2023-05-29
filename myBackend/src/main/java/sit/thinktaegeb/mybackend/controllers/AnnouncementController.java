package sit.thinktaegeb.mybackend.controllers;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;
import sit.thinktaegeb.mybackend.dtos.*;
import sit.thinktaegeb.mybackend.entities.Announcement;

import sit.thinktaegeb.mybackend.services.AnnouncementService;
import sit.thinktaegeb.mybackend.utils.ListMapper;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;


    @GetMapping("/{id}")
    public AnnouncementDTO getAnnouncementById(@PathVariable Integer id) {
        return modelMapper.map(announcementService.getAnnouncementById(id), AnnouncementDTO.class);
    }

    @PutMapping("/{id}")
    public CreateAnnouncementDTO updateAnnouncement(@PathVariable Integer id, @Valid @RequestBody Announcement announcement) {
        return modelMapper.map(announcementService.updateAnnouncement(id, announcement), CreateAnnouncementDTO.class);
    }

    @DeleteMapping("/{id}")
    public Announcement deleteAnnouncement(@PathVariable Integer id) {
        return announcementService.deleteAnnouncement(id);
    }

    @PostMapping("")
    public CreateAnnouncementDTO create(@Valid @RequestBody Announcement newAnnouncement) {
        return modelMapper.map(announcementService.create(newAnnouncement), CreateAnnouncementDTO.class);
    }


    @GetMapping("")
    public List<AnnouncementsDTO> getAllAnnouncementForUser(@RequestParam(defaultValue = "admin") String mode) {
        return listMapper.mapList(announcementService.getAnnouncementByMode(mode), AnnouncementsDTO.class, modelMapper);
    }


    @GetMapping("/pages")
    public PageDTO<AnnouncementsDTO> getAllAnnouncementByCategory(@RequestParam(defaultValue = "active") String mode, @RequestParam(required = false) Integer category, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        Page<Announcement> announcementPage = announcementService.getAnnouncementByCategory(mode, category, page, size);
        return listMapper.toPageDTO(announcementPage, AnnouncementsDTO.class, modelMapper);
    }


}
