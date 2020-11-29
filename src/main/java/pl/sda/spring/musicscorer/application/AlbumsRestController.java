package pl.sda.spring.musicscorer.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumsRestController {

    @GetMapping("/albums")
    public ResponseEntity<AlbumsResponse> getAlbums(@RequestParam(required = false) String title,
                                                    @RequestParam(required = false) String artist){
        return null;
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<SingleAlbumResponse> getAlbum(@PathVariable String id){
        return null;
    }

    @PostMapping("/albums")
    public ResponseEntity<Void> addAlbum(@RequestBody AddAlbumRequest addAlbumRequest){
        return null;
    }
}
