<template>
  <div class="titulo_estilo">Últimas movimentações</div>

  <div class="div_tabela">
    <table>
      <thead>
        <tr   >
          <th class="tabela_estilo">Nome</th>
          <th class="tabela_estilo">Valor</th>
          <th class="tabela_estilo">Placa</th>
          <th class="tabela_estilo">Modelo</th>
          <th class="tabela_estilo">Entrada</th>
          <th class="tabela_estilo">Saida</th>
        </tr>
      </thead>
      
      <tbody class="tabela_estilo">
        <tr v-for="item in movimentacaoList" :key="item.id">
          <th>{{item.condutor.nome}}</th>
          <th>{{item.veiculo.placa}}</th>
          <th>R$ {{item.valorTotal}}</th>
          <th>{{item.veiculo.modelo.nome}}</th>
          <th>{{ item.entrada }}</th>
          <th>{{ item.saida }} </th>  
          <th> <button type="button" class="btn btn-info btn-sm">Edit</button> </th>
          <th>  </th>
          <th> <button type="button" class="btn btn-info btn-sm">Remover</button> </th>
        </tr>
      </tbody>
    </table>
  
  </div>
  <div class = "botao_cadastrar">

  <RouterLink to="/cadastrarmovimentacao"> <button type="submit" class="btn btn-primary btn-sm" >Cadastrar movimentação</button> </RouterLink>
  </div>
</template>

<script lang="ts">

import { defineComponent } from 'vue';

import MovimentacaoClient from '@/client/movimentacao.client';
import { Movimentacao } from '@/model/movimentacao';



export default defineComponent({
  name: 'MovimentacaoLista',
  data() {
    return {
        movimentacaoList: new Array<Movimentacao>()
    }
  },
  mounted() {
    this.findAll();
  },
  methods: {

    findAll() {
      MovimentacaoClient.listAll()
        .then(sucess => {
          this.movimentacaoList = sucess
        })
        .catch(error => {
          console.log(error);
        });
    }
  }

});

</script>

<style scoped lang="scss">
.botao_cadastrar{
  top: 70%;
  position: absolute;
  align-self: center;
}
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
  position: relative;
}

.btn:hover{
  transform: scale(1.05);
}
</style>

