import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/cadastrarcondutor',
    name: 'cadastrarcondutor',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/CondutorForm.vue')
  },
  {
    path: '/cadastrarmodelo',
    name: 'cadastrarmodelo',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/ModeloForm.vue')
  },
  {
    path: '/cadastrarmarca',
    name: 'cadastrarmarca',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/MarcaForm.vue')
  },
  {
    path: '/cadastrarveiculo',
    name: 'cadastrarveiculo',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/VeiculoForm.vue')
  },
  {
    path: '/cadastrarmovimentacao',
    name: 'cadastrarmovimentacao',
    component:() => import('../views/cadastrarmovimentacao.vue')

  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
