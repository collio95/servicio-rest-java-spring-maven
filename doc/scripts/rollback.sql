use PFG_Cliente_Producto;
GO

ALTER TABLE [dbo].[cl_timbre_coordenadas] DROP CONSTRAINT [fk_cldy_tipo_documento];
ALTER TABLE [dbo].[cl_timbre_coordenadas] DROP CONSTRAINT [fk_cldy_imagen];

DROP TABLE dbo.cl_timbre_coordenadas;
DROP TABLE dbo.cl_timbre_tipo_documento;
DROP TABLE dbo.cl_timbre_imagen;

