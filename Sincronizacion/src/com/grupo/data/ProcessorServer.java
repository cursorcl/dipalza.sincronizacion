package com.grupo.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import org.apache.log4j.Logger;

import com.grupo.MsgInformaDatos;
import com.grupo.basedatos.Cliente;
import com.grupo.basedatos.EncabezadoVenta;
import com.grupo.basedatos.Especiales;
import com.grupo.basedatos.IDUnit;
import com.grupo.basedatos.ItemVenta;
import com.grupo.basedatos.ItemesVenta;
import com.grupo.basedatos.NroItemesVenta;
import com.grupo.basedatos.Producto;
import com.grupo.basedatos.RangoEspeciales;
import com.grupo.biblioteca.EMessagesTypes;
import com.grupo.biblioteca.ListEspeciales;
import com.grupo.biblioteca.MessageToTransmit;
import com.grupo.biblioteca.VectorClientes;
import com.grupo.biblioteca.VectorProductos;
import com.grupo.biblioteca.VectorVenta;
import com.grupo.biblioteca.server.ConnectionClient;
import com.grupo.biblioteca.server.ConnectionServer;
import com.grupo.biblioteca.server.events.ConnectionClientEvent;
import com.grupo.biblioteca.server.events.MessagesClientEvent;
import com.grupo.biblioteca.server.events.Notificable;
import com.grupo.util.EventEmisor;
import com.grupo.util.EventMsgListener;
import com.grupo.utilitarios.FechaFormateada;

/**
 * Clase del servidor donde se reciben los mensajes de solicitud de clientes y productos,
 * actualización de clientes y de almacenamiento de ventas.
 * 
 * @author cursor
 *
 */
public class ProcessorServer extends EventEmisor implements Notificable {
  static Logger log = Logger.getLogger(ProcessorServer.class);
  private FechaFormateada fecha = new FechaFormateada(new Date());
  private DataSQL data = null;
  private ConnectionServer server;
  private EncabezadoVenta encabezado;
  private ItemesVenta itemes;
  private EMessagesTypes esperandoMensaje = EMessagesTypes.MSG_ENCABEZADO;

  private int countItemsVenta = 0;
  private int itemsVentaLlegados = 0;
  private ConnectionClient connectionClient;

  public ProcessorServer(FechaFormateada fecha, ConnectionServer server) {
    this.fecha = fecha;
    this.data = DataSQL.getInstance();
    this.server = server;
    this.server.addNotificable(this);
  }

  public void close() {
    this.data.close();
    this.server.finish();
  }


  public void sendClientes(IDUnit palm) {

    VectorClientes vClientes =
        this.data.getClientes(palm.getIdUnit(), palm.getIdRuta(), palm.getIdRutaAdicional());
    log.info("Envío de clientes  " + palm.toString() + " #=" + vClientes.size());

    MessageToTransmit message = new MessageToTransmit();
    message.setIdPalm(palm);
    message.setType(EMessagesTypes.MSG_INFORMATIVE);
    MsgInformaDatos info = new MsgInformaDatos();
    info.setName(Cliente.class.getName());
    info.setCantidad(vClientes.size());
    message.setData(info);
    connectionClient.send(message);

    message = new MessageToTransmit();
    message.setIdPalm(palm);
    message.setType(EMessagesTypes.MSG_VECTORCLIENTES);
    message.setData(vClientes);
    connectionClient.send(message);

    message = new MessageToTransmit();
    message.setIdPalm(palm);
    message.setType(EMessagesTypes.MSG_INITIALIZE_CLIENTE_FINALIZED);
    message.setData(null);
    connectionClient.send(message);

  }

  public void sendProductos(IDUnit palm) {
    VectorProductos vProductos = this.data.getProductos();

    log.info("Se van a enviar productos");
    
    MessageToTransmit m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_INFORMATIVE);
    MsgInformaDatos info = new MsgInformaDatos();
    info.setName(Producto.class.getName());
    info.setCantidad(vProductos.size());
    m.setData(info);
    connectionClient.send(m);

