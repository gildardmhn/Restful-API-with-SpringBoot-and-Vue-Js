<template>
  <div>

    <Tabela v-bind:titulos="['#', 'Login', 'Senha']" v-bind:registros="usuarios" v-bind:nome="nome" v-bind:url="url"></Tabela>

    <router-link tag="a" to="/usuario/cadastro">
        Formulario
    </router-link>
  
  </div>
</template>

<script>

  
import Tabela from '../components/tabela.vue';

export default {
  name: 'App',
  components:{
    Tabela
  },
  data(){
    return{
      usuarios:[],
      nome:"Lista de usuários",
      url:'http://localhost:8081/usuario/'
    }
  }, 
  created:function(){
      this.$http.get(this.url)
      .then(response => {
          this.usuarios = response.body;
      }
      ,response => {
          console.log(response)
    });
  }
}
</script>

<style>

</style>
