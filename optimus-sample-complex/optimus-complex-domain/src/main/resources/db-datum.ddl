/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- ======== ======== ======== ========
-- module
-- ======== ======== ======== ========
INSERT INTO e_platform_module (id_, name_, icon_, ordinal_, deleted_, created_, updated_) VALUES
  (200, 'module.customer', 'icon-layers', 1, 0, now(), now());

-- ======== ======== ======== ========
-- function
-- ======== ======== ======== ========
INSERT INTO e_platform_function (id_, name_, code_, module_id_, parent_, url_, icon_, type_, display_, is_lock_, ordinal_, deleted_, created_, updated_) VALUES
  (211, 'function.customer.browse', 'customer:browse', 200, 0, '/portal/customer/browse', NULL, 1, 1, 1, 211, 0, now(), now()),
  (212, 'function.customer.create', 'customer:create', 200, 0, '/portal/customer/create', NULL, 1, 0, 1, 212, 0, now(), now()),
  (213, 'function.customer.update', 'customer:update', 200, 0, '/portal/customer/update', NULL, 1, 0, 1, 213, 0, now(), now()),
  (214, 'function.customer.detail', 'customer:detail', 200, 0, '/portal/customer/detail', NULL, 1, 0, 1, 214, 0, now(), now()),