    log.info("Se enviaron productos");
    m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_VECTORPRODUCTOS);
    m.setData(vProductos);
    connectionClient.send(m);
   
    m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_INITIALIZE_PRODUCTO_FINALIZED);
    m.setData(null);
    connectionClient.send(m);
  }

  public void sendEspeciales(IDUnit palm) {
    
    List<RangoEspeciales> rangos = this.data.getEspeciales();
    List<Especiales> especialesList =  new ArrayList<>();
    if (rangos == null || rangos.isEmpty())
      return;
    int id = 1;
    for (RangoEspeciales rango : rangos) {
      try {
        int len = rango.getArticuloInicial().length();
        int lInicial = Integer.parseInt(rango.getArticuloInicial());
        int lFinal = Integer.parseInt(rango.getArticuloFinal());
        for (int value = lInicial; value <= lFinal; value++) {
          String sValue = String.format("%0" + len + "d", value);
          Especiales e = new Especiales(id++, sValue);
          especialesList.add(e);
          
        }
      } catch (Exception ex) {
        log.error("Problemas con rango:" + rango.toString());
      }
    }

    ListEspeciales especiales = new ListEspeciales(especialesList);
    if (especiales == null || especiales.isEmpty())
      return;

    MessageToTransmit m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_INFORMATIVE);
    MsgInformaDatos info = new MsgInformaDatos();
    info.setName(Especiales.class.getName());
    info.setCantidad(especiales.getEspecialesList().size());
    m.setData(info);
    connectionClient.send(m);
    
    m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_ESPECIALES);
    m.setData(especiales);
    connectionClient.send(m);

    m = new MessageToTransmit();
    m.setIdPalm(palm);
    m.setType(EMessagesTypes.MSG_INITIALIZE_ESPECIALES_FINALIZED);
    m.setData(null);
    connectionClient.send(m);
  }

  public void sendFinalized(IDUnit palm) {
	    MessageToTransmit m = new MessageToTransmit();
	    m.setIdPalm(palm);
	    m.setType(EMessagesTypes.MSG_FINALIZED);
	    connectionClient.send(m);
  }
  
  public synchronized void addEventMsgListener(EventMsgListener listener) {
    super.addEventMsgListener(listener);
    this.data.addEventMsgListener(listener);
  }

  public synchronized void removeEventMsgListener(EventMsgListener listener) {
    super.removeEventMsgListener(listener);
    this.data.removeEventMsgListener(listener);
  }

  public FechaFormateada getFecha() {
    return this.fecha;
  }

  public void setFecha(FechaFormateada fecha) {
    this.fecha = fecha;
  }

  public void handle(EventObject event) {
    if (event instanceof ConnectionClientEvent) {
      ConnectionClientEvent ev = (ConnectionClientEvent) event;
      notify("Conectado cliente:" + ev.getClient().getSource());
      log.debug("Conectado cliente:" + ev.getClient().getSource());
      this.connectionClient = ev.getClient();
    } else if (event instanceof MessagesClientEvent) {
      MessagesClientEvent ev = (MessagesClientEvent) event;
      MessageToTransmit m = (MessageToTransmit) ev.getData();
      EMessagesTypes msgType = ev.getCommand();

      switch (msgType) {
        case MSG_DATOSINICIALIZACION:
          try {
            sendClientes(m.getIdPalm());
          } catch (Exception e) {
            log.error("Error en el envío de los datos de cliente.");
          }
          try {
            sendProductos(m.getIdPalm());
          } catch (Exception e) {
            log.error("Error en el envío de los datos de productos.");
          }
          try {
            sendEspeciales(m.getIdPalm());
          } catch (Exception e) {
            log.error("Error en el envío de los datos de productos especiales.");
          }
          try {
        	  sendFinalized(m.getIdPalm());
          } catch (Exception e) {
              log.error("Error en el envío de los datos de productos especiales.");
            }
          break;

        case MSG_CLIENTE:
          try {
            Cliente c = (Cliente) m.getData();
            this.data.setCliente(c, m.getIdPalm().getIdUnit(), m.getIdPalm().getIdRuta());
          } catch (Exception e) {
            log.error("Error en la recepción de datos de cliente.");
          }
          break;
        case MSG_ENCABEZADO:
          if (this.esperandoMensaje.equals(EMessagesTypes.MSG_ENCABEZADO)) {
            try {
              this.encabezado = ((EncabezadoVenta) m.getData());
              log.debug("Encabezado Factura: " + this.encabezado.getNombreCliente());
              this.esperandoMensaje = EMessagesTypes.MSG_NROITEMESVENTA;
              itemes = new ItemesVenta();
            } catch (Exception e) {
              e.printStackTrace();
              esperandoMensaje = EMessagesTypes.MSG_ENCABEZADO;
              log.error("Encabezado Factura con error: " + encabezado.getNombreCliente());
            }
            return;
          } else {
            log.error("Ha llegado un encabezado de factura desincronizado.");
            notify("Ha llegado un encabezado de factura desincronizado.");
          }

          break;
        case MSG_NROITEMESVENTA:
          if (esperandoMensaje.equals(EMessagesTypes.MSG_NROITEMESVENTA)) {
            NroItemesVenta count = (NroItemesVenta) m.getData();
            countItemsVenta = count.getNroItemesVenta();
            log.debug(String.format("A la espera de %d registros de venta", countItemsVenta));
            itemsVentaLlegados = 0;
            esperandoMensaje = EMessagesTypes.MSG_ITEMVENTA;
          } else {
            log.error("Ha llegado cantidad de itemes de venta desincronizado.");
            notify("Ha llegado cantidad de itemes de venta desincronizado.");
          }
          break;
        case MSG_ITEMVENTA:
          if (esperandoMensaje.equals(EMessagesTypes.MSG_ITEMVENTA)) {
            ItemVenta item = (ItemVenta) m.getData();
            if (itemsVentaLlegados < countItemsVenta) {
              log.debug(String.format("Item de Venta:%s %s %f  $%f", item.getCodigoProducto(),
                  item.getArticulo(), item.getCantidad(), item.getNeto()));
              itemsVentaLlegados++;
              itemes.add(item);
            }
            if (itemsVentaLlegados == countItemsVenta) {
              esperandoMensaje = EMessagesTypes.MSG_ENCABEZADO;
              notify("Han llegado todos los itemes de venta informados.");
              data.addVenta(encabezado, itemes, fecha);
            }

          } else {
            log.error("Ha llegado un registro de venta desincronizado.");
            notify("Ha llegado un registro de venta desincronizado.");
          }
          break;
        case MSG_INITIALIZE_CLIENTE:
          break;
        case MSG_INITIALIZE_PRODUCTO:
          break;
        case MSG_VECTORVENTAS:
          if (esperandoMensaje.equals(EMessagesTypes.MSG_ENCABEZADO)
              || esperandoMensaje.equals(EMessagesTypes.MSG_VECTORVENTAS)) {
            VectorVenta ventas = (VectorVenta) m.getData();
            notify("Han llegado todos los itemes de venta informados.");
            data.addVentas(ventas);
          } else {
            log.error("Ha llegado un registro de venta desincronizado.");
            notify("Ha llegado un registro de venta desincronizado.");
          }
          break;
        default:
          break;
      }
    }
  }
}
