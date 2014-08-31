if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ALTERNATIVO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ALTERNATIVO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ARTICULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ARTICULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ARTICULOSNUMERADOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ARTICULOSNUMERADOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ARTXLOCAL]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ARTXLOCAL]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ARTXLOCALLINEA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ARTXLOCALLINEA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ATRIBUTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ATRIBUTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[BITACORA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[BITACORA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CARTOLA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CARTOLA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CARTOLAVALORIZADA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CARTOLAVALORIZADA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CODIGOBARRAART]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CODIGOBARRAART]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CONDUCCION]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CONDUCCION]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CORRELATIVONUMERADOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CORRELATIVONUMERADOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPOABONOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPOABONOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPOARCHIVOPLANO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPOARCHIVOPLANO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPOCLA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPOCLA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPODOCTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPODOCTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPONOMINAPAGO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPONOMINAPAGO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CPOROTULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CPOROTULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTAABONOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTAABONOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTABOLETIN]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTABOLETIN]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTACLA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTACLA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTACREDITO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTACREDITO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTADOCTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTADOCTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[CTAROTULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[CTAROTULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DATOSCLIENTE]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DATOSCLIENTE]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DESCUENTORECARGO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DESCUENTORECARGO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DETALLEDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DETALLEDOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ENCABEZADOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ENCABEZADOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FACTURACION]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[FACTURACION]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FACTURACIONDES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[FACTURACIONDES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FOLIOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[FOLIOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FORMATO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[FORMATO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GEVCLA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GEVCLA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GEVROTULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GEVROTULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HCTADOCTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HCTADOCTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HDATOSCLIENTE]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HDATOSCLIENTE]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HDESCUENTORECARGO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HDESCUENTORECARGO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HDETALLEDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HDETALLEDOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HENCABEZADOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HENCABEZADOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HTOTALDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HTOTALDOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVCLA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVCLA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVDETALLEPARTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVDETALLEPARTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVENCABEZAPARTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVENCABEZAPARTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVHDETALLEPARTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVHDETALLEPARTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVHENCABEZAPARTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVHENCABEZAPARTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[INVROTULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[INVROTULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[KIT]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[KIT]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MATRIZ]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MATRIZ]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MONEDA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MONEDA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOCLIENTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOCLIENTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOGENERAL]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOGENERAL]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOSTCOMPRAS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOSTCOMPRAS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOSTCOMPRASILA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOSTCOMPRASILA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOSTLOCAL]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOSTLOCAL]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOSTTABLAS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOSTTABLAS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOSTVENTASILA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOSTVENTASILA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSOVENDEDOR]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSOVENDEDOR]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MSROTULO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MSROTULO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NUMERADOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[NUMERADOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PARAMETROS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PARAMETROS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOARTXLOCAL]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOARTXLOCAL]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOCPOABONOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOCPOABONOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOCTAABONOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOCTAABONOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASODATOSCLIENTE]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASODATOSCLIENTE]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASODESCUENTORECARGO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASODESCUENTORECARGO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASODETALLEDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASODETALLEDOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASODETALLEDOCUMENTOG]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASODETALLEDOCUMENTOG]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOENCABEZADOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOENCABEZADOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOESTES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOESTES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOPRECIOSCOSTOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOPRECIOSCOSTOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PASOTOTALDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PASOTOTALDOCUMENTO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PRECIOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PRECIOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PRECIOSCOSTOS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PRECIOSCOSTOS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[RANKING]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[RANKING]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[REPORTERUTADIARIA]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[REPORTERUTADIARIA]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[STOCKMINIMO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[STOCKMINIMO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[TABLAPASO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[TABLAPASO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[TOMAINVENTARIO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[TOMAINVENTARIO]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[TOTALDOCUMENTO]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[TOTALDOCUMENTO]
GO

CREATE TABLE [dbo].[ALTERNATIVO] (
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Alternativo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [int] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ARTICULO] (
	[Unidad] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ItemGasto] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Activo] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ganado] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Familia] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[VentaBruto] [money] NULL ,
	[VentaNeto] [money] NULL ,
	[CentroCosto] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[Costo] [money] NULL ,
	[Importado] [bit] NULL ,
	[Nivel] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoEconomico] [money] NULL ,
	[Moneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Inicio] [datetime] NULL ,
	[StockMinimo] [float] NULL ,
	[DescuentoPromocional] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[DescuentoInicio] [datetime] NULL ,
	[DescuentoFinal] [datetime] NULL ,
	[Ubicacion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[CodigoIla] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[PorcIla] [float] NULL ,
	[MonedaImportado] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ConversionVolumen] [float] NULL ,
	[Auxiliar] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CtaResultado] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Kit] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Imagen] [varchar] (100) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comision] [smallmoney] NULL ,
	[ImpuestoEspecifico] [smallmoney] NULL ,
	[PorcCarne] [float] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[UnidadDeVenta] [bit] NULL ,
	[Equivalencia] [smallmoney] NULL ,
	[unidadAdicional] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[UnidadDeDigitacion] [bit] NULL ,
	[CostoCentro] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoCuenta] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoAuxiliar] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoItem] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[StockRealOTROTIPO] [money] NULL ,
	[StockReal] [float] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ARTICULOSNUMERADOS] (
	[articulo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ARTXLOCAL] (
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[StockInicial] [money] NULL ,
	[StockCalculo] [money] NULL ,
	[Kardex] [int] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Stock] [money] NULL ,
	[Salida] [datetime] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ARTXLOCALLINEA] (
	[Stockinicial] [int] NULL ,
	[Stock] [int] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Iden] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ATRIBUTO] (
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[BITACORA] (
	[Criterio] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[FechaMOv] [datetime] NULL ,
	[Numero] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Computador] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tabla] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Clave] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Sistema] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Hora] [datetime] NULL ,
	[Fecha] [datetime] NULL ,
	[Formulario] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CARTOLA] (
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Entrada] [money] NULL ,
	[Origen] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[StockInicial] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Iden] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Salida] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Destino] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CARTOLAVALORIZADA] (
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[StockInicial] [money] NULL ,
	[SaldoDH] [money] NULL ,
	[Haber] [money] NULL ,
	[Debe] [money] NULL ,
	[Costo] [money] NULL ,
	[PrecioUnCompra] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Iden] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Origen] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Destino] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Entrada] [money] NULL ,
	[Salida] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CODIGOBARRAART] (
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Impresora] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[Puerto] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Velocidad] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Temperatura] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Retardo] [money] NULL ,
	[Linea] [varchar] (60) COLLATE Modern_Spanish_CI_AS NULL ,
	[Secuencia] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CONDUCCION] (
	[codigo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[ruta] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[precio] [int] NULL ,
	[articulo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CORRELATIVONUMERADOS] (
	[Id] [int] NULL ,
	[correlativo] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPOABONOS] (
	[cancela] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[abonomon] [money] NULL ,
	[cargomon] [money] NULL ,
	[codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[AbonoTotal] [bit] NULL ,
	[cargo1] [money] NULL ,
	[abono] [money] NULL ,
	[cargo] [money] NULL ,
	[correlativo] [smallint] NULL ,
	[numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPOARCHIVOPLANO] (
	[BANCO] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[LINEA] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[TABLA] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[CAMPO] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[LARGO] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[INICIO] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[CABECERA] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPOCLA] (
	[usuario] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[password] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave1] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave2] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave3] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave4] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[atributo1] [bit] NULL ,
	[atributo2] [bit] NULL ,
	[atributo3] [bit] NULL ,
	[atributo4] [bit] NULL ,
	[cantidadfilas] [int] NULL ,
	[MargenIzquierdo] [tinyint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPODOCTO] (
	[Mesdeclaracion] [varchar] (6) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha_ingreso] [datetime] NULL ,
	[Correlativo] [smallint] NULL ,
	[Glosa] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[CentroCosto] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha_vencimiento] [datetime] NULL ,
	[fecha_inicial] [datetime] NULL ,
	[Rut_Provee] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Moneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[FechaD] [datetime] NULL ,
	[Valor_brutomon] [money] NULL ,
	[Valor_ExentoMon] [money] NULL ,
	[Valor_NetoMon] [money] NULL ,
	[Valor_Ilamon] [money] NULL ,
	[Valor_ivamon] [money] NULL ,
	[Valor_IvaImportacionMon] [money] NULL ,
	[ImpuestoespMon] [money] NULL ,
	[codigo_Provee] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[Retencionmon] [money] NULL ,
	[Valor_Importacion] [money] NULL ,
	[Valor_ImportacionMon] [money] NULL ,
	[TipoFactura] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor_IvaImportacion] [money] NULL ,
	[Valor_abonoMon] [money] NULL ,
	[valor_iva] [money] NULL ,
	[banco] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[estado] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[vigencia] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[cambio] [datetime] NULL ,
	[valor_bruto] [money] NULL ,
	[valor_exento] [money] NULL ,
	[FechaR] [datetime] NULL ,
	[valor_ila] [money] NULL ,
	[fueraPlazo] [bit] NULL ,
	[valor_abono] [money] NULL ,
	[Porc_Rete] [tinyint] NULL ,
	[LitrosComb] [float] NULL ,
	[ImpuestoEsp] [money] NULL ,
	[Retencion] [float] NULL ,
	[cancela] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[FechaC] [datetime] NULL ,
	[valor_neto] [money] NULL ,
	[emitido] [bit] NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Folio] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPONOMINAPAGO] (
	[ValorPago] [money] NULL ,
	[ValorBruto] [money] NULL ,
	[Sucursal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorAbono] [money] NULL ,
	[Pago] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorNeto] [money] NULL ,
	[Emision] [datetime] NULL ,
	[Glosa] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Banco] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comentario] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[FechaPago] [datetime] NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorIva] [money] NULL ,
	[Vence] [datetime] NULL ,
	[Egreso] [varchar] (6) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CPOROTULO] (
	[serie] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[empresa] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[sigla] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[giro] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutemp] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutrepleg] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[nomrepleg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[version] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechaver] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombregg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulogg] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombrecon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulocon] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechadeldia] [datetime] NULL ,
	[TempField0] [bit] NULL ,
	[tipoCuenta] [bit] NULL ,
	[yearProceso] [smallint] NULL ,
	[yearActual] [smallint] NULL ,
	[yearSgte] [smallint] NULL ,
	[titulo1] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulo2] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre1] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre2] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[valorIVA] [smallmoney] NULL ,
	[EmpresaConstructora] [bit] NULL ,
	[ImpEspecifico] [bit] NULL ,
	[ImpuestoEspecifico] [money] NULL ,
	[FoliosInternos] [bit] NULL ,
	[ILA] [bit] NULL ,
	[ConectaCompVtas] [bit] NULL ,
	[PathDos] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cancelacion] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[ConeccionContabilidad] [bit] NULL ,
	[folioUnico] [bit] NULL ,
	[FacturaImportacion] [bit] NULL ,
	[MonedaTrabajo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaAlternativa] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaLocal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[DobleMoneda] [bit] NULL ,
	[Retencion] [tinyint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTAABONOS] (
	[cancela] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[AbonoTotal] [bit] NULL ,
	[saldo] [money] NULL ,
	[saldomon] [money] NULL ,
	[abono] [money] NULL ,
	[abonomon] [money] NULL ,
	[cargo] [money] NULL ,
	[cargomon] [money] NULL ,
	[correlativo] [smallint] NULL ,
	[numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[rut] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTABOLETIN] (
	[Rut] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Situacion] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Monto] [money] NULL ,
	[Fecha] [datetime] NULL ,
	[Boletin] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Carpeta] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTACLA] (
	[usuario] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[password] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave1] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave2] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave3] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave4] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[atributo1] [bit] NULL ,
	[atributo2] [bit] NULL ,
	[atributo3] [bit] NULL ,
	[atributo4] [bit] NULL ,
	[cantidadfilas] [int] NULL ,
	[MargenIzquierdo] [tinyint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTACREDITO] (
	[MasDatos] [text] COLLATE Modern_Spanish_CI_AS NULL ,
	[Compra] [money] NULL ,
	[RepLegal] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Observacion3] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[NotasPedido] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Observacion1] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comite] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Observacion2] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fax] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Condicion] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vendedor] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha] [datetime] NULL ,
	[Fonos] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Carpeta] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTADOCTO] (
	[Rut_cliente] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha_vencimiento] [datetime] NULL ,
	[boleta_hasta] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo_cliente] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[comision] [smallmoney] NULL ,
	[PorcRecuperacion] [smallmoney] NULL ,
	[Recuperacion] [money] NULL ,
	[emitido] [bit] NULL ,
	[vigente] [bit] NULL ,
	[fueraPlazo] [bit] NULL ,
	[FechaC] [datetime] NULL ,
	[FechaP] [datetime] NULL ,
	[FechaR] [datetime] NULL ,
	[FechaE] [datetime] NULL ,
	[FechaD] [datetime] NULL ,
	[glosa_directa] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[ImpuestoEspecifico] [money] NULL ,
	[LitrosCombustible] [float] NULL ,
	[Valor_ExentoMOn] [money] NULL ,
	[Valor_NetoMOn] [money] NULL ,
	[Valor_IlaMon] [money] NULL ,
	[Valor_IvaMon] [money] NULL ,
	[Valor_AbonoMon] [money] NULL ,
	[RecuperacionMon] [money] NULL ,
	[ImpuestoEspecificoMon] [money] NULL ,
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[Moneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[cambio] [datetime] NULL ,
	[banco] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor_BrutoMon] [money] NULL ,
	[deuda_directa] [bit] NULL ,
	[fecha_ingreso] [datetime] NULL ,
	[fecha_inicial] [datetime] NULL ,
	[vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[plaza] [bit] NULL ,
	[ciudad] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[glosa] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[estado] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[vigencia] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[rut_endoso] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[cancela] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo_endoso] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre_endoso] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor_abono] [money] NULL ,
	[valor_bruto] [money] NULL ,
	[valor_iva] [money] NULL ,
	[valor_exento] [money] NULL ,
	[valor_neto] [money] NULL ,
	[valor_ila] [money] NULL ,
	[cartola] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[local_venta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Correlativo] [smallint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CTAROTULO] (
	[serie] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[empresa] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[sigla] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[giro] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutemp] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutrepleg] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[nomrepleg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[version] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechaver] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombregg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulogg] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombrecon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulocon] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechadeldia] [datetime] NULL ,
	[titulo1] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulo2] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre1] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre2] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[valorIVA] [smallmoney] NULL ,
	[EmpresaConstructora] [bit] NULL ,
	[ILA] [bit] NULL ,
	[ConectaCompVtas] [bit] NULL ,
	[Cancelacion] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[ConeccionContabilidad] [bit] NULL ,
	[tipoCuenta] [bit] NULL ,
	[yearActual] [smallint] NULL ,
	[yearProceso] [smallint] NULL ,
	[yearSgte] [smallint] NULL ,
	[ImpEspecifico] [bit] NULL ,
	[FoliosInternos] [bit] NULL ,
	[folioUnico] [bit] NULL ,
	[PathDos] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Doblemoneda] [bit] NULL ,
	[MonedaLocal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaTrabajo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaAlternativa] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ImpuestoEspecifico] [money] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DATOSCLIENTE] (
	[Telefono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Despacho] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionCobrador] [money] NULL ,
	[Ruta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Transporte] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ciudad] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Lista] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Dias] [smallint] NULL ,
	[CondicionVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionVendedor] [money] NULL ,
	[Giro] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DESCUENTORECARGO] (
	[Monto] [money] NULL ,
	[ValorMOn] [money] NULL ,
	[tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor] [money] NULL ,
	[MontoMon] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DETALLEDOCUMENTO] (
	[PrecioVenta] [money] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Subpedido] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioCostoMOn] [money] NULL ,
	[PrecioVentaMon] [money] NULL ,
	[TotalLineaMOn] [money] NULL ,
	[TotalLinea] [money] NULL ,
	[Paridad] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Variacion] [money] NULL ,
	[Alternativo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[DatosKit] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParidadMOn] [money] NULL ,
	[Cantidad] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ENCABEZADOCUMENTO] (
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Subpedido] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[NetooBruto] [bit] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Vence] [datetime] NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[OrdenCompra] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Factura] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[AfectoExento] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[traspasado] [bit] NULL ,
	[LocalDes] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Impreso] [bit] NULL ,
	[Comentario] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[FueraPlazo] [bit] NULL ,
	[TipoRelacionador] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[NumeroRelacionador] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vigente] [bit] NULL ,
	[Emitido] [bit] NULL ,
	[Facturado] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[FacturaAnticipo] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoMoneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[FACTURACION] (
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[NetooBruto] [bit] NULL ,
	[Iden] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[FACTURACIONDES] (
	[Tipo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor] [money] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Monto] [money] NULL ,
	[Iden] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[FOLIOS] (
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[FORMATO] (
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Nombre] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Texto] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Mm1] [smallmoney] NULL ,
	[Mm2] [smallmoney] NULL ,
	[Imprimir] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Largo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Letra] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Decimal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Separacion] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[LargoDoc] [smallmoney] NULL ,
	[AnchoDoc] [smallmoney] NULL ,
	[Sensor] [bit] NULL ,
	[Lineas] [smallint] NULL ,
	[SeparacionLineas] [smallmoney] NULL ,
	[FormularioContinuo] [bit] NULL ,
	[Cantidad] [int] NULL ,
	[Impresora] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoFecha] [tinyint] NULL ,
	[MM2dia] [smallmoney] NULL ,
	[MM2mes] [smallmoney] NULL ,
	[MM2año] [smallmoney] NULL ,
	[Matriz] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[SeparacionTallas] [smallmoney] NULL ,
	[Ila15] [smallmoney] NULL ,
	[Ila1] [smallmoney] NULL ,
	[Ila14] [smallmoney] NULL ,
	[Ila2] [smallmoney] NULL ,
	[Ila11] [smallmoney] NULL ,
	[Ila3] [smallmoney] NULL ,
	[Ila12] [smallmoney] NULL ,
	[Ila10] [smallmoney] NULL ,
	[ImprimeDescripcion] [bit] NULL ,
	[Ila9] [smallmoney] NULL ,
	[Ila8] [smallmoney] NULL ,
	[Ila7] [smallmoney] NULL ,
	[Ila6] [smallmoney] NULL ,
	[Ila5] [smallmoney] NULL ,
	[Ila4] [smallmoney] NULL ,
	[Ila13] [smallmoney] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ancho] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GEVCLA] (
	[usuario] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[password] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave1] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave2] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave3] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave4] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave5] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[cantidadfilas] [int] NULL ,
	[MargenIzquierdo] [tinyint] NULL ,
	[Atributo1] [bit] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GEVROTULO] (
	[fechadeldia] [datetime] NULL ,
	[Serie] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[RefundeGuias] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[ConeccionContabilidad] [bit] NULL ,
	[ConeccionCambiaCuentas] [bit] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HCTADOCTO] (
	[Valor_IlaMon] [money] NULL ,
	[cambio] [datetime] NULL ,
	[LitrosCombustible] [float] NULL ,
	[FechaD] [datetime] NULL ,
	[ImpuestoEspecifico] [money] NULL ,
	[Valor_BrutoMon] [money] NULL ,
	[Valor_ExentoMOn] [money] NULL ,
	[Valor_NetoMOn] [money] NULL ,
	[Valor_IvaMon] [money] NULL ,
	[Valor_AbonoMon] [money] NULL ,
	[RecuperacionMon] [money] NULL ,
	[ImpuestoEspecificoMon] [money] NULL ,
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor_exento] [money] NULL ,
	[FechaE] [datetime] NULL ,
	[Moneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha_inicial] [datetime] NULL ,
	[FechaR] [datetime] NULL ,
	[estado] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[glosa] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[banco] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[plaza] [bit] NULL ,
	[local_venta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[cartola] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[rut_endoso] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[fecha_vencimiento] [datetime] NULL ,
	[fecha_ingreso] [datetime] NULL ,
	[codigo_cliente] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut_cliente] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor_bruto] [money] NULL ,
	[boleta_hasta] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor_ila] [money] NULL ,
	[cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[deuda_directa] [bit] NULL ,
	[FechaP] [datetime] NULL ,
	[FechaC] [datetime] NULL ,
	[fueraPlazo] [bit] NULL ,
	[vigente] [bit] NULL ,
	[emitido] [bit] NULL ,
	[Recuperacion] [money] NULL ,
	[PorcRecuperacion] [smallmoney] NULL ,
	[vigencia] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[glosa_directa] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[cancela] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor_abono] [money] NULL ,
	[valor_iva] [money] NULL ,
	[valor_neto] [money] NULL ,
	[nombre_endoso] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo_endoso] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[comision] [smallmoney] NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Correlativo] [smallint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HDATOSCLIENTE] (
	[Transporte] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Telefono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionVendedor] [money] NULL ,
	[Cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionCobrador] [money] NULL ,
	[CondicionVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Dias] [smallint] NULL ,
	[Lista] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ruta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ciudad] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Despacho] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Giro] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HDESCUENTORECARGO] (
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[MontoMon] [money] NULL ,
	[ValorMOn] [money] NULL ,
	[Monto] [money] NULL ,
	[Valor] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HDETALLEDOCUMENTO] (
	[DatosKit] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[TotalLinea] [money] NULL ,
	[Subpedido] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidad] [money] NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioVenta] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Paridad] [money] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioVentaMon] [money] NULL ,
	[PrecioCostoMOn] [money] NULL ,
	[TotalLineaMOn] [money] NULL ,
	[ParidadMOn] [money] NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Alternativo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Variacion] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HENCABEZADOCUMENTO] (
	[TipoRelacionador] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[NumeroRelacionador] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vigente] [bit] NULL ,
	[Vence] [datetime] NULL ,
	[Emitido] [bit] NULL ,
	[FacturaAnticipo] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[FueraPlazo] [bit] NULL ,
	[TipoMoneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Subpedido] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[traspasado] [bit] NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Facturado] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[Impreso] [bit] NULL ,
	[Comentario] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[AfectoExento] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Factura] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[LocalDes] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[OrdenCompra] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[NetooBruto] [bit] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HTOTALDOCUMENTO] (
	[TotalDetalleMon] [money] NULL ,
	[TotalDescuentosMon] [money] NULL ,
	[Total] [money] NULL ,
	[TotalIvaCarneMon] [money] NULL ,
	[TotalIlaMOn] [money] NULL ,
	[TotalRecuperacionMOn] [money] NULL ,
	[TotalExentoMon] [money] NULL ,
	[TotalImpuestoEspecificoMOn] [money] NULL ,
	[TotalIvaMon] [money] NULL ,
	[TotalNetoMon] [money] NULL ,
	[PorcRecuperacionMOn] [money] NULL ,
	[TotalExento] [money] NULL ,
	[TotalImpuestoEspecifico] [money] NULL ,
	[TotalRecargosMon] [money] NULL ,
	[TotalIva] [money] NULL ,
	[TotalMOn] [money] NULL ,
	[TotalIla] [money] NULL ,
	[TotalIvaCarne] [money] NULL ,
	[TotalDetalle] [money] NULL ,
	[TotalDescuentos] [money] NULL ,
	[TotalRecargos] [money] NULL ,
	[PorcRecuperacion] [smallint] NULL ,
	[TotalRecuperacion] [money] NULL ,
	[TotalNeto] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoId] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVCLA] (
	[usuario] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[password] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave1] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave2] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave3] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave4] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[clave5] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[cantidadfilas] [int] NULL ,
	[MargenIzquierdo] [tinyint] NULL ,
	[Atributo1] [bit] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVDETALLEPARTES] (
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParidadMOn] [money] NULL ,
	[TotalLineaMOn] [money] NULL ,
	[PrecioCostoMon] [money] NULL ,
	[OrdenC] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[IdOriginal] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[TotalLinea] [money] NULL ,
	[Variacion] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Cantidad] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioVentaMOn] [money] NULL ,
	[PrecioVenta] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVENCABEZAPARTES] (
	[Comentario] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[OrdenC] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoMoneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Total] [money] NULL ,
	[Ajuste] [bit] NULL ,
	[FacturaCompra] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[LocalDes] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Impreso] [bit] NULL ,
	[IdOriginal] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[TotalMOn] [money] NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVHDETALLEPARTES] (
	[TotalLIneaMOn] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioCostoMOn] [money] NULL ,
	[PrecioVentaMOn] [money] NULL ,
	[OrdenC] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[TotalLinea] [money] NULL ,
	[Variacion] [money] NULL ,
	[ParidadMon] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioVenta] [money] NULL ,
	[Cantidad] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVHENCABEZAPARTES] (
	[OrdenC] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[TotalMon] [money] NULL ,
	[Referencia] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comentario] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[FacturaCompra] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[Total] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoMoneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Localdes] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ajuste] [bit] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[INVROTULO] (
	[serie] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechadeldia] [datetime] NULL ,
	[FechaCM] [datetime] NULL ,
	[ConeccionContabilidad] [bit] NULL ,
	[UsaEmisionPartes] [bit] NULL ,
	[CantidadLector] [bit] NULL ,
	[PPP] [bit] NULL ,
	[Informado] [bit] NULL ,
	[fechacalculo] [datetime] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[KIT] (
	[VentaNeto] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[unidad] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[VentaBruto] [money] NULL ,
	[cantidad] [money] NULL ,
	[CodigoLIsta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[CodigoKit] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MATRIZ] (
	[Nivel] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (100) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MONEDA] (
	[VALOR] [money] NULL ,
	[FECHA] [datetime] NULL ,
	[DESCRIPCION] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[CODIGO] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOCLIENTES] (
	[Frecuencia] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descuento_inicial] [datetime] NULL ,
	[Rubro] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comentario] [varchar] (200) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ingreso] [datetime] NULL ,
	[Clasificacion] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Negativo] [bit] NULL ,
	[Giro] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descuento] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Credito] [money] NULL ,
	[Descuento_final] [datetime] NULL ,
	[TipoVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ruta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CreditoMon] [money] NULL ,
	[Centro] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[MasDatos] [text] COLLATE Modern_Spanish_CI_AS NULL ,
	[Transporte] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Contacto2] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Sigla] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ciudad] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Telefono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Contacto1] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Despacho] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Condicion] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CondicionCompra] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Zona] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Categoria] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Internet] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[CuentaC] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Item] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Auxiliar] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[BancoC] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CuentaCorriente] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Sucursal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Importado] [bit] NULL ,
	[PosArticuloCliente] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[PosAtributoCliente] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[PosEspecificacionCliente] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[LargoCodigo] [tinyint] NULL ,
	[fecha_actualiza] [datetime] NULL ,
	[dias_actualiza] [int] NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOGENERAL] (
	[path] [varchar] (100) COLLATE Modern_Spanish_CI_AS NULL ,
	[iva] [smallmoney] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOSTCOMPRAS] (
	[ImpuestoEspecifico] [money] NULL ,
	[LitrosCombustible] [float] NULL ,
	[Emitido] [bit] NULL ,
	[Vigente] [bit] NULL ,
	[MesDeclaracion] [varchar] (6) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorTotal] [money] NULL ,
	[ValorILA] [money] NULL ,
	[ValorIVA] [money] NULL ,
	[ValorExento] [money] NULL ,
	[ValorNeto] [money] NULL ,
	[FechaEmision] [datetime] NULL ,
	[Centro] [varchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[NumeroInterno] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[RetencionIVA] [money] NULL ,
	[TipoDocumento] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[RutProveedor] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOSTCOMPRASILA] (
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CodigoIla] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoDocumento] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[correlativo] [smallint] NULL ,
	[valor] [money] NULL ,
	[ila] [smallint] NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[RutProveedor] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOSTLOCAL] (
	[codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[comuna] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[jefe] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[fono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[Meta] [money] NULL ,
	[MetaMon] [money] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOSTTABLAS] (
	[tabla] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[descripcion] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[valor] [money] NULL ,
	[Tratamiento] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[VariacionAnual] [money] NULL ,
	[VariacionSemestral] [money] NULL ,
	[ValorMon] [money] NULL ,
	[sbif] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOSTVENTASILA] (
	[valor] [money] NULL ,
	[tipo] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[codigo] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[ila] [money] NULL ,
	[numero] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorMon] [numeric](19, 4) NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSOVENDEDOR] (
	[codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipo] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombre] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[telefono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechanac] [datetime] NULL ,
	[fechaing] [datetime] NULL ,
	[comision] [float] NULL ,
	[comentario] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[MetaMon] [money] NULL ,
	[Meta] [money] NULL ,
	[estadocivil] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSROTULO] (
	[empresa] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[sigla] [varchar] (25) COLLATE Modern_Spanish_CI_AS NULL ,
	[giro] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutemp] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[ciudad] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[rutrepleg] [varchar] (14) COLLATE Modern_Spanish_CI_AS NULL ,
	[nomrepleg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombregg] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[titulogg] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombrecon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[TituloCon] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Florencia] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombreiva] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[nombrerut] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Multiempresa] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoDE] [bit] NULL ,
	[Region] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fonos] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[MSNB] [varchar] (100) COLLATE Modern_Spanish_CI_AS NULL ,
	[MSJFP] [varchar] (100) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidadlectorgv] [bit] NULL ,
	[MSseguro] [bit] NULL ,
	[Anselmo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[MsAgustin] [bit] NULL ,
	[BaseDato] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[MsNina] [bit] NULL ,
	[Ingtelas] [bit] NULL ,
	[Act_Economica] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[NUMERADOS] (
	[articulo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[correlativo] [int] IDENTITY (65582, 1) NOT FOR REPLICATION  NOT NULL ,
	[peso] [money] NULL ,
	[numero] [int] NULL ,
	[narticulo] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PARAMETROS] (
	[LargoArticulo] [tinyint] NULL ,
	[LargoAtributo] [tinyint] NULL ,
	[CantidadNiveles] [tinyint] NULL ,
	[NombreAtributo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[NombreMatriz] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[CantidadxNivel] [tinyint] NULL ,
	[Decimal] [bit] NULL ,
	[LargoCantidad] [tinyint] NULL ,
	[LargoCosto] [tinyint] NULL ,
	[LargoVenta] [tinyint] NULL ,
	[LargoPU] [tinyint] NULL ,
	[NivelPrecios] [tinyint] NULL ,
	[NivelPreciosCostos] [tinyint] NULL ,
	[Ila] [bit] NULL ,
	[EmpresaConstructora] [bit] NULL ,
	[VenSinStock] [bit] NULL ,
	[CambiaPreVen] [bit] NULL ,
	[DesglosaPorKit] [bit] NULL ,
	[ImpuestoCarnes] [bit] NULL ,
	[PorcCarnes] [float] NULL ,
	[ValorIva] [smallmoney] NULL ,
	[FolioDocumento] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Imagen] [bit] NULL ,
	[ImpuestoEspecifico] [bit] NULL ,
	[ComisionxArticulo] [bit] NULL ,
	[ValidaLineaCredito] [bit] NULL ,
	[SinSaldoCredito] [bit] NULL ,
	[CodigoBarra] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Doblemoneda] [bit] NULL ,
	[MonedaLocal] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaAlternativa] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaTrabajo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[GuiaDespacho] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Factura] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[NDebito] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Boleta] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[GuiaTraspaso] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[NCredito] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[NVenta] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[GuiaTransito] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParteIngreso] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParteEgreso] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParteTraspaso] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ParteConsumo] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cotizacion] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[ArticulosActivos] [tinyint] NULL ,
	[IniVende] [bit] NULL ,
	[ValFPago] [bit] NULL ,
	[QCopiasV] [int] NULL ,
	[ImpresoraBoleta] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ruta] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Formato] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Version] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[CantidadCampos] [int] NULL ,
	[CodTarjeta] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Lector] [bit] NULL ,
	[ImpresoraFactura] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[ImpresoraVale] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Puerto] [smallint] NULL ,
	[LocalCaja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[UsuarioCaja] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[DescuentoMaximo] [money] NULL ,
	[ChequeMaximo] [money] NULL ,
	[ImpresoraNcredito] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[ImpresoraGuias] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[UsaCodigoFamilia] [bit] NULL ,
	[LocalKit] [bit] NULL ,
	[LargoBarra] [tinyint] NULL ,
	[CantidadLector] [bit] NULL ,
	[CambiaCostoMaterial] [bit] NULL ,
	[ProCodigoBarra] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ImpBoletera] [bit] NULL ,
	[ADICIONAL] [bit] NULL ,
	[Balanza] [bit] NULL ,
	[PuertoFiscal] [smallint] NULL ,
	[Fiscal] [bit] NULL ,
	[NotaCredito] [bit] NULL ,
	[LargoMinutos] [tinyint] NULL ,
	[ImpresoraNotasV] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[MonedaDollar] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOARTXLOCAL] (
	[Precio] [money] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Kardex] [money] NULL ,
	[Iden] [datetime] NULL ,
	[StockInicial] [money] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Stock] [money] NULL ,
	[Fecha] [datetime] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOCPOABONOS] (
	[tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor_BrutoMOn] [money] NULL ,
	[Abonomon] [money] NULL ,
	[Hora] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Abono] [money] NULL ,
	[Valor_Bruto] [money] NULL ,
	[fechavence] [datetime] NULL ,
	[fecha] [datetime] NULL ,
	[numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[correlativo] [smallint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOCTAABONOS] (
	[Valor_BrutoMOn] [money] NULL ,
	[Abonomon] [money] NULL ,
	[Valor_Bruto] [money] NULL ,
	[Abono] [money] NULL ,
	[fecha] [datetime] NULL ,
	[correlativo] [smallint] NULL ,
	[numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Hora] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[fechavence] [datetime] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASODATOSCLIENTE] (
	[Vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comuna] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Transporte] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Giro] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Despacho] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Telefono] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ciudad] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Ruta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Lista] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Dias] [smallint] NULL ,
	[CondicionVenta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionCobrador] [money] NULL ,
	[Cobrador] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[ComisionVendedor] [money] NULL ,
	[Direccion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoId] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASODESCUENTORECARGO] (
	[Tipo] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[ValorMOn] [money] NULL ,
	[Monto] [money] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[MontoMOn] [money] NULL ,
	[tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Valor] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASODETALLEDOCUMENTO] (
	[Cantidad13] [money] NULL ,
	[Cantidad7] [money] NULL ,
	[Cantidad8] [money] NULL ,
	[Cantidad9] [money] NULL ,
	[Cantidad10] [money] NULL ,
	[Cantidad11] [money] NULL ,
	[Cantidad12] [money] NULL ,
	[Cantidad14] [money] NULL ,
	[Cantidad15] [money] NULL ,
	[PrecioVentaMOn] [money] NULL ,
	[PrecioCostoMon] [money] NULL ,
	[TotalLIneaMon] [money] NULL ,
	[ParidadMon] [money] NULL ,
	[DatosKit] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidad4] [money] NULL ,
	[Alternativo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidad6] [money] NULL ,
	[Cantidad5] [money] NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidad2] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Variacion] [money] NULL ,
	[Paridad] [money] NULL ,
	[TotalLinea] [money] NULL ,
	[Cantidad3] [money] NULL ,
	[Cantidad1] [money] NULL ,
	[PrecioVenta] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASODETALLEDOCUMENTOG] (
	[Cantidad13] [money] NULL ,
	[Cantidad8] [money] NULL ,
	[Cantidad9] [money] NULL ,
	[Cantidad10] [money] NULL ,
	[Cantidad11] [money] NULL ,
	[Cantidad12] [money] NULL ,
	[Cantidad6] [money] NULL ,
	[Cantidad7] [money] NULL ,
	[PrecioVenta] [money] NULL ,
	[Cantidad14] [money] NULL ,
	[Cantidad15] [money] NULL ,
	[PrecioVentaMOn] [money] NULL ,
	[PrecioCostoMon] [money] NULL ,
	[TotalLIneaMon] [money] NULL ,
	[ParidadMon] [money] NULL ,
	[DatosKit] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Alternativo] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[PrecioCosto] [money] NULL ,
	[Cantidad5] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descripcion] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Variacion] [money] NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipoid] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Paridad] [money] NULL ,
	[TotalLinea] [money] NULL ,
	[Cantidad1] [money] NULL ,
	[Cantidad2] [money] NULL ,
	[Cantidad3] [money] NULL ,
	[Cantidad4] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Linea] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOENCABEZADOCUMENTO] (
	[NetooBruto] [bit] NULL ,
	[FacturaAnticipo] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[TIPO1] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[CompletoIncompleto] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Hora] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[caja] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoMoneda] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Facturado] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[Emitido] [bit] NULL ,
	[Vigente] [bit] NULL ,
	[NumeroRelacionador] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoRelacionador] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[FueraPlazo] [bit] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoId] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[Impreso] [bit] NULL ,
	[Numero] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[LocalDes] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vence] [datetime] NULL ,
	[Pedido] [varchar] (7) COLLATE Modern_Spanish_CI_AS NULL ,
	[OrdenCompra] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Comentario] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[Factura] [varchar] (8) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[AfectoExento] [varchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Tipo] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOESTES] (
	[nusuario] [int] NULL ,
	[GD] [money] NULL ,
	[TS] [money] NULL ,
	[GT] [money] NULL ,
	[PC] [money] NULL ,
	[Salidas] [money] NULL ,
	[StockFisico] [money] NULL ,
	[StockValorizado] [money] NULL ,
	[Iden] [datetime] NULL ,
	[NV] [money] NULL ,
	[PrecioCostoIni] [money] NULL ,
	[TE] [money] NULL ,
	[PrecioCosto] [money] NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[FA] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[ND] [money] NULL ,
	[StockInicial] [money] NULL ,
	[PI] [money] NULL ,
	[NC] [money] NULL ,
	[Entradas] [money] NULL ,
	[PE] [money] NULL ,
	[BO] [money] NULL ,
	[Atributo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOPRECIOSCOSTOS] (
	[Costo] [money] NULL ,
	[CostoPesos] [money] NULL ,
	[StockCM] [money] NULL ,
	[CostoPesosMon] [money] NULL ,
	[CoE] [money] NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoCM] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Iden] [datetime] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PASOTOTALDOCUMENTO] (
	[TotalRecuperacionMOn] [money] NULL ,
	[TotalIvaMon] [money] NULL ,
	[TotalExentoMon] [money] NULL ,
	[TotalIlaMOn] [money] NULL ,
	[TotalIvaCarneMon] [money] NULL ,
	[TotalDetalleMon] [money] NULL ,
	[TotalDescuentosMon] [money] NULL ,
	[TotalImpuestoEspecificoMOn] [money] NULL ,
	[PorcRecuperacionMOn] [money] NULL ,
	[TotalNetoMon] [money] NULL ,
	[TotalRecargos] [money] NULL ,
	[TotalRecargosMon] [money] NULL ,
	[TotalImpuestoEspecifico] [money] NULL ,
	[PorcRecuperacion] [smallint] NULL ,
	[TotalDescuentos] [money] NULL ,
	[TotalDetalle] [money] NULL ,
	[TotalIvaCarne] [money] NULL ,
	[TotalIla] [money] NULL ,
	[TotalExento] [money] NULL ,
	[TotalIva] [money] NULL ,
	[TotalNeto] [money] NULL ,
	[Total] [money] NULL ,
	[TotalMOn] [money] NULL ,
	[TotalRecuperacion] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoId] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PRECIOS] (
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[VentaNeto] [money] NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[CodigoLista] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[VentaBruto] [money] NULL ,
	[Nombre] [varchar] (30) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PRECIOSCOSTOS] (
	[StockCM] [money] NULL ,
	[CostoPesos] [money] NULL ,
	[CostoCM] [money] NULL ,
	[CoE] [money] NULL ,
	[Costo] [money] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[CostoPesosMon] [money] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[RANKING] (
	[MargenPorc] [money] NULL ,
	[Rut] [varchar] (13) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Razon] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Descuento] [money] NULL ,
	[DescPorc] [money] NULL ,
	[Zona] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Margen] [money] NULL ,
	[Descripcion] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[Fecha] [datetime] NULL ,
	[VentasPorc] [money] NULL ,
	[Ventas] [money] NULL ,
	[Cantidad] [money] NULL ,
	[Vence] [datetime] NULL ,
	[Unidad] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[NomVended] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[Vendedor] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Qporc] [money] NULL ,
	[Identificador] [varchar] (12) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[REPORTERUTADIARIA] (
	[Ruta] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[NArticulo] [smallint] NULL ,
	[Descripcion] [varchar] (255) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cantidad] [float] NULL ,
	[Total] [float] NULL ,
	[NombreRuta] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[STOCKMINIMO] (
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[StockMinimo] [money] NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[TABLAPASO] (
	[B_Credito] [money] NULL ,
	[Hora] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Rut] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Codigo] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Pagado] [money] NULL ,
	[P_Venta] [float] NULL ,
	[TCliente] [money] NULL ,
	[Facturas] [money] NULL ,
	[Razon] [varchar] (40) COLLATE Modern_Spanish_CI_AS NULL ,
	[N_Venta] [money] NULL ,
	[Iva] [float] NULL ,
	[N_Debito] [money] NULL ,
	[Vendedor] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Cobrador] [varchar] (20) COLLATE Modern_Spanish_CI_AS NULL ,
	[Protestos] [money] NULL ,
	[Saldo] [money] NULL ,
	[N_Credito] [int] NULL ,
	[Ventas] [money] NULL ,
	[Boletas] [money] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[TOMAINVENTARIO] (
	[Stock] [money] NULL ,
	[Fecha] [datetime] NULL ,
	[Partida] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[Digitado] [bit] NULL ,
	[Especificacion] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Articulo] [varchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[Local] [varchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[Atributo] [varchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[Folio] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[TOTALDOCUMENTO] (
	[TotalDescuentosMon] [money] NULL ,
	[TotalNetoMon] [money] NULL ,
	[TotalIvaMon] [money] NULL ,
	[TotalExentoMon] [money] NULL ,
	[TotalIlaMOn] [money] NULL ,
	[TotalDetalleMon] [money] NULL ,
	[TotalRecuperacion] [money] NULL ,
	[TotalRecargosMon] [money] NULL ,
	[PorcRecuperacionMOn] [money] NULL ,
	[TotalRecuperacionMOn] [money] NULL ,
	[TotalImpuestoEspecificoMOn] [money] NULL ,
	[TotalMOn] [money] NULL ,
	[TotalIvaCarneMon] [money] NULL ,
	[TotalImpuestoEspecifico] [money] NULL ,
	[PorcRecuperacion] [smallint] NULL ,
	[TotalRecargos] [money] NULL ,
	[TotalDescuentos] [money] NULL ,
	[TotalDetalle] [money] NULL ,
	[TotalIvaCarne] [money] NULL ,
	[TotalIla] [money] NULL ,
	[TotalExento] [money] NULL ,
	[TotalIva] [money] NULL ,
	[TotalNeto] [money] NULL ,
	[Total] [money] NULL ,
	[Id] [varchar] (10) COLLATE Modern_Spanish_CI_AS NULL ,
	[TipoId] [varchar] (2) COLLATE Modern_Spanish_CI_AS NULL 
) ON [PRIMARY]
GO

