insert into sys_user(id, user_name, age, email) values('75b8f509-8a62-499c-b936-486992c8bf6d', '小明', 20, 'xiao@example.com');
insert into sys_user(id, user_name, age, email) values('c786dbeb-b538-4f2e-8c6f-30c7a88311dd', '小红', 20, 'hong@example.com');
insert into sys_user(id, user_name, age, email) values('50ce4b8a-1d45-496d-96f3-450b02ea2ed8', 'Richard', 28, 'rich@example.com');

insert into sys_role(id, role_name, enabled) values('6a2bc0ca-e24b-49e4-8940-288af422c9a7', '系统管理员', 1);
insert into sys_role(id, role_name, enabled) values('2b0bf19b-cea1-4101-be8f-980293001016', '普通用户', 1);
insert into sys_role(id, role_name, enabled) values('1d81daa3-de77-438a-abe7-465455106f5d', '开发者', 1);

insert into sys_user_role(user_id, role_id) values('75b8f509-8a62-499c-b936-486992c8bf6d', '6a2bc0ca-e24b-49e4-8940-288af422c9a7');
insert into sys_user_role(user_id, role_id) values('75b8f509-8a62-499c-b936-486992c8bf6d', '2b0bf19b-cea1-4101-be8f-980293001016');
insert into sys_user_role(user_id, role_id) values('50ce4b8a-1d45-496d-96f3-450b02ea2ed8', '6a2bc0ca-e24b-49e4-8940-288af422c9a7');
insert into sys_user_role(user_id, role_id) values('50ce4b8a-1d45-496d-96f3-450b02ea2ed8', '2b0bf19b-cea1-4101-be8f-980293001016');
