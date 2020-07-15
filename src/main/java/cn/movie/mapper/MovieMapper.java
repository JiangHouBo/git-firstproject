package cn.movie.mapper;

import cn.movie.pojo.Actor;
import cn.movie.pojo.Movie;

import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
public interface MovieMapper {
    //查询所有电影，包含分类和演员信息
    public abstract List<Movie> selectMovies();
    //通过分类id查询电影信息
    public abstract List<Movie> selectCateMovies(Integer cid);
    //通过传过来的cid--mid查询电影信息
    public abstract List<Movie> selectMovieByMid(Integer mid);
    public abstract List<Movie> selectMovieByAid(Integer aid);
}
