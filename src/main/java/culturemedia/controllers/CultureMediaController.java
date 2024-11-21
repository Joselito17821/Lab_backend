
package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class CultureMediaController {

    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    @GetMapping("/videos")
    @CrossOrigin(origins = "*")
    public List<Video> findAll() throws VideoNotFoundException {
        return cultureMediaService.findAll();
    }


    @PostMapping("/videos")
    @CrossOrigin(origins = "*")
    public Video save(@RequestBody Video video) throws VideoNotFoundException {
        return this.cultureMediaService.save(video);
    }
}