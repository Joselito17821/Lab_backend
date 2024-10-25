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

    private static List<Video> videos;

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

    public static List<Video> find(String title) {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.title().contains(title)) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException("No videos found with title: " + title);
        }
        return filteredVideos;
    }


    public static List<Video> find(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videos) {
            if (video.duration() >= fromDuration && video.duration() <= toDuration) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException("No videos found in the duration range: " + fromDuration + " - " + toDuration);
        }
        return filteredVideos;
    }


}

