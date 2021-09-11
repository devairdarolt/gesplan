function mascaraTelefone(valor, tel) {
	valor = valor.replace(/\D/g, "")
	valor = valor.replace(/^(\d{2})(\d)/g,
		"($1) $2")
	valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
	tel.value = valor // Insere o(s) valor(es) no campo
}


function parseTelefone(val, el) {
	var attribute = el.id;
	mascaraTelefone(val, el)
	//alert("valor:"+val+" "+el);

	//el.addEventListener('keypress', (e) => mascaraTelefone(e.target.value,this)) 
	//el.addEventListener('change', (e) => mascaraTelefone(e.target.value,this)) 
}

