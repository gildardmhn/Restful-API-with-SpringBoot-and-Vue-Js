// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
/*import App from './App'*/

import VueResource from 'vue-resource'
Vue.use(VueResource)

import VueRouter from 'vue-router'
Vue.use(VueRouter)

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
Vue.use(BootstrapVue)

import VModal from 'vue-js-modal'
Vue.use(VModal)

import FormularioUsuario from './paginas/FormularioUsuario.vue';
import FormularioContato from './paginas/FormularioContato.vue';
import ListaUsuario from './paginas/listaUsuario.vue';
import ListaContato from './paginas/listaContato.vue';
import FileUpload from './paginas/FileUpload.vue';

Vue.config.productionTip = false


const routes = [
	{path: '/contato/lista', component: ListaContato},
	{path: '/contato/cadastro', component: FormularioContato},
	{path: '/usuario/cadastro', component: FormularioUsuario},
	{path: '/usuario/lista', component: ListaUsuario},
	{path: '/file', component: FileUpload}
]

const router = new VueRouter({
	routes
})

const app = new Vue({
	router
}).$mount('#app')
