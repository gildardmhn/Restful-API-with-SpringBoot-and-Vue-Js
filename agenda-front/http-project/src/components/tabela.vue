<template>

	<div class="container">

		<h1>{{nome}}</h1>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th v-for="titulo in titulos">{{ titulo }}</th>
				</tr>
			</thead>

			<tbody>
				<tr v-for="registro in registros">
					<td v-for="item in registro"> {{ item }}</td>
					<button type="button" class="btn btn-info" v-on:click="show(registro)">Editar</button>
					<button type="button" class="btn btn-warning" v-on:click="deletar(registro)">Deletar</button>
				</tr>
			</tbody>
		</table>

		<modal name="editar">
		  <form>
	        <h1>Editar usuário</h1>
	        <input type="hidden" v-model="registro.id">
	        <div class="form-group">
	            <label for="login">Login</label>
	            <input type="text" class="form-control" id="login" placeholder="Digite um login" v-model="registro.login">
	        </div>
	        <div class="form-group">
	            <label for="senha">Senha</label>
	            <input type="password" class="form-control" id="senha" placeholder="Digite um senha" v-model="registro.senha">
	        </div>
	        <button v-on:click="updateUsuario()" type="submit" class="btn btn-primary">Atualizar</button>
	    </form>
		</modal>
	</div>
</template>


<script>


export default{
	props:['titulos','registros','nome', 'url'],
	data(){
		return{
			registro:{
				id:"",
				login:"",
				senha:""
			},
			urlModifiedDelete:"",
			urlModifiedUpdate:""
		}
		
	},
	methods:{
	    deletar(registro){
	    	/*estou checando se meu url tem um numero no final ou uma barra / */
	    	this.urlModifiedDelete = this.url
	    	if(!isNaN(this.urlModifiedDelete.slice(-1))){
	    		this.urlModifiedDelete = this.urlModifiedDelete.slice(0, -1);
	    	}
		  this.$http.delete(this.urlModifiedDelete+registro.id)
		  .then(response => {
		    /*console.log(response)*/
		    location.reload()
		  })
		  ,response => {
		    console.log(response)
		  }
		  
	    },

	    show (registro) {
		    this.$modal.show('editar');

		    this.urlModifiedUpdate = this.url
	    	if(!isNaN(this.urlModifiedUpdate.slice(-1))){
	    		this.urlModifiedUpdate = this.urlModifiedUpdate.slice(0, -1);
	    	}

	    	this.$http.get(this.urlModifiedUpdate+'buscar/'+registro.id)
	    	.then(response => {
	    		this.registro = response.body
	    		/*console.log(response)*/
	    	})
	    	,response => {
	    		console.log(response)
	    	}
		},
		hide () {
			this.$modal.hide('editar');
		},

		updateUsuario(){
			this.$http.post('http://localhost:8081/usuario',{
				id: this.registro.id,
                login: this.registro.login,
                senha: this.registro.senha
            })
            .then(response => {
                /*console.log(response)*/
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