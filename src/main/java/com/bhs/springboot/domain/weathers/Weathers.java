//날씨데이터 넣으려구 dto 만듬
package com.bhs.springboot.domain.weathers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Weathers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int temperature;
    private int rain;

    @Builder
    public Weathers(int temperature, int rain) {
        this.temperature = temperature;
        this.rain = rain;

    }

}
