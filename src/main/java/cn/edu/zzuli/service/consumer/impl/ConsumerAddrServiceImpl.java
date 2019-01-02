package cn.edu.zzuli.service.consumer.impl;

import cn.edu.zzuli.bean.UserAddr;
import cn.edu.zzuli.mapper.UserAddrMapper;
import cn.edu.zzuli.service.consumer.ConsumerAddrService;
import cn.edu.zzuli.util.FormatUtil;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerAddrServiceImpl implements ConsumerAddrService {
    @Autowired
    UserAddrMapper userAddrMapper;

    /**
     * @param addrId 地址id
     * @return 返回地址对象
     */
    @Override
    public UserAddr getAddrByAddrId(Integer addrId) {
        UserAddr userAddr = userAddrMapper.selectByPrimaryKey(addrId);
        return userAddr;
    }

    /**
     * 展示所有用户收货地址
     *
     * @return List<UserAddr>
     */
    @Override
    public List<UserAddr> showUserAllAddr() {
        int userId = SessionUtil.getUserIdFromSession();
        List<UserAddr> userAddrs = userAddrMapper.selectByUserId(userId);
        return userAddrs;
    }

    /**
     * 新增一个收货地址
     *
     * @param userAddr 用户地址
     * @return 改变的行数
     */
    @Override
    public int addUserAddr(UserAddr userAddr) {
        // 更新userId
        userAddr.setUserId(SessionUtil.getUserIdFromSession());
        String tel = userAddr.getReceiverTel();
        // 校验手机号,符合手机号格式的号码才会被记录进入数据库
        int resLine = 0;
        if (FormatUtil.isMobile(tel)) {
            resLine = userAddrMapper.insert(userAddr);
        }
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
     * @return int 更新的行数
     */
    @Override
    public int updateAddr(UserAddr userAddr) {
        int resLine = userAddrMapper.updateByPrimaryKeySelective(userAddr);
        return resLine;
    }
}
