<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarveiculo',
  components: {
  },
})

</script>

<template>
<form >
    <div class="row">
      <h1>Cadastrar Veículo</h1>
      <div class="col">
        <input type="text" class="form-control" placeholder="Placa"  aria-label="Placa">
      </div>

    <div class="col">
        <input type="text" class="form-control" placeholder="Ano"  aria-label="Ano">
    </div>
    </div>
    <div class="column is-offset-4 is-2" style="border-top-left-radius: 0px;">
        <div class="select is-fullwidth">
            <select class="rounded " style="width: 255px; height: 38px; text-align: center;">
                <option hidden disabled selected> Selecione a Marca</option>
                <option></option>
            </select>
        </div>
    </div>
    <div class="column is-offset-4 is-2" style="border-top-left-radius: 0px;">
        <div class="select is-fullwidth">
            <select class="rounded " style="width: 255px; height: 38px; text-align: center;">
                <option hidden disabled selected> Selecione a Modelo</option>
                <option></option>
            </select>
        </div>
    </div>
    <div class="column is-offset-4 is-2" style="border-top-left-radius: 0px;">
        <div class="select is-fullwidth">
            <select class="rounded " style="width: 255px; height: 38px; text-align: center;">
                <option hidden disabled selected> Selecione a Cor</option>
                <option></option>
            </select>
        </div>
    </div>
    <div class="column is-offset-4 is-2" style="border-top-left-radius: 0px;">
        <div class="select is-fullwidth">
            <select class="rounded " style="width: 255px; height: 38px; text-align: center;">
                <option hidden disabled selected> Selecione a Tipo</option>
                <option></option>
            </select>
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

.rounded {
    margin-bottom: 15px;
}
h1 { 
  font-size: 24px;
  margin-top: 10px;
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