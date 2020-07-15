package cn.movie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer mid;
    private String moviename;
    private Date date;
    private List<Actor> actor;
    private List<CateGory> cate;
}
