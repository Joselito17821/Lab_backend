package culturemedia.service.implementation;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CultureMediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultureMediaServiceImpl implements CultureMediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }


    public List<Video> findAll() {
        List<Video> videos = this.videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("There are no videos");
        }
        return videos;
    }

    public Video save(Video video) {
        videoRepository.save(video);
        return video;
    }

    public View save(View view) {
        viewsRepository.save(view);
        return view;
    }

    public List<Video> find(String title) {
        return this.videoRepository.find(title);
    }


    public List<Video> find(Double fromDuration, Double toDuration) {
        return this.videoRepository.find(fromDuration, toDuration);
    }


}
