package pl.sda.spring.musicscorer.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.spring.musicscorer.domain.Album;

@RestController
public class AlbumsRestController {

    private final AlbumService albumService;

    public AlbumsRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public ResponseEntity<AlbumsResponse> getAlbums(@RequestParam(required = false) String title,
                                                    @RequestParam(required = false) String artist){
        return null;
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<SingleAlbumResponse> getAlbum(@PathVariable String id){
        return albumService.getAlbum(id)
                .map(album -> ResponseEntity.ok(new SingleAlbumResponse(album.getArtist(), album.getTitle(), album.getScore())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/albums")
    public ResponseEntity<Void> addAlbum(@RequestBody AddAlbumRequest addAlbumRequest){
        return null;
    }

    @PutMapping("/albums/{id}")
    public ResponseEntity<Void> editAlbum(@RequestBody AddAlbumRequest addAlbumRequest, @PathVariable String id){
        return null;
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<Void> removeAlbum(@PathVariable String id){
        return null;
    }
}
