<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HomeView',
  components: {
  },
});
</script>

<template>
  <div class="container">
    <h1>Ultimas movimentações</h1>
      <div >
          <table class="table table-sm">
              <thead class="table-secondary">
                  <tr class="tabela_superior">
                      <th>ID</th>
                      <th>Veiculo</th>
                      <th>Condutor</th>
                      <th>Entrada</th>
                      <th>Saida</th>
                      <th>Valor Total</th>
                      <th>Valor Hora</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>1</td>
                      <td>1</td>
                      <td>1</td>
                      <td>1</td>
                      <td>1</td>
                      <td>1</td>
                      <td>1</td>
                      
                      
                  </tr>
              </tbody>
          </table>
      
      </div>
  </div>
</template>

<script lang="ts">

</script>



<style scoped lang="scss">

  .container{
    
  }

  .tabela_superior{
    background-color: blue;
  }
</style>

