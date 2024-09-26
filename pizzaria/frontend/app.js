document.addEventListener('DOMContentLoaded', function() {
    const ingredienteForm = document.getElementById('ingredienteForm');
    const ingredientesList = document.getElementById('ingredientesList');

    // Função para obter a lista de ingredientes
    function getIngredientes() {
        fetch('http://localhost:8081/api/ingredientes')
            .then(response => response.json())
            .then(data => {
                ingredientesList.innerHTML = data.map(ingrediente => `
                    <tr>
                        <td>${ingrediente.nome}</td>
                        <td>${ingrediente.marca}</td>
                        <td>${ingrediente.dataValidade}</td>
                        <td>${ingrediente.observacao}</td>
                    </tr>
                `).join('');
            })
            .catch(error => console.error('Erro:', error));
    }

    // Função para adicionar um novo ingrediente
    ingredienteForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const nome = document.getElementById('nome').value;
        const marca = document.getElementById('marca').value;
        const dataValidade = document.getElementById('dataValidade').value;
        const observacao = document.getElementById('observacao').value;

        fetch('http://localhost:8081/api/ingredientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome,
                marca,
                dataValidade,
                observacao
            })
        })
        .then(response => response.json())
        .then(() => {
            // Limpa o formulário e atualiza a lista
            ingredienteForm.reset();
            getIngredientes();
        })
        .catch(error => console.error('Erro:', error));
    });

    // Inicializa a página
    getIngredientes();
});
