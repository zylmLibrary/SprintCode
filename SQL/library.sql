create table Reader(
RdId char(9) primary key,
RdName varchar(10) not null,
RdSex nchar(2) not null check(RdSex='ÄÐ' or RdSex='Å®'),
RdPW varchar(10) not null,
)
create table Book(
BKId char(6) primary key,
BKName varchar(10) not null,
BKAuthor varchar(20) not null,
BKPrice float not null ,
BKClassify varchar(30) not null,
BKLocation varchar(30) not null,
BKRessidue int not null,
BKPress varchar(30) not null,
)
create table Admin(
AdId char(9) primary key,
AdName varchar(10) not null,
AdSex nchar(2) not null check(AdSex='ÄÐ' or AdSex='Å®'),
AdPW varchar(10) not null,
)
create table Lend(
RdId char(9) foreign key references Reader(RdId),
BKId char(6) foreign key references Book(BKId),
BT datetime not null,/**borrow time**/
RT datetime not null,/**return time**/
primary key(RdId, BKId),
)
