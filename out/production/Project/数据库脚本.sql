-- 删除数据库
DROP DATABASE IF EXISTS store;
-- 创建数据库
CREATE  DATABASE store CHARACTER SET UTF8;
-- 使用mshop数据库
USE store;
-- 删除数据表
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS merchant;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS admin;
-- 创建数据表
-- 1.创建管理员信息表
CREATE TABLE admin(
  aid         VARCHAR(50),
  password    VARCHAR(32) NOT NULL,
  lastdate    DATETIME,
  CONSTRAINT pk_aid PRIMARY KEY(aid)
) engine=InnoDB;

-- 2.创建学生用户信息表
CREATE TABLE student(
  sno          VARCHAR(50),
  spassword    VARCHAR(32),
  sname        VARCHAR(50),
  smoney       DOUBLE,
  sstatus      INT,
  sclass       VARCHAR(50),
  slocate      VARCHAR(200),
  sphone       VARCHAR(50),
  CONSTRAINT pk_son PRIMARY KEY(sno)
) engine=InnoDB;

-- 3.创建商家用户信息表
CREATE TABLE merchant(
  mid         VARCHAR(50),
  mpassword    VARCHAR(32),
  mname        VARCHAR(200),
  mmoney       DOUBLE,
  mstatus     INT,
  mlocate     VARCHAR(200),
  mphone      VARCHAR(50),
  CONSTRAINT pk_mid PRIMARY KEY(mid)
) engine=InnoDB;

-- 4.创建商家商品信息表
CREATE TABLE goods(
  gid         INT   AUTO_INCREMENT,
  mid         VARCHAR(50),
  gname        VARCHAR(200),
  gprice       DOUBLE,
  gstatus      INT,
  CONSTRAINT pk_gid PRIMARY KEY(gid),
  CONSTRAINT fk_mid1 FOREIGN KEY(mid) REFERENCES merchant(mid) ON DELETE CASCADE
) engine=InnoDB;

-- 5.创建订单信息表
CREATE TABLE orders(
  oid       INT   AUTO_INCREMENT,
  mid       VARCHAR(50) NOT NULL,
  sno       VARCHAR(50) NOT NULL,
  gname     VARCHAR(50),
  credate   DATETIME,
  pay       DOUBLE,
  ostatus   INT,
  CONSTRAINT pk_oid PRIMARY KEY(oid),
  CONSTRAINT fk_mid2 FOREIGN KEY(mid) REFERENCES merchant(mid) ON DELETE CASCADE,
  CONSTRAINT fk_sno FOREIGN KEY(sno) REFERENCES student(sno) ON DELETE CASCADE
) engine=InnoDB;

-- 编写测试数据
-- 增加管理员信息
INSERT INTO admin(aid,password) VALUES ('admin','202CB962AC59075B964B07152D234B70');
-- 增加学生信息
INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES ('20171729', '202CB962AC59075B964B07152D234B70', '刘利', 1000.0, 1, '软件开发1702班', '11栋113寝室', '15216047736');
INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES ('20171730', '202CB962AC59075B964B07152D234B70', '张三', 1000.0, 1, '软件开发1702班', '11栋113寝室', 'xxxxxxxxxxx');
INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES ('20171731', '202CB962AC59075B964B07152D234B70', '李四', 1000.0, 1, '软件开发1702班', '11栋113寝室', 'xxxxxxxxxxx');
INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES ('20171732', '202CB962AC59075B964B07152D234B70', '王五', 1000.0, 1, '软件开发1702班', '11栋113寝室', 'xxxxxxxxxxx');
INSERT INTO student(sno, spassword, sname, smoney, sstatus, sclass, slocate, sphone) VALUES ('20171733', '202CB962AC59075B964B07152D234B70', '颜逸', 1000.0, 1, '软件开发1702班', '11栋113寝室', 'xxxxxxxxxxx');
-- 增加商家信息
INSERT INTO merchant(mid, mpassword, mname, mmoney, mstatus, mlocate, mphone) VALUES ('111', '202CB962AC59075B964B07152D234B70', '麻辣香锅', 1000.0, 1, '第一栋食堂第一层第一窗口', '15216047736');
INSERT INTO merchant(mid, mpassword, mname, mmoney, mstatus, mlocate, mphone) VALUES ('121', '202CB962AC59075B964B07152D234B70', '兰州拉面', 1000.0, 1, '第一栋食堂第一层第一窗口', '15216047736');
INSERT INTO merchant(mid, mpassword, mname, mmoney, mstatus, mlocate, mphone) VALUES ('131', '202CB962AC59075B964B07152D234B70', '麻辣烫', 1000.0, 1, '第一栋食堂第一层第一窗口', '15216047736');
INSERT INTO merchant(mid, mpassword, mname, mmoney, mstatus, mlocate, mphone) VALUES ('112', '202CB962AC59075B964B07152D234B70', '包子店', 1000.0, 1, '第一栋食堂第一层第一窗口', '15216047736');

COMMIT;