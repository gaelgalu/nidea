import { RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
  {
    path: '',
    title: 'Menú',
    icon: 'mdi mdi-dots-horizontal',
    class: 'nav-small-cap',
    extralink: true,
    submenu: []
  },
  {
    path: '/starter',
    title: 'Página Principal',
    icon: 'mdi mdi-gauge',
    class: '',
    extralink: false,
    submenu: []
  },
  {
    path: '/desafios',
    title: 'Desafios',
    icon: 'mdi mdi-equal',
    class: '',
    extralink: false,
    submenu: []
  }
];
