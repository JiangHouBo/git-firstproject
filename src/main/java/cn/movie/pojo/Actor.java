package cn.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private Integer aid;
    private String actor;
    private List<Movie> movies;
}
