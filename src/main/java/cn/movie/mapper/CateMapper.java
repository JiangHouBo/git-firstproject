package cn.movie.mapper;

import cn.movie.pojo.CateGory;
import cn.movie.pojo.Movie;

import java.util.List;

/**
 * Created by 江厚波 on 2020/3/28.
 */
public interface CateMapper {
    //查询分类信息,通过电影的mid
    public  abstract List<CateGory>  selectCate(Integer cid);
    //通过分类的cid查询电影信息
    public  abstract  List<CateGory> selectByCid(CateGory cate);

}
