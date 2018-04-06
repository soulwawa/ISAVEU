create table tbl_temp (
	num  int(7)  not null AUTO_INCREMENT,
	loc varchar(10) not null,
	type varchar(2) not null,
	temperature varchar(7),
	idate datetime DEFAULT now(),
	PRIMARY key( num)
);


show tables;
insert into tbl_temp values(null, 'pos1', 'T', '24.51', now() );
select * from tbl_temp;