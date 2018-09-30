  <template>
  <div class="container">
    <form>
      <div class="form-group">
          <label for="nome">ID usuario</label>
          <input type="text" class="form-control" id="nome" placeholder="Digite o id do usuario" v-model="idUsuario">
      </div>
      <button v-on:click="lista()" type="submit" class="btn btn-primary">Buscar</button>
    </form>
    <Tabela v-bind:titulos="['Usuario', 'IdContato', 'Nome', 'Telefeone', 'Email', 'Endereço']" v-bind:registros="contatos" v-bind:nome="nome" v-bind:url="url"></Tabela>

    <router-link tag="a" to="/contato/cadastro">
        Formulario
    </router-link>
    
  </div>
</template>

<script>

  
import Tabela from '../components/tabela.vue';

export default {
  name: 'App',
  components: {
    Tabela
  },
  data(){
    return{
      idUsuario:"",
      contatos:[],
      nome:"Lista de contatos",
      url:"http://localhost:8081/contato/"
    }
  }, 
  methods:{
      lista(){
        this.$http.get(this.url+this.idUsuario)
        .then(res => {
          this.contatos = res.body;
        }
        ,res => {
          console.log(response)
        });
      }
  }
}
</script>

<style>

</style>
