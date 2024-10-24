package culturemedia.service.implementation;

import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;

    public List<Video> ListAll() {
        return null;
    }
    public Video Add(Video video) {

        return video;
    }
    public View Add(View view) {
        return view;
    }
}

