package cn.movie.mapper;

import cn.movie.pojo.Actor;
import cn.movie.pojo.Movie;

import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
public interface ActorMapper {
    //通过演员查询电影
    public abstract List<Movie> selectMovies(Actor actor);
    //通过mid查询演员信息
    public abstract List<Actor> selectActors(Integer mid);
    //通过传入的cid获取演员信息
    public abstract  List<Actor> selectActorsByCid(Integer cid);
    public abstract  List<Actor> selectActores();
}
