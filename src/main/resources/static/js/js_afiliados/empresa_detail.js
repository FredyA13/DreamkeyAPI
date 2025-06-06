// Leer el ID de la URL
const params = new URLSearchParams(window.location.search);
const nombreEmpresa = params.get('name');

fetch(`/api/dreamkey/afiliados`)
  .then(response => {
    if (!response.ok) {
      throw new Error(`Error en la solicitud: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    // Buscar el item por nombre dentro de la respuesta de la API
    const afiliados = data.find(item => item.nombre === nombreEmpresa);
    
    // Si se encuentra, mostrar el item, de lo contrario mostrar un mensaje de error
    if (afiliados) {
        addItem(afiliados);
        document.title = afiliados.nombre + ' | Detalle de Empresa';
    } else {
        document.getElementById("list-items").innerHTML = "<p>Empresa no encontrada</p>";
    }
  })
  .catch(error => {
    console.error("Error al obtener afiliados:", error);
    document.getElementById("list-items").innerHTML = "<p>Error al cargar los datos.</p>";
  });

function addItem(item) {


    const itemHTML =
        `<div class="container">
            <div class="row">
                <div class="col-sm">
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-md-2">
                                <div class="row mb-2">
                                    <div class="col-sm"><img src="${item.img1}" alt="img_1" style="width: 100%; height: 100%;"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-sm"><img src="${item.img2}" alt="img_2" style="width: 100%; height: 100%;"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-sm"><img src="${item.img3}" alt="img_3" style="width: 100%; height: 100%;"></div>
                                </div>
                            </div>
                            <div class="col-md-4" style="align-content: center;">
                                <img src="${item.imagen}" class="img-fluid rounded-start" alt="empresasDetail">
                            </div>
                            <div class="col-md-6" style="align-content: center;">
                                <div class="card-body">
                                    <h3 class="card-title">${item.nombre}</h3>
                                    <h5>${item.descripcion}</h5>
                                    <p class="card-text" style="font-size: large;">${item.detalles}</p>
                                    <hr>
                                    <h5>Servicios</h5>
                                    <div class="row" style="text-align: center;">
                                        <div class="col-sm">${item.servicio1}</div>
                                        <div class="col-sm">${item.servicio2}</div>
                                        <div class="col-sm">${item.servicio3}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br/>`;

    const itemsContainer = document.getElementById("list-items");
    itemsContainer.innerHTML = itemHTML; // Reemplaza el contenido anterior
}

