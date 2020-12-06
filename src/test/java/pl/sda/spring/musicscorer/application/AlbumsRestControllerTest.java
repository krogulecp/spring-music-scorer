package pl.sda.spring.musicscorer.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlbumsRestControllerTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void should_get_album(){
        //given

        //when

        //then
    }
}
