package pl.sda.spring.musicscorer.application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity(name = "Score")
public class ScoreEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String scorer;
    private int score;
    
    @ManyToOne(targetEntity = AlbumEntity.class)
    private AlbumEntity album;
}
