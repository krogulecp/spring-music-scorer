package pl.sda.spring.musicscorer.application;

import lombok.Value;

@Value
public class ScoreRequest {
    String scorer;
    int score;
    String albumId;
}
