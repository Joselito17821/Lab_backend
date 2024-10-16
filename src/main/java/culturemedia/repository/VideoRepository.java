package culturemedia.repository;

import culturemedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> listAll();
    Video Add(Video video);
    List<Video> Search(String title);
    List<Video> Search(Double duration, Double durationUpTo);
}
