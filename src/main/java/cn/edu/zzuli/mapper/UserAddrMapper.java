package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.UserAddr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddrMapper {
    /**
     * 不允许任何代码直接调用，不允许直接删除任何一个地址，
     * 因为订单上的收货地址为引用这个，所以需要删除的时候，只能改变状态，不去展示。
     * 请使用一个封装好的方法
     *
     * @see UserAddrMapper -> updateAddrToDelete
     */
//    int deleteByPrimaryKey(@Param("addId") Integer addId);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);

    UserAddr selectByPrimaryKey(@Param("addId") Integer addId);

    int updateByPrimaryKeySelective(UserAddr record);

    int updateByPrimaryKey(UserAddr record);

    List<UserAddr> selectByUserId(@Param("userId") Integer userId);

    int updateAddrToDelete(@Param("addrId") Integer addrId);

}