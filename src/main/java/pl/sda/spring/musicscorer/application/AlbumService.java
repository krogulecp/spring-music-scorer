package pl.sda.spring.musicscorer.application;

import org.springframework.stereotype.Service;
import pl.sda.spring.musicscorer.domain.Album;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ScoreRepository scoreRepository;

    public AlbumService(AlbumRepository albumRepository, ScoreRepository scoreRepository) {
        this.albumRepository = albumRepository;
        this.scoreRepository = scoreRepository;
    }

    public Optional<Album> getAlbum(String id) {
        final List<ScoreEntity> albumScores = scoreRepository.getByAlbum_Id(UUID.fromString(id));
        BigDecimal artistScore = calculateScore(albumScores);
        return albumRepository.findById(UUID.fromString(id))
                .map(albumEntity -> new Album(albumEntity.getArtist(), albumEntity.getTitle(), artistScore));
    }

    private BigDecimal calculateScore(List<ScoreEntity> albumScores) {
        //TODO
        return BigDecimal.ZERO;
    }
}
