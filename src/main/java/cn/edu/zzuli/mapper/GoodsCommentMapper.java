package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.GoodsComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsCommentMapper {
    int deleteByPrimaryKey(Integer cdId);

    int insert(GoodsComment record);

    int insertSelective(GoodsComment record);

    GoodsComment selectByPrimaryKey(Integer cdId);

    int updateByPrimaryKeySelective(GoodsComment record);

    int updateByPrimaryKey(GoodsComment record);
}