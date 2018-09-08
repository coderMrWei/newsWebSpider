DROP TABLE  IF EXISTS news;
CREATE TABLE news(
  id INT PRIMARY KEY not NULL COMMIT '主键id',
  title VARCHAR(256) not NULL COMMIT '标题',
  title_image VARCHAR(1024) COMMIT '新闻标题图片',
  content text NOT NULL COMMIT '新闻内容',
  tag VARCHAR(256) COMMIT '新闻标签',
  source_website VARCHAR(256) COMMIT '新闻来源网站名称',
  source_website_url VARCHAR(256) COMMIT '新闻来源网站网址',
  source_url VARCHAR(256) comment '新闻网址',
  visit_count BIGINT COMMIT '浏览次数',
  comment_count INT COMMIT '点评次数',
  create_time TIMESTAMP  COMMIT '创建时间',
  update_time TIMESTAMP  COMMIT '更新时间'
)engine=innoDB DEFAULT charset utf8 comment='新闻表'