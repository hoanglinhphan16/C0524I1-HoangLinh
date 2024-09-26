package com.example.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class SongDto implements Validator {
    private String name;
    private String artist;
    private String songType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof SongDto) {
            SongDto songDto = (SongDto) target;

            if (songDto.getName() == null || songDto.getName().isEmpty()) {
                errors.rejectValue("name", "NotEmpty", "Song name is required");
            } else if (songDto.getName().length() < 50) {
                errors.rejectValue("name", "Length", "Song name is too short");
            } else if (!songDto.getName().matches("^[^@;,\\.\\-=+]+$")) {
                errors.rejectValue("name", "Format", "Song name is wrong");
            }

            if (songDto.getArtist() == null || songDto.getArtist().isEmpty()) {
                errors.rejectValue("artist", "NotEmpty", "Artist name is required");
            } else if (songDto.getArtist().length() < 300) {
                errors.rejectValue("artist", "Length", "Artist name is too short");
            } else if (!songDto.getArtist().matches("^[^@;,\\.\\-=+]+$")) {
                errors.rejectValue("artist", "Format", "Artist name is wrong");
            }

            if (songDto.getSongType() == null || songDto.getSongType().isEmpty()) {
                errors.rejectValue("songType", "NotEmpty", "Song type is required");
            } else if (songDto.getSongType().length() < 1000) {
                errors.rejectValue("songType", "Length", "Song type is too short");
            } else if (!songDto.getSongType().matches("^[^@;,\\.\\-=+]+$")) {
                errors.rejectValue("songType", "Format", "Song type is wrong");
            }
        }
    }
}
