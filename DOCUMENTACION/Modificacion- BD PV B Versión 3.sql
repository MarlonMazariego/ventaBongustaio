
-- Modificación de tablas agregando el campo estado varchar(50)

--Ejecutar el siguiente script para ejecutar los cambios en las tablas
alter table tbPedido add estado varchar(50);
alter table  tbProducto add estado varchar(50);

create table if not exists tbProducto(
id_producto int not null primary key auto_increment,
nombre_producto varchar(60),
descripcion varchar(100),
unidad_medida varchar(5),
id_subCategoria int,
stock_min int,
existencias int,
stock_max int,
costo_unitario decimal(18,2),
estado varchar(50),
constraint fk_subCategoria_producto foreign key(id_subCategoria) references tbscaPlatillo(id_subCategoria)
)engine InnoDB;

create table if not exists tbPedido(
id_pedido int not null primary key auto_increment,
cant_producto int,
fecha_hora timestamp default current_timestamp,
id_proveedor int,
id_producto int,
id_sucursal int,
id_usuario int,
comentarios varchar(100),
estado varchar(50),
constraint fk_proveedor_pedido foreign key(id_proveedor) references tbProveedor(id_proveedor),
constraint fk_producto_pedido foreign key(id_producto) references tbProducto(id_producto),
constraint fk_sucursal_pedido foreign key(id_sucursal) references tbSucursal(id_sucursal),
constraint fk_usuario_pedido foreign key(id_usuario) references tbUsuario(id_usuario)
)engine InnoDB;
