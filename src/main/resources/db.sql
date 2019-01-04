USE netshop;
create table bank_card
(
  card_id       int                                                 not null
    primary key,
  card_num      varchar(19)                                         not null,
  bank_name     enum ('中国工商银行', '中国农业银行', '农村信用社') default '中国农业银行' null,
  user_money_id int                                                 not null comment '银行卡对应的用户',
  constraint bank_card_card_num_uindex
    unique (card_num)
);

create table cart_detail
(
  detail_id int auto_increment
    primary key,
  user_id   int           not null comment '用户的id',
  goods_id  int           not null comment '商品的id',
  num       int default 1 not null comment '这个商品的数量'
);

create table comment_goods
(
  cd_id        int auto_increment
    primary key,
  contexts     varchar(255)                   default '此用户没有填写评论' null comment '评论',
  assess_level enum ('1', '2', '3', '4', '5') default '5'         null comment '好评等级',
  user_id      int                                                null comment '用户的id，找到谁写的评论'
)
  comment '对一个商品的评价';

create table goods
(
  goods_id    int auto_increment
    primary key,
  goods_name  varchar(30)                                                        not null,
  sh_id       int                                                                not null comment '商品所属商店',
  sales       int                                                                null comment '商品销量，每天定时刷新',
  price_refer double                                            default 99999    not null comment '市场参考价格',
  price       double                                            default 9        not null comment '商品价格',
  stock       int                                               default 0        null comment '库存',
  status      enum ('NORMAL', 'SOLD_OUT', 'FORBID', 'TEMP_OUT') default 'NORMAL' not null
)
  comment '商品';

create table message
(
  chat_detail_id int auto_increment
    primary key,
  content        varchar(255) null comment '聊天内容
',
  chat_datetime  datetime     not null comment '消息时间',
  from_user_id   int          null comment '发送方用户id',
  to_user_id     int          not null comment '接收方用户id',
  constraint chat_detail_from_user_id_uindex
    unique (from_user_id)
);

create table order_data
(
  order_data_id int auto_increment comment '主键'
    primary key,
  goods_id      int           null comment '订单中的商品',
  goods_price   double        null comment '商品的价格',
  uo_id         int           null comment '订单的id号',
  num           int default 1 not null
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

create table user_addr
(
  add_id          int auto_increment
    primary key,
  add_name        varchar(100) not null comment '用户所在区级地址',
  user_id         int          null comment '用户id，外键',
  add_name_detail varchar(255) null comment '详情地址',
  receiver_tel    varchar(11)  not null comment '收货人手机号',
  receiver_name   varchar(10)  not null comment '收货人名称'
)
  comment '用户的收货地址';

create table user_money
(
  um_id   int auto_increment comment '主键'
    primary key,
  money   double       not null comment '用户的余额',
  um_pwd  varchar(255) not null comment '支付密码',
  user_id int          null comment '用户的id',
  constraint user_money_user_id_uindex
    unique (user_id)
);

create table user_orders
(
  uo_id          int auto_increment comment '主键'
    primary key,
  user_id        int                                                                                                                 not null comment '订单所属顾客的id',
  order_datetime datetime                                                                                                            null comment '下单时间',
  receiver_addr  varchar(50)                                                                                                         null comment '收获地址',
  receiver_name  varchar(10)                                                                                                         null comment '收货人名称',
  receiver_tel   varchar(11)                                                                                                         null comment '收货人手机号',
  order_status   enum ('NOT_PAY', 'WAIT_DELIVER', 'WAIT_COLLECT', 'DELIVERING', 'HAVE_SIGN', 'WAIT_COMMENT', 'OK') default 'NOT_PAY' null comment '订单的状态'
);

