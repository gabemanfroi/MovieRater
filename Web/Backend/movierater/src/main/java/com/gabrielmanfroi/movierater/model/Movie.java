package com.gabrielmanfroi.movierater.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Movie implements Serializable {

    @Id
    private Integer id;
    private String name;
    private Boolean adult;
    private String imageUrl;

}
