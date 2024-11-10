import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import culturemedia.service.CultureMediaService;
import culturemedia.service.implementation.CultureMediaServiceImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;


public class CultureMediaTest {

    private CultureMediaService cultureMediaService;

    @Mock
    private VideoRepository videoRepository;
    @Mock
    private ViewsRepository viewsRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        doReturn(List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1))).when(videoRepository).findAll();
        List<Video> videos = cultureMediaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(List.of()).when(videoRepository).findAll();
        VideoNotFoundException exception = Assertions.assertThrows(
                VideoNotFoundException.class,
                () -> cultureMediaService.findAll()
        );
        assertEquals("There are no videos", exception.getMessage());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        doReturn(List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1))).when(videoRepository).find("Clic");
        List<Video> videos = videoRepository.find("Clic");
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        doReturn(List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1))).when(videoRepository).find(4.5,5.5);
        List<Video> videos = videoRepository.find(4.5,5.5);
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_VideoNotFoundException_should_be_thrown() {
        doThrow(new VideoNotFoundException("No videos found for the title: language_java"))
                .when(videoRepository).find("language_java");
        assertThrows(VideoNotFoundException.class,
                () -> videoRepository.find("language_java"));
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doThrow(new VideoNotFoundException("No videos found for the duration range: 120.5 to 155.5"))
                .when(videoRepository).find(120.5, 155.5);
        assertThrows(VideoNotFoundException.class, () ->
                videoRepository.find(120.5, 155.5));
    }

}