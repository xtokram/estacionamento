<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarmodelo',
  components: {
  },
});
</script>

<template>
  <form >
    <img height="132px" width="132px" src="../assets/modelo.png" alt=""/>
    <div class="row">
      <h1>Cadastrar modelo</h1>
      <div class="col">
        <input type="text" class="form-control" placeholder="Nome"  aria-label="Nome">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Marca"  aria-label="Marca">
      </div>
    </div>
    <button type="submit" class="btn">Cadastrar</button>
  </form>
</template>

<style scoped lang="scss">
.row{
  display:flex;
  flex-direction: column;
  width: 280px;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
}

h1 { 
  font-size: 24px;
  color: #35abe1;
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 700;
}
.col {
  margin-top: 12px;
}

.btn {
  background-color: #2c3e50;
  color: #FFF;
  font-size: 16px;
  font-weight: 500;
}

.btn:hover{
  transform: scale(1.05);
}


</style>