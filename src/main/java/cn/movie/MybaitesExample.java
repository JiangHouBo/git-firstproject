package cn.movie;

import cn.movie.mapper.ActorMapper;
import cn.movie.mapper.CateMapper;
import cn.movie.mapper.MovieMapper;
import cn.movie.pojo.Actor;
import cn.movie.pojo.CateGory;
import cn.movie.pojo.Movie;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
public class MybaitesExample {
    public static void main(String[] args) {
        try {
            Reader reader = Resources.getResourceAsReader("mybaties.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            List<Movie> movies = mapper.selectMovies();
            movies.forEach((movie)->{
                String date = format.format(movie.getDate());
                System.out.print(movie.getMoviename()+"---"+date+"--");
                List<CateGory> cate = movie.getCate();
                for(CateGory cates:cate){
                    System.out.print(cates.getCname()+"/");
                }
                System.out.print("  ");
                List<Actor> actor = movie.getActor();
                for(Actor actors:actor){
                    System.out.print(actors.getActor()+"/");
                }
                System.out.println();
            });
            CateGory cate = new CateGory();
            cate.setId(1);
            CateMapper cateMapper = session.getMapper(CateMapper.class);
            ActorMapper actorMapper = session.getMapper(ActorMapper.class);
            List<CateGory> list = cateMapper.selectByCid(cate);
            list.forEach(cates->{
                System.out.println(cates.getCname()+":");
                List<Movie> movie = cates.getMovie();
                for(Movie m:movie){
                    String d= format.format(m.getDate());
                    System.out.print(m.getMoviename()+"---"+d+"---");
                    List<Actor> actors = actorMapper.selectActorsByCid(m.getMid());
                    for(Actor actor:actors){
                        System.out.print(actor.getActor()+"/");
                    }
                    System.out.println();
                }
            });
            List<Actor> movieList = actorMapper.selectActores();
            movieList.forEach(movie -> {
                System.out.println(movie.getActor()+":");
                List<Movie> m = movie.getMovies();
//                System.out.println(m);
                for(Movie ms:m){
                    String msdate = format.format(ms.getDate());
                    System.out.print(ms.getMoviename()+"---"+msdate+" ");
                    List<CateGory> cateGories = cateMapper.selectCate(ms.getMid());
                    for(CateGory c:cateGories){
                        System.out.print(c.getCname()+"/");
                    }
                    System.out.println();
                }
            });
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
