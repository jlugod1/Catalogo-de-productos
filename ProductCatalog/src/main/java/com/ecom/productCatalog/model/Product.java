package com.ecom.productCatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity

public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  long id;
private  String name;
private String description;
public Product() {
	
}
/*¡Gracias por el detalle!  
El problema es que al usar `@JsonBackReference` en tu campo `category`, **Jackson (el serializador JSON de Spring)** **NO incluye la propiedad `category` en el JSON de salida** para evitar ciclos infinitos.

Por eso, aunque tu producto tiene la categoría en la base de datos, **el JSON que recibe el frontend no la incluye**.

---

## **¿Cómo solucionarlo?**

### Opción 1: Cambia `@JsonBackReference` por `@JsonManagedReference`/`@JsonIgnoreProperties`

- Si solo quieres evitar ciclos y sí quieres que la categoría salga en el JSON, usa:

```java
@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
@JsonIgnoreProperties("products") // Ignora la lista de productos dentro de la categoría
private Category category;
```

Esto hará que la propiedad `category` sí se incluya en el JSON, pero sin la lista de productos (evitando el ciclo).

---

### Opción 2: Usa un DTO

Crea un DTO para exponer solo los datos que necesitas, incluyendo la categoría (id y name).

---

## **Ejemplo usando `@JsonIgnoreProperties`**

```java
@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
@JsonIgnoreProperties("products")
private Category category;
```

---

## **¿Qué hacer después?**

1. Cambia la anotación como arriba.
2. Reinicia tu backend.
3. Ve a [http://localhost:8080/api/products](http://localhost:8080/api/products) y verifica que cada producto tenga la propiedad `category` con al menos `id` y `name`.
4. Ahora tu filtro en React funcionará correctamente.

---

¿Necesitas el ejemplo de DTO? ¿O solo quieres mostrar la categoría en el JSON? Si tienes dudas, dime y te ayudo con el código exacto.*/
@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
@JsonIgnoreProperties("products") // Ignora la lista de productos dentro de la categoría
private Category category;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImagUrl() {
	return imagUrl;
}

public void setImagUrl(String imagUrl) {
	this.imagUrl = imagUrl;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

private String imagUrl;
private Double price;









public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
}
