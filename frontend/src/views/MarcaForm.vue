<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'cadastrarmarca',
  components: {
  },

});
</script>

<template>
<form >
    <div class="row">
      <h1>Cadastrar Marca</h1>
      <div class="col">
        <input type="text" class="form-control" placeholder="Marca"  aria-label="Marca">
      </div>
    </div>  
  </form>
  <div> <button type="submit" class="btn btn-primary btn-sm">Cadastrar</button> </div>
  
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
  margin-top: 10px;
  font-size: 32px;
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