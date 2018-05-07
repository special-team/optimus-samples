/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- ======== ======== ======== ========
-- platform role
-- ======== ======== ======== ========
INSERT INTO e_platform_role (id_, name_, scope_type_, deleted_, created_, updated_) VALUES
    (110, '运营', 1, 0, now(), now()),
    (210, '渠道', 1, 0, now(), now());

-- ======== ======== ======== ========
-- platform group
-- ======== ======== ======== ========
INSERT INTO e_platform_group (id_, name_, short_name_, deleted_, created_, updated_) VALUES
    (110, '运营部', '运营', 0, now(), now()),
    (210, '外部渠道', '渠道', 0, now(), now());

-- ======== ======== ======== ========
-- platform account
-- ======== ======== ======== ========
INSERT INTO e_platform_account (id_, username_, password_, nickname_, role_id_, group_id_, type_, salt_, deleted_, created_, updated_) VALUES
    (110110, 'user1', '$2a$08$Q.sEn3Ey190/Gh17GWoV.uJm0bayX3jNNR95CbFViSywzt/3fZppW', '运营1', 110, 110, 1, '*', 0, now(), now()),
    (210210, 'user2', '$2a$08$Q.sEn3Ey190/Gh17GWoV.uJm0bayX3jNNR95CbFViSywzt/3fZppW', '渠道1', 210, 210, 1, '*', 0, now(), now());

-- ======== ======== ======== ========
-- platform account resource
-- ======== ======== ======== ========
INSERT INTO e_platform_role_resource (role_id_, function_id_) VALUES
    (110, 211), (110, 212), (110, 213), (110, 214),
    (210, 211);

-- ======== ======== ======== ========
-- platform privilege
-- ======== ======== ======== ========
INSERT INTO e_platform_privilege (id_, role_, group_, entity_, field_, operator_, value_, restricted_, deleted_, created_, updated_) VALUES
    (1101, 110, NULL, 'org.ufox.rubik.optimus.archer.business.hotel.entity.Customer', '1', 'EQ', '1', NULL, 0, now(), now()),
    (2104, 210, NULL, 'org.ufox.rubik.optimus.archer.business.hotel.entity.Customer', 'gid', 'EQ', '{gid}', '["mobile"]', 0, now(), now());
