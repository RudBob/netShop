package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.Goods;
import cn.edu.zzuli.service.consumer.ConsumerService;
import cn.edu.zzuli.service.goods.GoodsService;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description 顾客的相关操作
 * @Author 任耀
 * @Date 2018年12月27日 10点55分
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

}





