package ir.skpokemon.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Data
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Long age;

    private Long wight;
}
