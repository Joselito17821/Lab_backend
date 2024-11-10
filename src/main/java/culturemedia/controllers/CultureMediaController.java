
package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    @GetMapping("/videos")
    public List<Video> findAll() throws VideoNotFoundException {
        return cultureMediaService.findAll();
    }

    @PostMapping("/videos")
    public Video save(@RequestBody Video video) throws VideoNotFoundException {
        return this.cultureMediaService.save(video);
    }
}
