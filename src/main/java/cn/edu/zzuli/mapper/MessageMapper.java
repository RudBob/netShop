package cn.edu.zzuli.mapper;

import cn.edu.zzuli.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer chatDetailId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer chatDetailId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectMsgByTwoUserId(@Param(value = "toUserId") Integer toUserId, @Param(value = "fromUserId") int fromUserId);

    Message selectMsgByTwoUserIdLastMsg(Integer toUserId, int fromUserId);
}