<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarcondutor',
  components: {
  },
});
/*import { Condutor } from '@/model/condutor';
import { CondutorCliente } from '@/client/condutor.client';
import { Notification } from '@/model/notification'

export default class condutorForm extends Condutor {
  public notification : Notification = new Notification()
  public condutor : Condutor = new Condutor
  public CondutorCliente! : CondutorCliente

  public mounted(): void {
    this.CondutorCliente = new CondutorCliente()
      console.log(this.nome)
      console.log(this.telefone)
      console.log(this.cpf)
  }

  public onClickCadastrar(): void {
    this.CondutorCliente.cadastrar(this.condutor)
      .then(
        success => {
          this.notification = this.notification.new(true, 'notification is-success', 'Condutor cadastrado com sucesso!!!');
          this.onClickLimpar();
      },
      error => {
        this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error);
        this.onClickLimpar();
      });
  }

  public onClickFecharNotificacao(): void {
    this.notification = new Notification()
  }
  public onClickLimpar(): void {
    this.condutor = new Condutor()
  }
}*/
</script>

<template>
  <!--<div class="columns" v-if="notification.ativo">
    <div class="column is-12">
      <div :class="notification.classe">
      <button @click="onClickFecharNotificacao()" class="delete" ></button>
        {{ notification.mensagem }}
      </div>
    </div>
  </div>-->

  <form >
    <img height="132px" width="132px" src="../assets/condutor.png" alt=""/>
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
