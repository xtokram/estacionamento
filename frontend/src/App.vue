<script lang="ts">
import { defineComponent } from 'vue';
import HomeView from '@/views/HomeView.vue';

export default defineComponent({
  name: 'App',
  components: {
    HomeView,
  },
});

</script>

<template>
<nav>
  <router-link to="/">
  </router-link>
  <div class="navbar">
    <router-link to="/">Home</router-link>
    <router-link to="/cadastrarcondutor">Cadastrar Condutor</router-link>
    <router-link to="/cadastrarmodelo">Cadastrar Modelo</router-link>
    <router-link to="/cadastrarmarca">Cadastrar Marca</router-link>
    <router-link to="/cadastrarVeiculo">Cadastrar Veiculo</router-link>

  </div>
  </nav>
<router-view/>
</template>

<style lang="scss">
#app {
  font-family: -apple-system, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif ,Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 500px;
  height: 100vh;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  flex-direction: column;
  align-items: top;
  justify-content: center;
}

nav {
  background-color:none;
  position: absolute;
  top: 0px;
  left:0%;
  width: 100%;
  height: 55px;   
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 2px;
  border-bottom: black solid;
a {
    display: flex;
    font-size: 14px;
    font-weight: 0;
    list-style: none;
    text-decoration: none;
    color: #616161;
    position:relative;
    margin-right: 90px;
    margin-left: 50px;
    &.router-link-exact-active {
      color: white;
    }
}
}
/*Reset css*/
*{
  padding: 0;
  margin: 0;
  border: 0;
  box-sizing: border-box;
}

body {
  background-color:#1e1f1e;
}




</style>
