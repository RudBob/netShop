package cn.edu.zzuli.service.consumer.impl;

import cn.edu.zzuli.bean.UserAddr;
import cn.edu.zzuli.mapper.UserAddrMapper;
import cn.edu.zzuli.service.consumer.ConsumerAddrService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerAddrServiceImpl implements ConsumerAddrService {
    @Autowired
    UserAddrMapper userAddrMapper;

    @Override
    public UserAddr getAddrByAddrId(Integer addrId) {
        UserAddr userAddr = userAddrMapper.selectByPrimaryKey(addrId);
        return userAddr;
    }

    /**
     * 展示所有用户收货地址
     * @return
     */
    @Override
    public List<UserAddr> showUserAllAddr() {
        int userId = SessionUtil.getUserIdFromSession();
        List<UserAddr> userAddrs = userAddrMapper.selectByUserId(userId);
        return userAddrs;
    }

    /**
     * 新增一个收货地址
     * @param userAddr
     * @return
     */
    @Override
    public int addUserAddr(UserAddr userAddr) {
        // 更新userId
        userAddr.setUserId(SessionUtil.getUserIdFromSession());
        int resLine = userAddrMapper.insert(userAddr);
        return resLine;
    }

    /**
     * 不可以删除,应该使用更新userId的方式去改变
     */
    @Override
    public int deleteAddr(Integer addrId) {
        int resLine = userAddrMapper.updateAddrToDelete(addrId);
        return resLine;
    }

    /**
     * 编辑一个收货地址
     *
     * @param userAddr 收货地址
     * @return
     */
    @Override
    public int updateAddr(UserAddr userAddr) {
        int resLine = userAddrMapper.updateByPrimaryKeySelective(userAddr);
        return resLine;
    }
}
