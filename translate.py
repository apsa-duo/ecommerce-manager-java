import os
import re

directory = 'c:/JavaComp2023'

replacements = {
    # UI Text
    r'"Bienvenido a JavaComp"': r'"Welcome to JavaComp"',
    r'"ADMINISTRADOR"': r'"ADMINISTRATOR"',
    r'"CLIENTE"': r'"CUSTOMER"',
    r'"Inicio de sesión del Administrador"': r'"Administrator Login"',
    r'"INICIAR SESIÓN"': r'"LOGIN"',
    r'"ATRÁS"': r'"BACK"',
    r'"Correo:"': r'"Email:"',
    r'"Clave:"': r'"Password:"',
    r'"CONSULTAR USUARIOS"': r'"VIEW USERS"',
    r'"CONSULTAR PRODUCTOS"': r'"VIEW PRODUCTS"',
    r'"CERRAR SESIÓN"': r'"LOGOUT"',
    r'"CONSULTAR VENTAS"': r'"VIEW SALES"',
    r'"¿Eres un cliente registrado\?"': r'"Are you a registered customer?"',
    r'"REGISTRARSE"': r'"REGISTER"',
    r'"INICIO DE SESIÓN"': r'"LOGIN"',
    r'"COMPRAR"': r'"SHOP"',
    r'"MODIFICAR DATOS"': r'"EDIT PROFILE"',
    r'"PONER OPINION"': r'"LEAVE REVIEW"',
    r'"Seleccione una opción"': r'"Select an option"',
    r'"¿Eres particular o una empresa\?"': r'"Are you an individual or a business?"',
    r'"PARTICULAR"': r'"INDIVIDUAL"',
    r'"EMPRESA"': r'"BUSINESS"',
    r'"Rellene los campos con la información necesaria:"': r'"Fill in the required information:"',
    r'"Nombre:"': r'"Name:"',
    r'"Teléfono:"': r'"Phone:"',
    r'"DNI:"': r'"ID (DNI):"',
    r'"CIF:"': r'"ID (CIF):"',
    r'"Introduzca los datos de su trajeta de crédito:"': r'"Enter your credit card details:"',
    r'"Titular:"': r'"Cardholder:"',
    r'"Número:"': r'"Number:"',
    r'"Fecha de caducidad:"': r'"Expiration Date:"',
    r'"Introduzca los datos de su dirección:"': r'"Enter your address details:"',
    r'"Calle:"': r'"Street:"',
    r'"CP:"': r'"Zip Code:"',
    r'"Ciudad:"': r'"City:"',
    r'"CANCELAR"': r'"CANCEL"',
    r'"CONFIRMAR REGISTRO"': r'"CONFIRM REGISTRATION"',
    r'"MODIFICAR"': r'"MODIFY"',
    r'"Buscar a partir de una fecha"': r'"Search from a date"',
    r'"Ventas:"': r'"Sales:"',
    r'"BUSCAR"': r'"SEARCH"',
    r'"Seleccione un producto:"': r'"Select a product:"',
    r'"Calificación:"': r'"Rating:"',
    r'"Comentario:"': r'"Comment:"',
    r'"CONFIRMAR"': r'"CONFIRM"',
    r'"Seleccione un usuario:"': r'"Select a user:"',
    r'"NOMBRE:"': r'"NAME:"',
    r'"CORREO:"': r'"EMAIL:"',
    r'"DIRECCIÓN:"': r'"ADDRESS:"',
    r'"TARJETA DE CRÉDITO:"': r'"CREDIT CARD:"',
    r'"TELÉFONO:"': r'"PHONE:"',
    r'"WEB:"': r'"WEBSITE:"',
    r'"Catálogo de Productos"': r'"Product Catalog"',
    r'"Carrito de Compra"': r'"Shopping Cart"',
    r'"Buscar:"': r'"Search:"',
    r'"Ordenar:"': r'"Sort:"',
    r'"Cantidad:"': r'"Quantity:"',
    r'"Subtotal:"': r'"Subtotal:"',
    r'"Total \(\+ envío\):"': r'"Total (+ shipping):"',
    r'"Opiniones:"': r'"Reviews:"',
    r'"MOSTRAR TODOS"': r'"SHOW ALL"',
    r'"ORDENAR"': r'"SORT"',
    r'"AGREGAR AL CARRITO"': r'"ADD TO CART"',
    r'"QUITAR"': r'"REMOVE"',
    r'"VACIAR CARRITO"': r'"EMPTY CART"',
    r'"AÑADIR"': r'"ADD"',
    r'"ELIMINAR"': r'"DELETE"',
    r'"Características:"': r'"Description:"',
    r'"Categoría:"': r'"Category:"',
    r'"Precio:"': r'"Price:"',
    r'"Stock:"': r'"Stock:"',
    r'"Imagen:"': r'"Image:"',
    r'"Buscar por categoría:"': r'"Search by category:"',
    r'"Ordenar por:"': r'"Sort by:"',
    r'"Nombre del producto:"': r'"Product Name: "',
    r'"Precio unitario: "': r'"Unit Price: "',

    # Table columns
    r'"Nombre", "Características", "Categoría", "Precio", "Stock"': r'"Name", "Description", "Category", "Price", "Stock"',
    r'"Producto", "Cantidad", "Subtotal"': r'"Product", "Quantity", "Subtotal"',
    r'"Nombre"': r'"Name"',
    r'"Características"': r'"Description"',
    r'"Categoría"': r'"Category"',
    r'"Precio"': r'"Price"',
    r'"Stock"': r'"Stock"',
    r'"Producto"': r'"Product"',
    r'"Cantidad"': r'"Quantity"',
    r'"Subtotal"': r'"Subtotal"',

    # Invoices
    r'"Facturas"': r'"invoices"',
    r'"/Factura\("': r'"/Invoice("',
    r'"-------------------------------- Factura Compra --------------------------------"': r'"-------------------------------- Purchase Invoice --------------------------------"',
    r'"-------------------------------- Fecha: "': r'"-------------------------------- Date: "',
    r'"DATOS DEL CLIENTE:"': r'"CUSTOMER DETAILS:"',
    r'"    Nombre: "': r'"    Name: "',
    r'"    Correo: "': r'"    Email: "',
    r'"    Número Tarjeta: "': r'"    Card Number: "',
    r'"    Teléfono: "': r'"    Phone: "',
    r'"IMPORTE: "': r'"TOTAL: "',

    # Constants & files
    r'imagenes/': r'images/',
}

for root, dirs, files in os.walk(directory):
    for file in files:
        if file.endswith('.java'):
            filepath = os.path.join(root, file)
            with open(filepath, 'r', encoding='utf-8') as f:
                content = f.read()

            for old, new in replacements.items():
                content = re.sub(old, new, content)

            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)

print('Translation complete.')
