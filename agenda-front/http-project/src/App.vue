<template>
  <div id="app">

    <FormularioUsuario></FormularioUsuario>

    <FormularioContato></FormularioContato>

    <h1>Lista de usuários</h1>
    <Tabela v-bind:titulos="['id', 'Login', 'Senha']" v-bind:registros="usuarios"></Tabela>

    <h1>Lista de contatos</h1>
    <Tabela v-bind:titulos="['Usuario', 'IdContato', 'Nome', 'Telefeone', 'Email', 'Endereço']" v-bind:registros="contatos"></Tabela>
    <!-- <button v-on:click="refreshCon()">Refresh</button> -->
    
  </div>
</template>

<script>

  
  import Tabela from './components/tabela.vue';
  /*import FormularioUsuario from './components/FormularioUsuario.vue';
  import FormularioContato from './components/FormularioContato.vue';*/

export default {
  name: 'App',
  components: {
    Tabela,
/*    FormularioUsuario,
    FormularioContato*/
  },
  data(){
    return{
      usuarios:[],
      contatos:[]
    }
  }, 
  created:function(){
      this.$http.get('http://localhost:8081/usuario')
      .then(response => {
          this.usuarios = response.body;
      }
      ,response => {
          console.log('failed')
    });

      this.$http.get('http://localhost:8081/contato/1')
      .then(res => {
        this.contatos = res.body;
      }
      ,res => {
        console.log('failed')
      });

  }
  
}
</script>

<style>

</style>
