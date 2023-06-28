<template>
  <nav class="navbar navbar-expand-lg nav-bar-color">
    <div class="container-fluid">
      <ul class="navbar-nav">
        <li class="nav-item"><router-link to="/" class="router-link-nav">Seja bem vindo</router-link></li>
        <li class="nav-item"><router-link to="/marca/lista" class="router-link-nav">Gerenciar Marcas</router-link></li>
        <li class="nav-item"><router-link to="/modelo/lista" class="router-link-nav">Gerenciar Modelos</router-link></li>
        <li class="nav-item"><router-link to="/veiculo/lista" class="router-link-nav">Gerenciar Veiculos</router-link></li>
        <li class="nav-item"><router-link to="/condutor/lista" class="router-link-nav">Gerenciar Condutores</router-link></li>
        <li class="nav-item"><router-link to="/movimentacao/lista" class="router-link-nav">Gerenciar Movimentações</router-link></li>
        <li class="nav-item"><router-link to="/configuracao/lista" class="router-link-nav">Gerenciar Configurações</router-link></li>
      </ul>
    </div>
  </nav>
  <router-view/>
</template>

<style lang="scss">



@import "~/node_modules/bootstrap/scss/bootstrap";
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css");

#app {
  font-family: -apple-system, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif ,Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #ffffff;
}

li {
  padding: 12px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #ffffff;
    }
  }
}

nav {
  background-color:none;
  height: 80px;   
  display: flex;
  justify-content: center;
  
  padding: 2px;
  border-bottom: black solid;
a {
    display: flex;
    font-size: 12px;
    font-weight: 0;
    list-style: none;
    text-decoration: none;
    color: #616161;
    position:relative;
    margin-right: 45px;
    margin-left: 45px;
    &.router-link-exact-active {
      color: white;
    }
}
}
body{
  background-color: #1e1f1e;
  margin: 0px;
  padding: 0px;
}
</style>
