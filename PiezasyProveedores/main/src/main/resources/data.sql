CREATE TABLE IF NOT EXISTS piezas(
id_pieza int auto_increment primary key,
nombre varchar(100)
);

CREATE TABLE IF NOT EXISTS proveedores(
id_prov int auto_increment primary key,
nombre varchar(100)
);

CREATE TABLE IF NOT EXISTS suministra(
id_pieza int,
id_prov int,
precio int,
foreign key(id_pieza) references piezas(id_pieza),
foreign key(id_prov) references proveedores(id_prov),
primary key (id_pieza, id_prov)
);