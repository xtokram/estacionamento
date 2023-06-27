<template>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 text-start">
                <h2 class="fs-3 align-baseline">Condutores</h2>
            </div>
            <div class="col-md-2 d-grid">
                <router-link to="/condutor/formulario" type="button" class="btn btn-warning">Cadastrar</router-link>
            </div>
        </div>
        <div>
            <div>
                <table class="table table-striped table-dark mt-4">
                    <thead>
                        <tr>
                            <th scope="col">Nº</th>
                            <th scope="col">ATIVO</th>
                            <th scope="col">NOME</th>
                            <th scope="col">CPF</th>
                            <th scope="col">TELEFONE</th>
                            <th scope="col">GERENCIAR</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr v-for="item in condutorList" :key="item.id">
                            <td> {{ item.id }} </td>
                            <td>
                                <span v-if="item.ativo" class="badge text-bg-success"> Ativo </span>
                                <span v-if="!item.ativo" class="badge text-bg-danger"> Inativo </span>
                            </td>
                            <td> {{ item.nome }}</td>
                            <td> {{ item.cpf}}</td>
                            <td>{{ item.telefone}}</td>
                            <th class="col-md-2">
                                <div>
                                    <router-link type="button" class="btn btn-outline-warning"
                                        :to="{ name: 'condutor-formulario-editar-view', query: { id: item.id, form: 'editar' } }">
                                        <i class="bi bi-pencil-fill"></i>
                                    </router-link>
                                    <router-link type="button" class="btn btn-outline-danger ms-3"
                                        :to="{ name: 'condutor-formulario-excluir-view', query: { id: item.id, form: 'excluir' } }">
                                        <i class="bi bi-trash-fill"></i>
                                    </router-link>
                                </div>
                            </th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import  condutorClient  from '@/client/condutor.client';
import { Condutor } from '@/model/condutor';

export default defineComponent({
    name: 'ModeloLista',
    data(){
        return {
            condutorList: new Array<Condutor>()
        }
    },
    mounted() {
        this.findAll();
    },
    methods: {
        findAll() {
            condutorClient.listAll()
                .then(sucess => {
                    this.condutorList = sucess;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
});

</script>

<style lang="scss">

</style>