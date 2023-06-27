<template>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 text-start">
                <h2 class="fs-3">Veiculos</h2>
            </div>
            <div class="col-md-2 d-grid gap-2">
                <router-link to="/veiculo/formulario" type="button" class="btn btn-warning">Cadastrar</router-link>
            </div>
        </div>
        <div class="row">
            <div>
                <table class="table table-dark mt-4">
                    <thead>
                        <tr>
                            <th scope="col">Nº</th>
                            <th scope="col">ATIVO</th>
                            <th scope="col">PLACA</th>
                            <th scope="col">MODELO</th>
                            <th scope="col">COR</th>
                            <th scope="col">TIPO</th>
                            <th scope="col">ANO</th>
                            <th scope="col">GERENCIAR</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr v-for="item in marcasList" :key="item.id">
                            <td>{{ item.id }}</td>
                            <td>
                                <span v-if="item.ativo" class="badge text-bg-success"> Ativo </span>
                                <span v-if="!item.ativo" class="badge text-bg-danger"> Inativo </span>

                            </td>
                            <td>{{ item.placa }}</td>
                            <td>{{ item.modelo.nome }}</td>
                            <td>{{ item.cor }}</td>
                            <td>{{ item.tipo }}</td>
                            <td>{{ item.ano }}</td>
                            <th class="col-md-2">
                                <div>
                                    <router-link type="button" class="btn btn-outline-warning"
                                        :to="{ name: 'veiculo-formulario-editar-view', query: { id: item.id, form: 'editar' } }">
                                        <i class="bi bi-pencil-fill"></i>
                                    </router-link>
                                    <router-link type="button" class="btn btn-outline-danger ms-3"
                                        :to="{ name: 'veiculo-formulario-excluir-view', query: { id: item.id, form: 'excluir' } }">
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

import veiculoClient from '@/client/veiculo.client';
import { Veiculo } from '@/model/veiculo';

export default defineComponent({
    name: 'MarcaLista',
    data() {
        return {
            marcasList: new Array<Veiculo>()
        }
    },
    mounted() {
        this.findAll();
    },
    methods: {

        findAll() {
            veiculoClient.listAll()
                .then(sucess => {
                    this.marcasList = sucess;
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
});

</script>

<style lang="scss">
.text-menor {
    font-size: 14px;
}
</style>