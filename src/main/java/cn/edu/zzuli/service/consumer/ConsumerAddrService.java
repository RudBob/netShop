package cn.edu.zzuli.service.consumer;

import cn.edu.zzuli.bean.UserAddr;

import java.util.List;

public interface ConsumerAddrService {
    UserAddr getAddrByAddrId(Integer addrId);

    List<UserAddr> showUserAllAddr();

    int addUserAddr(UserAddr userAddr);

    int deleteAddr(Integer addrId);

    int updateAddr(UserAddr userAddr);
}
