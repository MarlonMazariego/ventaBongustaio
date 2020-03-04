create database if not exists trabajo;
use trabajo;
create table if not exists tipo_sucursal (
id_tipo_sucursal int not null primary key,
nombre varchar (50)
)engine innodb;

create table if not exists cargo(
id_cargo int not null primary key,
cargo varchar(50)
)engine innodb;

create table if not exists persona(
 id_persona int not null primary key,
nombre varchar(50),
apellido varchar(50),
DUI varchar(10),
NIt varchar(16),
edad int,
telefon varchar(15),
direccion varchar(300),
email varchar(80),
genero enum('M', 'F'),
fecha_ingreso date,
id_cargo int not null,
constraint fk_id_cargo foreign key (id_cargo) references cargo(id_cargo) 
)engine innodb;

create table if not exists sucursal(
id_sucursal int not null primary key,
n_sucursal varchar(50),
id_persona int not null,
direccion varchar(50),
telefono varchar(15),
fecha_creacion date,
capital_inicial decimal(18,2),
constraint fk_id_persona foreign key (id_persona) references persona(id_persona) 
)engine innodb;
-- ------------------------------------------------------------------------------------------------------------------ ok 

create table if not exists rol_usuario(
 id_rolesUsuario int not null primary key,
 rolesUsuario varchar(50)
)engine innodb;

create table if not exists usuario (
id_usuario int not null primary key,
nickname varchar(50),
pass varchar(50),
id_persona int,
id_rolesUsuario int,
id_sucursal int,
constraint fk_id_per foreign key (id_persona) references persona(id_persona),
constraint fk_id_rolesUsuario foreign key (id_rolesUsuario) references rol_usuario(id_rolesUsuario),
constraint fk_id_sucursal foreign key (id_sucursal) references sucursal(id_sucursal) 
)engine innodb;

create table if not exists registro_inicial (
id_registro int not null primary key,
inv_inicial int,
id_usuario int not null,
fecha_login date,
hora_login time,
constraint fk_id_usuario foreign key (id_usuario) references usuario (id_usuario) 
)engine innodb;

-- ------------------------------------------------------------------------------------ ok

create table if not exists proveedor(
 id_proveedor int not null primary key,
 nombre varchar(50),
 NIT varchar(16),
 telefono varchar(15),
 direccion varchar(300),
 email varchar(80)
)engine innodb;

create table if not exists sub_categoria(
id_subCategoria int not null primary key,
tipo varchar(30)
)engine innodb;


create table if not exists producto(
 id_producto int not null primary key,
nombre_producto varchar(60),
descripcion varchar(100),
unidad_medida varchar(5),
id_subCategoria int,
costo_unitario decimal(18,2),
constraint fk_id_subCategoria foreign key (id_subCategoria) references sub_categoria(id_subCategoria) 
)engine innodb;

-- -------------------------------------------------------------------------------------------- ok

create table if not exists detalle_producto(
id_detalle int not null primary key,	
stock_min	int,
stock_max	int,
existencias	int,
id_proveedor int,
id_producto	int,
id_sucursal	int,
id_persona	int,
comentarios	varchar(100),
constraint fk_id_proveedor foreign key ( id_proveedor) references proveedor( id_proveedor) ,
constraint fk_id_producto foreign key (id_producto) references producto(id_producto) ,
constraint fk_id_sucursal_dp foreign key (id_sucursal) references sucursal(id_sucursal) ,
constraint fk_id_persona_dp foreign key (id_persona) references persona(id_persona) 

)engine innodb;

create table if not exists pedido_proveedor(
id_pedidoProveedor int not null primary key,
cant_pedido int,
fecha_pedido date,
id_proveedor int,
id_producto int,
id_sucursal int,
id_persona int,
comentarios varchar(100),
constraint fk_id_proveedor_pp foreign key(id_proveedor) references proveedor(id_proveedor),
constraint fk_id_producto_pp foreign key(id_producto) references producto(id_producto),
constraint fk_id_sucursal_pp foreign key(id_sucursal) references sucursal(id_sucursal),
constraint fk_id_persona_pp foreign key(id_persona) references persona(id_persona)
)engine innodb;

create table if not exists tipo_platillo(
id_tipoPlatillo int not null primary key,
tipo varchar(30),
id_sucursal int,
constraint fk_id_sucursal_tp foreign key (id_sucursal) references sucursal(id_sucursal)
)engine innodb;

create table if not exists sub_categorias_platillos(
id_subCatPla int not null primary key,
tipo varchar(30),
id_tipoPlatillo int,
constraint fk_id_tipoPlatillo foreign key (id_tipoPlatillo) references tipo_platillo(id_tipoPlatillo)
)engine innodb;

create table if not exists platillo(
id_platillo int not null primary key,
nombre_platillo varchar(60),
precio_platillo decimal(18,2),
costo_platillo decimal(18,2),
id_subCatPla int,
constraint fk_id_subCatPla foreign key (id_subCatPla) references sub_categorias_platillos(id_subCatPla)
)engine innodb;

create table if not exists detalle_platillo(
id_detallePlatillo int not null primary key,
id_platillo int,
id_producto int,
cantidad_producto int,
constraint fk_id_platillo foreign key(id_platillo) references platillo(id_platillo),
constraint fk_id_producto_dp foreign key(id_producto) references producto(id_producto)
)engine innodb;

create table if not exists tipo_bebida(
id_tipoBebida int not null primary key,
tipo varchar(30)
)engine innodb;

create table if not exists bebida(
id_bebida int not null primary key,
nombre_bebida varchar(50),
id_tipoBebida int,
costo_bebida decimal(18,2),
precio_bebida decimal(18,2),
cantidad_producto int,
constraint fk_id_tipoBebida foreign key(id_tipoBebida) references tipo_bebida(id_tipoBebida)
)engine innodb;

create table if not exists tipo_complemento(
id_tipoCom int not null primary key,
tipo varchar(50)
)engine innodb;

create table if not exists complemento(
id_complemento int not null primary key,
nombre_complemento varchar(50),
id_tipoCom int,
costo_com decimal(18,2),
precio_com decimal(18,2),
cantidad_producto int,
constraint fk_id_tipoCom foreign key(id_tipoCom) references tipo_complemento(id_tipoCom)
)engine innodb;

create table if not exists venta(
id_venta int not null primary key,
nombre_cliente varchar(80),
dui_carnet varchar(20),
nit varchar(16),
dir varchar(300),
tel varchar(15),
id_usuario int,
id_sucursal int,
tipo_pago enum('Tarjeta crédito', 'Débito', 'Efectivo', 'Cheque'),
fecha_venta date,
constraint fk_id_usuario_v foreign key (id_usuario) references usuario(id_usuario),
constraint fk_id_sucursal_v foreign key (id_sucursal) references sucursal(id_sucursal)
)engine innodb;

create table if not exists detalle_venta(
id_detalleVenta int not null primary key,
id_venta int,
id_platillo int,
id_bebida int,
id_complemento int,
venta_total decimal(18,2),
constraint fk_id_venta foreign key(id_venta) references venta(id_venta),
constraint fk_id_platillo_dv foreign key(id_platillo) references platillo(id_platillo),
constraint fk_id_bebida foreign key (id_bebida) references bebida(id_bebida),
constraint fk_id_complemento foreign key(id_complemento) references complemento(id_complemento)
)engine innodb;

-- Tabla aún en observación
create table if not exists cierre(
id_cierre int not null primary key,
monto_vendido decimal(18,2),
id_venta int,
constraint fk_id_venta_c foreign key (id_venta) references venta(id_venta)
)engine innodb;


