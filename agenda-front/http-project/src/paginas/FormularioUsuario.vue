<template>

<div class="container">
	<form>
        <h1>Cadastro usuário</h1>
        <input type="hidden" v-model="id">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text" class="form-control" id="login" placeholder="Digite um login" v-model="login">
        </div>
        <div class="form-group">
            <label for="senha">Senha</label>
            <input type="password" class="form-control" id="senha" placeholder="Digite um senha" v-model="senha">
        </div>
        <button v-on:click="cadastrarUsuario()" type="submit" class="btn btn-primary">Cadastrar</button>
    </form>

    <router-link tag="a" to="/usuario/lista">
        Lista
    </router-link>

</div>
</template>

<script>

export default{
	
    data(){
        return{
            id:"",
            login:"",
            senha:""
        }
    },
    methods:{
        cadastrarUsuario(){
            this.$http.post('http://localhost:8081/usuario',{
                login: this.login,
                senha: this.senha
            })
            .then(response => {
                console.log(response)
                location.reload()
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