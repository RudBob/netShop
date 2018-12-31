package cn.edu.zzuli.service.consumer;

import cn.edu.zzuli.bean.UserAdd;

public interface ConsumerAddrService {
    UserAdd getAddrByAddrId(Integer addrId);
}
