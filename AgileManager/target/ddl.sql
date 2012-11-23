create table project (id integer not null AUTO_INCREMENT, description varchar(45) not null, name varchar(45) not null, url varchar(45) not null, primary key (id));
create table project_story (project_story_id integer, story_id integer);
create table project_user (user_id integer not null, project_id integer not null, primary key (project_id, user_id));
create table requirement (id integer not null AUTO_INCREMENT, description varchar(255) not null, title varchar(255) not null, primary key (id));
create table story (id integer not null AUTO_INCREMENT, description varchar(45) not null, name varchar(45) not null, primary key (id));
create table story_requirement (story_id integer not null, requirement_id integer not null, primary key (story_id, requirement_id));
create table user (id integer not null AUTO_INCREMENT, email varchar(45) not null, password varchar(45) not null, username varchar(45) not null, primary key (id));
alter table project_story add constraint FKC80F304F70510E04 foreign key (project_story_id) references project;
alter table project_story add constraint FKC80F304F6B2AE17A foreign key (story_id) references story;
alter table project_user add constraint FK38016131DB5D86FA foreign key (project_id) references project;
alter table project_user add constraint FK38016131F7634DFA foreign key (user_id) references user;
alter table story_requirement add constraint FKA9D16BF96B2AE17A foreign key (story_id) references story;
alter table story_requirement add constraint FKA9D16BF968C0EBA foreign key (requirement_id) references requirement;
