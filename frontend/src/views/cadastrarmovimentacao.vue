<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarmovimentacao',
  components: {
  },
});

</script>

<template>

  <form >
    <div class="row">
      <h1>Cadastrar movimentação</h1>
      <div class="col">
        <input type="text" class="form-control" placeholder="Condutor" aria-label="Condutor">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Veiculo"  aria-label="Veiculo">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Entrada"  aria-label="Entrada">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Saida"  aria-label="Saida">
      </div>
      <div class="col">
        <input type="text" class="form-control" placeholder="Valor Total"  aria-label="Valor Total">
      </div>
    </div>
    <button type="submit" class="btn btn-primary btn-sm">Cadastrar</button>
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
