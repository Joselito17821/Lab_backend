package culturemedia.repository;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> ListAll();
    Video Add(Video video);
    View Add(View view);
}
