create database lineaBlanca;
use lineaBlanca;

create table cliente(
	Cli_Cedula varchar(10) primary key,
    Cli_Nombre varchar(50),
    Cli_Direccion varchar(30),
    Cli_Telefono varchar(10),
    Cli_email varchar(20)
    );

create table articulo(
	Art_ID varchar(10) primary key,    
	Art_Nombre varchar(10),
	Art_Descripcion varchar(45),
	Art_Precio double,
	Art_Stock integer
    );
    
create table sucursal(
	Local_ID varchar(10) primary key,
	Local_Telefono varchar(10),
	Local_Direccion varchar(45),
	esMatriz boolean,
	esSucursal boolean
    ); 

create table vendedor(
	Vend_Codigo varchar(15) primary key,
    Vend_Cedula varchar(10),
    Vend_Nombre varchar(50),
    Vend_Direccion varchar(45),
    Vend_Telefono varchar(15),
    Local_ID varchar(10),
    foreign key(Local_ID) references sucursal.Local_ID
    );

create table modoPago(
	MP_NumPago varchar(10) primary key,
    MP_Nombre varchar(10),
    MP_Descripcion varchar(100)
    );

create table venta(
	Venta_ID varchar(10) primary key,
	Venta_Fecha date,
    Venta_Hora time,
    Venta_Subtotal double,
	Venta_Total double,
    ModoPago_ID varchar(10),
    Cliente_ID varchar(10),
    Vendedor_ID varchar(15),
    foreign key(Cliente_ID)references cliente.Cli_Cedula,
    foreign key(Vendedor_ID)references vendedor.Vend_Codigo,
    foreign key(ModoPago_ID)references modoPago.MP_NumPago
    );
    
create table detalle_venta(
	Detalle_ID varchar(10) primary key,
	Venta_ID varchar(10),
    Articulo_ID varchar(10),
    foreign key(Venta_ID)references venta.Venta_ID,
    foreign key(Articulo_ID)references articulo.Art_ID
    );

create table cotizacion(
	Cot_ID varchar(10) primary key,
    Cot_Fecha date,
    Cot_Valor double,
    Cliente_ID varchar(10),
    Vendedor_ID varchar(15),
    foreign key(Cliente_ID)references cliente.Cli_Cedula,
    foreign key(Vendedor_ID)references vendedor.Vend_Codigo  
    );
    
create table detalleCotizacion(
	Detalle_ID varchar(10),
    Cot_ID varchar(10),
	Articulo_ID varchar(10),
	foreign key(Articulo_ID)references articulo.Art_ID,
    foreign key(Cot_ID)references cotizacion.Cot_ID
    );

    