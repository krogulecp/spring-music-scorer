package pl.sda.spring.musicscorer.application.album;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlbumsRestControllerTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void should_get_album(){
        //given
        final AlbumEntity albumEntity
                = new AlbumEntity(null, "ten", "pearl jam", "some desc", LocalDate.of(1990, 2, 10));
        final AlbumEntity savedAlbum = albumRepository.save(albumEntity);

        //when
        final ResponseEntity<SingleAlbumResponse> albumResponse
                = testRestTemplate.getForEntity("/albums/" + savedAlbum.getId().toString(), SingleAlbumResponse.class);

        //then
        Assertions.assertThat(albumResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(albumResponse.getBody()).isNotNull();
        Assertions.assertThat(albumResponse.getBody().getArtist()).isEqualTo("pearl jam");
        Assertions.assertThat(albumResponse.getBody().getTitle()).isEqualTo("ten");
    }

    @Test
    void should_get_albums_by_title_and_artist(){
        //given
        final AlbumEntity album1
                = new AlbumEntity(null, "ten", "pearl jam", "some desc", LocalDate.of(1990, 2, 10));
        final AlbumEntity album2
                = new AlbumEntity(null, "awake", "godsmack", "some desc", LocalDate.of(2000, 2, 10));

        albumRepository.saveAll(List.of(album1, album2));

        //when
        final ResponseEntity<AlbumsResponse> albumsResponse = testRestTemplate.getForEntity("/albums?title=awake&artist=godsmack", AlbumsResponse.class);

        //then
        Assertions.assertThat(albumsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(albumsResponse.getBody()).isNotNull();
        Assertions.assertThat(albumsResponse.getBody().getAlbums()).hasSize(1);
    }
}
