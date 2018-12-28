CREATE DATABASE netshop;
USE netshop;
create table comment_goods
(
  cd_id        int auto_increment
    primary key,
  context      varchar(255)                   default '此用户没有填写评论' null comment '评论',
  assess_level enum ('1', '2', '3', '4', '5') default '5'         null comment '好评等级'
)
  comment '对一个商品的评价';

create table goods
(
  goods_id    int auto_increment
    primary key,
  goods_name  varchar(30)                                            not null,
  sh_id       int                                                    not null comment '商品所属商店',
  sales       int                                                    null comment '商品销量，每天定时刷新',
  price_refer double                                default 99999    not null comment '市场参考价格',
  price       double                                default 9        not null comment '商品价格',
  stock       int                                   default 0        null comment '库存',
  status      enum ('NORMAL', 'SOLD_OUT', 'FORBID') default 'NORMAL' not null
)
  comment '商品';

create table goods_order
(
  goods_order_id int auto_increment
    primary key,
  goods_id       int    null comment '订单中的商品',
  goods_price    double null comment '商品的价格'
)
  comment '订单中的商品';

create table shop
(
  sh_id      int auto_increment comment '主键，自增
'
    primary key,
  sh_name    varchar(30)   null comment '店名',
  fans_num   int default 0 null comment '粉丝数量
',
  shopper_id int           not null comment '店主'
)
  comment '网上商店';

create table shopping_cart
(
  cart_id  int auto_increment
    primary key,
  goods_id int           not null comment '商品的id',
  user_id  int           not null comment '用户的id',
  num      int default 1 not null comment '这个商品的数量'
);

create table user
(
  user_id       int auto_increment comment '用户编号'
    primary key,
  user_name     varchar(30)                                        null comment '用户名称',
  pwd           varchar(255)                                       null comment '用户密码',
  role          enum ('CONSUMER', 'SHOPPER')  default 'CONSUMER'   null comment '用户角色',
  state         enum ('NO_CONFIRM', 'NORMAL') default 'NO_CONFIRM' null comment '用户的状态码
',
  email         varchar(40)                                        null comment '用户邮箱
',
  tel           varchar(11)                                        null comment '手机号',
  head_portrait varchar(255)                                       null comment '用户头像图片存储位置
',
  constraint user_user_name_uindex
    unique (user_name)
);

create table user_orders
(
  uo_id          int auto_increment comment '主键'
    primary key,
  user_id        int         not null comment '订单所属顾客的id',
  order_datetime datetime    null comment '下单时间',
  order_addr     varchar(50) null comment '收获地址',
  order_username varchar(10) null comment '收货人名称'
);

