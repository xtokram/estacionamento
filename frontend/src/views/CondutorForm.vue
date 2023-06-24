<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarcondutor',
  components: {
  },
});

</script>

<template>

  <form >
    <div class="row">
      <h1>Cadastrar condutor</h1>
      <div class="col">
        <input type="text" class="form-control" placeholder="Nome"  aria-label="Nome">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Telefone"  aria-label="Telefone">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="CPF"  aria-label="CPF">
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
  color: white;
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
