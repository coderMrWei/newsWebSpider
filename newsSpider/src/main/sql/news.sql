DROP TABLE  IF EXISTS news;
CREATE TABLE news(
  id INT PRIMARY KEY AUTO_INCREMENT not NULL COMMENT '主键id',
  title VARCHAR(256) not NULL COMMENT '标题',
  title_image VARCHAR(1024) COMMENT '新闻标题图片',
  content text NOT NULL COMMENT '新闻内容',
  tag VARCHAR(256) COMMENT '新闻标签',
  source_website VARCHAR(256) COMMENT '新闻来源网站名称',
  source_website_url VARCHAR(256) COMMENT '新闻来源网站网址',
  source_url VARCHAR(256) COMMENT '新闻网址',
  visit_count BIGINT COMMENT '浏览次数',
  comment_count INT COMMENT '点评次数',
  create_time TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP COMMENT '更新时间',
  about TEXT COMMENT '备注')engine=innoDB DEFAULT charset utf8 comment='新闻表';

INSERT INTO news(title,title_image,content,tag,source_website,source_website_url,source_url,visit_count,comment_count,create_time,update_time,about)
    VALUE ('测试','http://img1.qunarzz.com/sight/p0/201403/13/2759628d934d51955413adfc7201aaad.jpg_710x360_04ee92ea.jpg','大鹏一日乘风起，扶摇直上九万里',
           '古诗','去哪网','piao.qunar.com','piao.qunar.com/index.htm',1,1,'2018-09-15 12:00:00','2018-09-15 12:00:00','测试');