
console.log("Este es un script desde main");




const requestOptions = {
  method: "GET",
  redirect: "follow"
};

fetch("/api/dreamkey/afiliados", requestOptions)
  .then((response) => {
    if (!response.ok) {
      throw new Error("Error en la solicitud: " + response.status);
    }
    return response.json(); // 👈 usar .json()
  })
  .then((result) => {
    console.log("Resultado GET afiliados:", result);

    // Aquí puedes mostrar los datos en pantalla, por ejemplo:
    const container = document.getElementById("list-items");
    result.forEach(afiliado => {
		addItem(afiliado);
      /*
		const div = document.createElement("div");
      div.innerHTML = `
        <div class="card m-2 p-2">
          <h5>${afiliado.nombre}</h5>
          <p>Correo: ${afiliado.correo}</p>
          <p>Teléfono: ${afiliado.telefono}</p>
        </div>
      `;
      container.appendChild(div);
	  */
    });
  })
  .catch((error) => console.error("Error en fetch afiliados:", error));



  function addItem(item) {
      const itemHTML =
          '   <div class="col-12 col-sm-6 col-md-4 col-lg-4 d-flex">\n' +
          '       <div class="card">\n'+
          '                <a href="./empresaDetail.html?name=' + encodeURIComponent(item.nombre) + '">\n' +
          '               <img src="' + item.imagen + '" class="card-img-top" alt="' + item.nombre + '">\n' +
          '           </a>\n'+
          '           <div class="card-body">\n' +
          '               <h5 class="card-title">' + item.nombre + '</h5>\n' +
          '               <p class="card-text">' + getStars(item.raiting) + '</p>\n' +
          '               <p class="card-text">' + item.descripcion + '</p>\n' +
          '           </div>\n'+
          '       </div>\n'+
          '   </div>\n'+
          '<br/>';
      const itemsContainer = document.getElementById("list-items");
      itemsContainer.innerHTML += itemHTML;
  }
  function getStars(rating) {
      const maxStars = 5;
      let starsHTML = '';

      for (let i = 0; i < maxStars; i++) {
          if (i < Math.floor(rating)) {
              // Estrella llena
              starsHTML += '<span class="fa fa-star checked"></span>';
          } else if (i < rating) {
              // Media estrella
              starsHTML += '<span class="fa fa-star-half-alt checked"></span>';
          } else {
              // Estrella vacía
              starsHTML += '<span class="fa fa-star"></span>';
          }
      }

      return starsHTML;
  }

//  items.forEach(addItem);

 //import {items} from './afiliados-data.js';
/*

console.log("Esta es ub scrip desde main");
const requestOptions = {
  method: "GET",
  redirect: "follow"
};

fetch("/api/dreamkey/afiliados/", requestOptions)
  .then((response) => response.text())
  .then((result) => console.log(result))
  .catch((error) => console.error(error));

  
  
  







// Ejecutar cuando cargue el DOM   esto es lo ultimo generado no usar
window.addEventListener('DOMContentLoaded', () => {
  const requestOptions = {
    method: "GET",
    redirect: "follow"
  };

  fetch("/api/dreamkey/afiliados/", requestOptions)
    .then(response => response.json()) // Parseamos como JSON
    .then(data => renderCards(data))
    .catch(error => {
      console.error("Error al cargar afiliados:", error);
      document.getElementById("list-items").innerHTML = "<p>Error al cargar empresas.</p>";
    });
});

function renderCards(afiliados) {
  const container = document.getElementById("list-items");
  container.innerHTML = ''; // Limpiar contenido previo

  afiliados.forEach(item => {
    const card = document.createElement('div');
    card.className = 'col-md-4 mb-4';

    card.innerHTML = `
      <div class="card h-100">
        <img src="${item.img}" class="card-img-top" alt="${item.name}">
        <div class="card-body">
          <h5 class="card-title">${item.name}</h5>
          <p class="card-text">${item.descripción}</p>
          <a href="empresa-detail.html?name=${encodeURIComponent(item.name)}" class="btn btn-primary">Ver más</a>
        </div>
      </div>
    `;

    container.appendChild(card);
  });
}

*/