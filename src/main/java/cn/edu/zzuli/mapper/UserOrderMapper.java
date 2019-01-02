package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserOrderMapper {
    int deleteByPrimaryKey(Integer uoId);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Integer uoId);

    /**
     * 不允许修改订单的时间
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    int selectLastOrderId(@Param("userId") Integer userId);
}