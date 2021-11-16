package ir.skpokemon.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Data
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NonNull
    @Column(name = "NAME", unique = true)
    private String name;

    @NonNull
    @Column(name = "AGE")
    private Long age;

    @Column(name = "WIGHT")
    private Long wight;
}
