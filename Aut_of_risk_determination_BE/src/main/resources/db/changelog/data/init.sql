-- user role
INSERT INTO aord.user_role (name) VALUES ('ROLE_ADMIN');
INSERT INTO aord.user_role (name) VALUES ('ROLE_USER');

COMMIT;

-- user
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_admin@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 1);
INSERT INTO aord.user (email, password, user_role_id) VALUES ('test_user@test.com', '$2a$10$VxlWOf3zYB994.HssX.TteM4NgOUiB0CkREYsvIWEyBgQjuJ.8PPW', 2);

COMMIT;