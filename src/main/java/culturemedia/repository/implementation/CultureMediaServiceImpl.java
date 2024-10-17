package culturemedia.repository.implementation;

import culturemedia.repository.CultureMediaService;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import culturemedia.model.Video;
import culturemedia.model.View;

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

