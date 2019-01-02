package cn.edu.zzuli.controller.consumer;

import cn.edu.zzuli.bean.GoodsComment;
import cn.edu.zzuli.service.goods.GoodsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/commentGoods")
public class ConsumerCommentGoodsController {
    @Autowired
    GoodsCommentService goodsCommentService;
    /**
     *
     */
}
