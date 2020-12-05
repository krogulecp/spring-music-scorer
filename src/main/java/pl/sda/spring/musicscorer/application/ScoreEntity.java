package pl.sda.spring.musicscorer.application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "Score")
public class ScoreEntity {

    @Id
    @GeneratedValue
    private UUID id;
    String scorer;
    int score;
    String albumId;
}
