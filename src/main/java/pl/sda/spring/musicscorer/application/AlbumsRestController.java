package pl.sda.spring.musicscorer.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumsRestController {

    @GetMapping("/albums")
    public ResponseEntity<AlbumsResponse> getAlbums(){
        return null;
    }
}
