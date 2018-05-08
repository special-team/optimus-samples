/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

DROP TABLE IF EXISTS e_business_customer;

-- ======== ======== ======== ========
-- customer
-- ======== ======== ======== ========
CREATE TABLE e_business_customer (
  id_      BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
  name_    VARCHAR(100) NOT NULL COMMENT '名称',
  mobile_  VARCHAR(100) NULL COMMENT '手机',
  mail_    VARCHAR(100) NULL COMMENT '邮箱',
  address_ VARCHAR(100) NULL COMMENT '地址',
  state_   INT          NOT NULL COMMENT '状态',
  gid_     BIGINT       NOT NULL COMMENT '所属权限组',
  deleted_ INT          NOT NULL COMMENT '记录状态[0:有效|1:无效]',
  created_ DATETIME     NOT NULL COMMENT '记录创建时间',
  updated_ DATETIME     NOT NULL COMMENT '记录更新时间',
  CONSTRAINT customer_pk PRIMARY KEY (id_)
);

