package culturemedia.service.implementation;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CultureMediaService;

import java.util.ArrayList;
import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;

    private final List<Video> videos;

    public CultureMediaServiceImpl() {
        videos = new ArrayList<>();
    }


    public List<Video> findAll() {
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("There are no videos");
        }
        return videos;
    }


    public Video save(Video video) {
        videos.add(video);
        return video;
    }

    public View save(View view) {
        return view;
    }
}

