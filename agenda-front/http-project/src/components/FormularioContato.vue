<template>

<div class="container">
    <form>
        <h1>Cadastro contato</h1>

        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" placeholder="Digite o nome" v-model="nome">
        </div>
        <div class="form-group">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" id="email" placeholder="Digite o e-mail" v-model="email">
        </div>
        <div class="form-group">
            <label for="telefone">Telefone</label>
            <input type="text" class="form-control" id="telefone" placeholder="Digite o telefone" v-model="telefone">
        </div>
        <div class="form-group">
            <label for="endereco">Endereço</label>
            <input type="text" class="form-control" id="endereco" placeholder="Digite o endreçoe" v-model="endereco">
        </div>
        
        <div class="form-group">
            <label for="idusu">Id do usuario</label>
            <input type="text" class="form-control" id="idusu" placeholder="Digite o endreçoe" v-model="idusu">
        </div>

        <button v-on:click="cadastrarContato()" type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>

</template>

<script>

export default{
	
    data(){
        return{
            email:"",
            endereco:"",
            nome:"",
            telefone:"",
            idusu:"",
            url:"http://localhost:8081/contato?usuario="
        }
    },
    methods:{
        cadastrarContato(){
            this.$http.post(this.url+this.idusus,{
                email: this.email,
                endereco: this.endereco,
                nome: this.nome,
                telefone: this.telefone
            })
            .then(response => {
                console.log(response)
            })
            .catch(e =>{
                console.log(e)
            })
        }
    }
}
</script>

<style>

</style>