-- Departamentos (2 dígitos)
CREATE TABLE IF NOT EXISTS departamento (
  codigo CHAR(2) PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

-- Provincias (4 dígitos)
CREATE TABLE IF NOT EXISTS provincia (
  codigo CHAR(4) PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  departamento_codigo CHAR(2) NOT NULL REFERENCES departamento(codigo)
);

-- Distritos (6 dígitos)
CREATE TABLE IF NOT EXISTS distrito (
  codigo CHAR(6) PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  provincia_codigo CHAR(4) NOT NULL REFERENCES provincia(codigo)
);

-- Índices
CREATE INDEX IF NOT EXISTS ix_prov_dep ON provincia (departamento_codigo);
CREATE INDEX IF NOT EXISTS ix_dist_prov ON distrito (provincia_codigo);
