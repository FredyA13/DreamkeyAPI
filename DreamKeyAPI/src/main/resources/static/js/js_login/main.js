const txtEmail = document.getElementById("email-address");
const password = document.getElementById("password");
const btnEnviar = document.getElementById("btnEnviar");
const cuadroDeAlerta = document.getElementById("error-msg");

txtEmail.addEventListener("blur", function (event) {
    event.preventDefault();
    txtEmail.value = txtEmail.value.trim().toLowerCase();
});

function mostrarError(mensajeError) {
    cuadroDeAlerta.insertAdjacentHTML("beforeend",
        `
        <div class="alert alert-danger" role="alert">
        ${mensajeError}
        </div>
        `
    );
}

btnEnviar.addEventListener("click", function (event) {
    event.preventDefault();

    cuadroDeAlerta.innerHTML = "";
    txtEmail.style.borderColor = "";
    password.style.borderColor = "";

    const email = txtEmail.value;
    const passwordIngresada = password.value;

    if (email === "" || passwordIngresada === "") {
        mostrarError("Por favor, completa todos los campos.");
        txtEmail.style.borderColor = "red";
        password.style.borderColor = "red";
        return;
    }

    const raw = JSON.stringify({
        correo: email,
        contraseña: passwordIngresada
    });

    fetch("/api/dreamkey/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: raw
    })
    .then(async response => {
        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(errorText || "Error al iniciar sesión");
        }
        return response.json(); // Aquí recibes el token (que no usarás)
    })
    .then(() => {
        // Segunda petición para obtener el nombre del usuario por correo
        return fetch(`/api/dreamkey/usuarios?correo=${encodeURIComponent(email)}`);
    })
	.then(() => {
	    // Segunda petición para obtener el nombre del usuario por correo
	    return fetch(`/api/dreamkey/usuarios?correo=${encodeURIComponent(email)}`);
	})
	.then(response => {
	    if (!response.ok) {
	        throw new Error("No se pudo obtener el nombre del usuario");
	    }
	    return response.json(); // Aquí puede venir un array
	})
	.then(usuarios => {
		const usuario = Array.isArray(usuarios)
		        ? usuarios.find(u => u.correo.toLowerCase() === email.toLowerCase())
		        : usuarios;

		 const nombreUsuario = usuario?.nombre || "Usuario";

	    Swal.fire({
	        title: `¡Bienvenido, ${nombreUsuario}!`,
	        icon: "success",
	        timer: 2000,
	        showConfirmButton: false
	    });

	    localStorage.setItem("isLoggedIn", "true");
	    localStorage.setItem("userName", nombreUsuario);

	    txtEmail.value = "";
	    password.value = "";

	    setTimeout(() => {
	        window.location.href = 'index.html';
	    }, 2000);
	})
    .catch(error => {
        //console.error("Error durante el proceso de login:", error.message);
        mostrarError("Correo o contraseña incorrecta.");
        txtEmail.style.borderColor = "red";
        password.style.borderColor = "red";
    });
});
