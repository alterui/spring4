create table sys_user(
	id BIGINT not null auto_increment comment '用户ID',
	user_name  varchar(50) COMMENT '用户名',
	user_password VARCHAR(50) COMMENT '密码',
	user_email   VARCHAR(50) COMMENT '邮箱',
	user_info text COMMENT '简介',
	head_img blob  COMMENT '头像',
	create_time  datetime COMMENT '创建时间',
	PRIMARY key(id)
	);
	ALTER TABLE sys_user COMMENT '用户表';


	create TABLE sys_role(
	id BIGINT NOT NULL auto_increment COMMENT '角色ID',
	role_name  VARCHAR(50) COMMENT  '角色名',
	enabled  int COMMENT '有效标志',
	create_by  BIGINT COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	PRIMARY key(id)
	);
	ALTER TABLE sys_role COMMENT '角色名';


	CREATE TABLE sys_privilege(
		id  BIGINT not null auto_increment comment '权限ID',
		privilege_name VARCHAR(50) COMMENT '权限名称',
		privilege_url VARCHAR(200) COMMENT '权限URL',
		PRIMARY key(id)
	);
	ALTER  TABLE sys_privilege COMMENT '权限表';


	CREATE TABLE  sys_user_role(
		user_id  BIGINT COMMENT '用户ID',
		role_id  BIGINT  comment '角色ID'
	);
	ALTER TABLE sys_user_role COMMENT '用户角色关联表';


	CREATE TABLE sys_role_privilege(
		role_id  BIGINT comment '角色ID',
		privilege_id  BIGINT  COMMENT '权限ID'

	);
	ALTER table sys_role_privilege COMMENT '角色权限关联表'



	INSERT INTO sys_user VALUES ('1','admin','123456','admin@mysql.tk','管理员',null,now());
	INSERT INTO sys_user VALUES ('1001','test','123456','test@mysql.tk','测试用户',null,now());

	insert into sys_role VALUES('1','管理员','1','1',now());
	insert into sys_role VALUES('2','普通用户','1','1',now());


INSERT INTO sys_user_role VALUES('1','1');
INSERT INTO sys_user_role VALUES('1','2');
INSERT INTO sys_user_role VALUES('1001','2');


INSERT INTO sys_privilege VALUES('1','用户管理','/users');
INSERT INTO sys_privilege VALUES('2','角色管理','/roles');
INSERT INTO sys_privilege VALUES('3','系统日志','/logs');
INSERT INTO sys_privilege VALUES('4','人员维护','/persons');
INSERT INTO sys_privilege VALUES('5','单位维护','/companies');

INSERT INTO sys_role_privilege VALUES('1','1');
INSERT INTO sys_role_privilege VALUES('1','3');
INSERT INTO sys_role_privilege VALUES('1','2');
INSERT INTO sys_role_privilege VALUES('2','4');
INSERT INTO sys_role_privilege VALUES('2','5');


SELECT u.id
FROM sys_user u
INNER JOIN sys_user_role ur ON u.id = ur.user_id
INNER JOIN sys_role r ON ur.role_id = r.id
WHERE u.id = 1


SELECT *
FROM sys_user a
LEFT JOIN sys_role b
ON a.id = b.enabled
where a.id = 1


SELECT *
FROM sys_user


























