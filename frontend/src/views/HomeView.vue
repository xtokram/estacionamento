<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HomeView',
  components: {
  },
});
</script>

<template>
  <div class="titulo_estilo">Últimas movimentações</div>

  <div class="div_tabela">
    <table>
      <thead>
        <tr>
      
          <th class="tabela_estilo" >Nome</th>
          <th class="tabela_estilo">Placa</th>
          <th class="tabela_estilo">Modelo</th>
          <th class="tabela_estilo">Cor</th>
          <th class="tabela_estilo">Entrada</th>
          <th class="tabela_estilo">Saida</th>
        </tr>
      </thead>
      <tbody>
          <th class="tabela_estilo">Matheus H. Almeida</th>
          <th class="tabela_estilo">XXX-666</th>
          <th class="tabela_estilo">Accord</th>
          <th class="tabela_estilo">Azul</th>
          <th class="tabela_estilo">19:30</th>
          <th class="tabela_estilo">22:30</th>  
      </tbody>
    </table>

  </div>

  <button type="submit" class="btn">Cadastrar movimentação</button>

</template>
<style scoped lang="scss">

.titulo_estilo{
  color: white;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  top:-36%;
  
}
.tabela_estilo{
  color: white;
  padding: 20px;
}
.div_tabela{
  top: 15%;
  position: absolute;
  align-self: center;
}

.btn{
  background-color: #2c3e50;
  color: #FFF;
  font-size: 16px;
  font-weight: 500; 
  top:30%;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>

