package culturemedia.repository.implementation;
import java.util.ArrayList;
import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

	private final List<Video> videos;

	public VideoRepositoryImpl() {
		videos = new ArrayList<>();
	}

	@Override
	public List<Video> findAll() {
		return videos;
	}

	@Override
	public Video save(Video video) {
		this.videos.add( video );
		return video;
	}
	@Override
	public List<Video> find(String title) {
		List<Video> filteredVideos = new ArrayList<>();
		for (Video video : videos) {
			if (video.title().contains(title)) {
				filteredVideos.add(video);
			}
		}
		if (filteredVideos.isEmpty()) {
			throw new VideoNotFoundException("No videos found for the title: " + title);
		}
		return filteredVideos;
	}

	@Override
	public List<Video> find(Double fromDuration, Double toDuration) {
		List<Video> filteredVideos = new ArrayList<>();
		for (Video video : videos) {
			if (video.duration() >= fromDuration && video.duration() <= toDuration) {
				filteredVideos.add(video);
			}
		}
		if (filteredVideos.isEmpty()) {
			throw new VideoNotFoundException("No videos found for the duration range: " + fromDuration + " to " + toDuration);
		}
		return filteredVideos;
	}


}