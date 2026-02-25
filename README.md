# SGE-API

API REST desarrollada con Spring Boot para la gestión de Recursos Humanos (SGE).

## 📋 Descripción General
Esta API proporciona servicios backend para la gestión integral de:
- **Empleados**: Datos personales, roles, departamentos y asignación de categorías.
- **Nóminas**: Registro de pagos, cálculo de salarios netos/brutos y deducciones.
- **Categorías Profesionales**: Gestión de cargos y salarios base asociados.

La arquitectura sigue el patrón **Controller - Service - Repository**, utilizando **DTOs** (Data Transfer Objects) para asegurar una transferencia de datos limpia y desacoplada de la base de datos.

---

## 🚀 Documentación de la API

A continuación se detalla el funcionamiento paso a paso de cada recurso disponible en la API.

### 1. 👤 Gestión de Empleados
Controlador: `EmpleadoController`  
Base URL: `/empleados`

Este recurso permite administrar la información de los trabajadores.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/empleados` | Devuelve la lista completa de todos los empleados registrados. |
| `GET` | `/empleados/{id}` | Devuelve el detalle de un empleado específico. Incluye información extendida como su categoría y lista de nóminas. |
| `POST` | `/empleados` | Registra un nuevo empleado en el sistema. |
| `PUT` | `/empleados/{id}` | Actualiza los datos de un empleado existente (ej. cambio de dirección, teléfono). |
| `DELETE` | `/empleados/{id}` | Elimina un empleado de la base de datos. |

**Ejemplo de cuerpo (JSON) para POST/PUT:**
```json
{
  "nombre": "Juan Pérez",
  "dni": "12345678A",
  "telefono": "600123456",
  "email": "juan.perez@empresa.com",
  "direccion": "Calle Principal 123",
  "departamento": "Desarrollo",
  "rol": "Backend Developer",
  "nuss": "123456789012",
  "esAprobador": false,
  "idCategoria": 1
}
```

### 2. 💰 Gestión de Nóminas
Controlador: `NominaController`  
Base URL: `/nominas`

Este recurso gestiona los pagos realizados a los empleados.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/nominas` | Obtiene el historial completo de todas las nóminas emitidas. |
| `GET` | `/nominas/{id}` | Obtiene el detalle de una nómina específica. |
| `POST` | `/nominas` | Genera y registra una nueva nómina para un empleado. |

> **Nota Importante:** Por integridad contable, este recurso **no permite** operaciones de modificación (`PUT`) ni eliminación (`DELETE`). Una vez emitida una nómina, persiste en el sistema.

**Ejemplo de cuerpo (JSON) para POST:**
```json
{
  "idEmpleado": 1,
  "idCargo": 2,
  "salarioBruto": 2500.00,
  "periodo": "2023-10",
  "fechaPago": "2023-10-31",
  "salarioNeto": 2100.00,
  "deducciones": 400.00
}
```

### 3. 🏷️ Categorías Profesionales
Controlador: `CategoriaProfesionalController`  
Base URL: `/categorias-profesionales`

Define los cargos y rangos salariales de la empresa.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/categorias-profesionales` | Lista todas las categorías profesionales disponibles. |
| `GET` | `/categorias-profesionales/{id}` | Obtiene una categoría y muestra qué empleados la tienen asignada. |
| `POST` | `/categorias-profesionales` | Crea una nueva categoría profesional. |
| `PUT` | `/categorias-profesionales/{id}` | Actualiza la descripción o salario base de una categoría. |
| `DELETE` | `/categorias-profesionales/{id}` | Elimina una categoría (si no tiene empleados críticos asociados). |

**Ejemplo de cuerpo (JSON) para POST/PUT:**
```json
{
  "nombreCargo": "Senior Developer",
  "descripcion": "Desarrollador con más de 5 años de experiencia",
  "salarioBruto": 35000.00
}
```

---

## 🛠️ Guía de Desarrollo y Git

Instrucciones básicas para colaborar en el proyecto.

### Configuración Inicial (Clonado)
**Desde Visual Studio Code / Terminal:**
1. Abre la terminal en la carpeta deseada.
2. Ejecuta:
   ```bash
   git clone https://github.com/Alvaross33/SGE-API.git
   ```
3. Entra en el directorio: `cd SGE-API`
4. Abre el proyecto: `code .`

**Desde IntelliJ IDEA:**
1. Selecciona **New Project** > **From Version Control**.
2. Pega la URL del repositorio y clona.

### Flujo de Trabajo Diario
1. **Actualizar cambios (Pull):**
   Antes de empezar a trabajar, asegúrate de tener la última versión:
   ```bash
   git pull
   ```
   *En IntelliJ:* Icono de flecha azul hacia abajo (Update Project).

2. **Guardar cambios (Commit & Push):**
   *En IntelliJ:*
   - Ve a la pestaña de **Commit** (o presiona `Ctrl+K`).
   - Selecciona los archivos modificados.
   - Escribe un mensaje descriptivo (ej. "feat: añadido endpoint de empleados").
   - Haz clic en **Commit and Push**.
   - **IMPORTANTE:** Verifica que estás en la rama correcta antes de hacer push.
