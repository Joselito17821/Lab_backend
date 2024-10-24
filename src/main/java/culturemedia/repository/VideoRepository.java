package culturemedia.repository;

import culturemedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> listAll();
    Video add(Video video);
    List<Video> search(String title);
    List<Video> search(Double fromDuration, Double toDuration);
}
