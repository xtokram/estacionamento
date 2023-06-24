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
    <img alt="Logo" width="24" height="24" src="@/assets/logo.png"/>
  </router-link>
  <div class="navbar">
    <router-link to="/">Home</router-link>
    <router-link to="/cadastrarcondutor">Cadastrar Condutor</router-link>
    <router-link to="/cadastrarmodelo">Cadastrar Modelo</router-link>
    <router-link to="/cadastrarmarca">Cadastrar Marca</router-link>
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
  align-items: center;
  justify-content: flex-start;
  top:70px;
  position:relative;
}

nav {
  background-color:none;
  position:fixed;
  top: 0px;
  width: 550px;
  height: 55px;   
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 25px;
  border-bottom: #35abe1 solid;
a {
    font-size: 14px;
    font-weight: 400;
    list-style: none;
    text-decoration: none;
    color: #616161;
    margin-right: 10px;
    margin-left: 10px;
    &.router-link-exact-active {
      color: #35abe1;
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
