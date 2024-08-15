CREATE DATABASE homework_ss2_1;

use homework_ss2_1;

create table VATTU(
	MaVTU int primary key,
    tenVTU varchar(50)
);

create table PHIEUXUAT(
	SoPX int primary key,
    NgayXuat date
);

create table PHIEUNHAP(
	SoPN int primary key,
    NgayNhap date
);

create table CHITIETPHIEUXUAT(
	SoPX int,
    MaVTU int,
	DGXuat bigint,
    SLXuat int,
    primary key(SoPX, MaVTU),
    foreign key(SoPX) references PHIEUXUAT(SoPX),
    foreign key(MaVTU) references VATTU(MaVTU)
);

create table CHITIETPHIEUNHAP(
	SoPN int,
    MaVTU int,
	DGNhap bigint,
    SLNhap int,
    primary key(SoPN, MaVTU),
    foreign key(SoPN) references PHIEUNHAP(SoPN),
    foreign key(MaVTU) references VATTU(MaVTU)
);

create table DONDH(
	SoDH int primary key,
    NgayDH date
);

create table CHITIETDONDH(
	MaVTU int,
    SoDH int,
    primary key(MaVTU, SoDH),
    foreign key(MaVTU) references VATTU(MaVTU), 
    foreign key(SoDH) references DONDH(SoDH) 
);

create table NHACC(
	MaNCC int primary key,
    TenNCC varchar(50),
    DiaChi varchar(255),
    SDT varchar(255)
);

create table CUNGCAP(
	MaNCC int,
    SoDH int,
    primary key(MaNCC, SoDH),
    foreign key(MaNCC) references NHACC(MaNCC),
    foreign key(SoDH) references DONDH(SoDH)
);

