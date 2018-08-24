Drop database if exists lineaBlanca;
create database lineaBlanca;
use lineaBlanca;

create table cliente(
	
	Cli_Cedula int AUTO_INCREMENT primary key,
    Cli_Nombre varchar(50),
    Cli_Direccion varchar(30),
    Cli_Telefono varchar(10),
    Cli_email varchar(20)
    );

create table articulo(
	Art_ID int AUTO_INCREMENT primary key,    
	Art_Nombre varchar(10),
	Art_Descripcion varchar(45),
	Art_Precio double,
	Art_Stock integer
    );
    
create table sucursal(
	Local_ID int AUTO_INCREMENT primary key,
	Local_Telefono varchar(10),
	Local_Direccion varchar(45),
	esMatriz boolean,
	esSucursal boolean
    ); 

create table usuario(
	Usua_Codigo int AUTO_INCREMENT primary key,
    Usua_Cedula varchar(10),
    Usua_Nombre varchar(50),
    Usua_Direccion varchar(45),
    Usua_Telefono varchar(15),
    Local_ID int ,
    foreign key(Local_ID) references sucursal(Local_ID)
    );


create table venta(
	Venta_ID int AUTO_INCREMENT primary key,
	Venta_Fecha date,
    Venta_Hora time,
    Venta_Subtotal double,
	Venta_Total double,
    Cliente_ID int,
    Usua_ID int,
    foreign key(Cliente_ID)references cliente(Cli_Cedula),
    foreign key(Usua_ID)references usuario(Usua_Codigo)
    );

create table pagoCredito(
	PC_ID int AUTO_INCREMENT primary key,
    PC_Fecha date,
    PC_Subtotal float,
    PC_Impuestos float,
    PC_PagoCorriente boolean,
    PC_PagoDiferido boolean,
    PC_MesesDiferidos int,
    PC_VentaID int,
    foreign key(PC_VentaID) references venta(Venta_ID)
    );
    
create table pagoEfectivo(
	PE_ID int AUTO_INCREMENT primary key,
    PE_Fecha date,
    PE_Subtotal float,
    PE_Impuestos float,
    PE_VentaID int,
    foreign key(PE_VentaID) references venta(Venta_ID)
    );
    
    
create table detalle_venta(
	Detalle_ID int AUTO_INCREMENT primary key,
	Venta_ID int,
    Articulo_ID int,
    foreign key(Venta_ID)references venta(Venta_ID),
    foreign key(Articulo_ID)references articulo(Art_ID)
    );

create table cotizacion(
	Cot_ID int AUTO_INCREMENT primary key,
    Cot_Fecha date,
    Cot_Valor double,
    Cliente_ID int,
    Usua_Codigo int,
    foreign key(Cliente_ID)references cliente(Cli_Cedula),
    foreign key(Usua_Codigo)references usuario(Usua_Codigo)  
    );
    
create table detalleCotizacion(
	Detalle_ID int AUTO_INCREMENT primary key,
    Cot_ID int,
	Articulo_ID int,
	foreign key(Articulo_ID)references articulo(Art_ID),
    foreign key(Cot_ID)references cotizacion(Cot_ID)
    );

    