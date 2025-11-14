
# Lavandería “El Limoncito”


Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe registrar nombre y teléfono del cliente y crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5), y Chaqueta ($9.000, o $7.500 c/u desde 5). El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el total resultante supera $60.000, aplicar descuento del 5% (una sola vez). No se permiten cantidades ≤ 0 ni totales negativos. Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

------primer paso.Extraer requerimientos-------
RF1: Registrar cliente (nombre, teléfono).
RF2: Crear orden con estado EN_CREACION.
RF3: Agregar ítems a la orden (producto, cantidad).
RF4: Usar precio por volumen si la cantidad de un producto es 5 o más.
RF5: Calcular total (sumar subtotales y si el total bruto supera los $60,000, aplicar descuento del 5%).
RF6: Confirmar orden -> cambiar estado a CONFIRMADO. No se pueden editar ítems después.
RF7: No se permiten cantidades 0 o negativas.
RF8: Listar resumen con datos del cliente, ítems, precios aplicados (normal o por volumen), subtotal, descuento y total final.

-------------Segundo paso: Reglas del Negocio-----------
Catálogo fijo:
Camisa: $4,000, volumen $3,500
Pantalón: $6,000, volumen $5,000
Chaqueta: $9,000, volumen $7,500
Volumen por producto: Aplica precio por volumen si el cliente deja 5 o más de un mismo producto.
Recargo exprés: Si el cliente selecciona servicio exprés, se aplica un recargo del 10% al total.
Descuento: Si el total bruto supera los $60,000, se aplica un descuento del 5%.
Estados: De EN_CREACION a CONFIRMADO (sin modificaciones después de confirmación).
Sin BD, ni inventarios, ni GUI.


-------------------Tercer paso:Criterios de acptacion----------------
CA1: Volumen:Dado que el cliente compra 6 camisas (o más), cuando se calcule el subtotal, entonces se debe usar el precio de $3,500 por unidad (no $4,000).
CA2: Descuento:Dado un total bruto de $61,000, cuando se calcule el total final, entonces se debe aplicar un descuento del 5%, resultando en un total final de $57,950.
CA3: Recargo exprés:Dado que el cliente selecciona servicio exprés, cuando se calcule el total, entonces se debe aplicar un recargo del 10% al total bruto.
CA4: Bloqueo de edición:Dado un pedido confirmado, cuando se intente editar la orden (agregar o cambiar ítems), entonces la acción debe ser rechazada.
CA5: Validación de cantidad:Dado que el cliente ingresa una cantidad de 0 o negativa, entonces el sistema debe rechazar ese ítem.
CA6:: Resumen: Dado pedido valido, cuando pido el resumen, entonces se listan los items con precio aplicado, subtotal, totalfinal y descuento.



-------------- Cuarto paso - Límite del diseño <= 5 clases ---------------
Cliente
Producto
ItemOrden
Orden

------------Quinto paso: Flujo de consola------------------
1. Ingresar cliente
2. Crear pedido
3. seleccionar producto(ropa) y cantidad
4. Mostrar resumen items con precio aplicado, subtotal, totalfinal,totalbruto y descuento
5. Confirmar pedido
6. intentar editar post-confirmacion --> Debe fallar

------------Estructuta de datos------------------
/el-limoncito/
 |_domain/ (Cliente, Producto, ItemOrden, Orden)
 |_service/ (LavanderiaService)
 |_app/ (Main - flujo de consola)

------Diseño-----
en assets estara el uml 