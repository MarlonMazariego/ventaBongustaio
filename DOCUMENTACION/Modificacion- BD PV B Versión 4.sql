-- Modificaciones:

-- 1. Tabla Detalle de producto: adición de campo valor_en_inv (valor de cada producto en el inventario total)

create table if not exists tbDetalleProducto(
id_detalleProd int not null primary key auto_increment,
id_proveedor int,
id_producto int,
id_sucursal int,
id_usuario int,
unidades_recibidas int,
fecha_hora timestamp default current_timestamp,
comentarios varchar(100),
constraint fk_proveedor_detalle_prod foreign key(id_proveedor) references tbProveedor(id_proveedor),
constraint fk_producto_detalle_prod foreign key (id_producto) references tbProducto(id_producto),
constraint fk_sucursal_detalle_prod foreign key (id_sucursal) references tbSucursal(id_sucursal),
constraint fk_usuario_detalle_prod foreign key (id_usuario) references tbUsuario(id_usuario)
)engine InnoDB;

-- 2. Creación de tabla de movimientos (para el cálculo del gap)

create table if not exists tbMovimiento(
id_movimiento int not null primary key auto_increment,
monto decimal(18,2),
tipo tinyint(1),
fecha date
)engine InnoDB;