document.addEventListener("DOMContentLoaded", () => {
  fetch('/api/dreamkey/membresias')
    .then(response => {
      if (!response.ok) throw new Error("Error en la solicitud");
      return response.json();
    })
    .then(membresias => {
      const contenedor = document.getElementById('list-items');
      let itemsHTML = ""; // Acumular HTML antes de insertarlo

      membresias.forEach(item => {
        const precio1 = new Intl.NumberFormat("es-MX", {
          style: "currency",
          currency: "MXN"
        }).format(item.precio);

        itemsHTML += `
          <div class="col-sm-6 col-md-6 col-lg-4">
              <div class="card w-auto mb-4">
                  <div class="card-header">
                      <h4 class="titulo">${item.nombre}</br> (${item.categoria})
                          <span>
                              <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                   data-bs-target="#modal-${item.id}">Detalles</button>
                          </span>
                      </h4>
                  </div>
                  <div class="card-body">
                      <img src="${item.imagen}" class="card-img-top" alt="${item.nombre}">
                      <h5 class="card-title">Precio público</h5>
                      <p class="card-text1 text-center">${precio1}</p><br>
                  </div>
              </div>
          </div>

          <!-- Modal dinámico -->
          <div class="modal fade" id="modal-${item.id}" tabindex="-1" aria-labelledby="modalLabel-${item.id}" aria-hidden="true">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <h1 class="modal-title fs-5" id="modalLabel-${item.id}">${item.nombre}</h1>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                      </div>
                      <div class="modal-body text-center">
                          <img src="${item.imagen}" class="img-fluid mb-3" alt="${item.nombre}" style="max-width: 200px;">
                          <p>${item.descripcion}</p>
                      </div>
                      <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                      </div>
                  </div>
              </div>
          </div>
        `;
      });

      contenedor.innerHTML = itemsHTML; 
    })
    .catch(error => {
      console.error("Error al obtener las membresías:", error);
    });
});
