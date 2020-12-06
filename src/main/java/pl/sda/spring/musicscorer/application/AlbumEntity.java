package pl.sda.spring.musicscorer.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity(name = "Album")
@AllArgsConstructor
@NoArgsConstructor
public class AlbumEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String artist;
    String description;
    LocalDate releaseDate;
}
