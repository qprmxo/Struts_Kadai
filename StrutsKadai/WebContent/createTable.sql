create table user1(
	id varchar2(5) not null primary key,
	pass varchar2(8),
	name varchar2(40),
	kana varchar2(40)
)

create table userdetail(
	no number(5) not null primary key,
	id varchar2(5) references user1(id),
	birth date,
	club varchar2(40)
)