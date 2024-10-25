

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import culturemedia.service.CultureMediaService;
import culturemedia.service.implementation.CultureMediaServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CultureMediaTest {

    private CultureMediaService cultureMediaService;

    @BeforeEach
    void init(){

        cultureMediaService = new CultureMediaServiceImpl();

        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)
        );


        for ( Video video : videos ) {
            cultureMediaService.save( video );
        }

    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = cultureMediaService.findAll();
        assertEquals(6, videos.size());
    }


    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        CultureMediaService emptyService = new CultureMediaServiceImpl();
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, emptyService::findAll);
        System.out.println("Mensaje de la excepción: " + exception.getMessage());
        assertEquals("There are no videos", exception.getMessage());
    }





}
