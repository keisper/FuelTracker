import React from 'react';

const Login = React.lazy(() => import('./components/Login'));
const Logout = React.lazy(() => import('./components/Logout'));
const Errors = React.lazy(() => import('./components/Errors'));
const DashboardUser = React.lazy(() => import('./components/users/DashboardUser'));
const DashboardAdmin = React.lazy(() => import('./components/admin/DashboardAdmin'));


const routes = [
  { path: '/login', exact: true, name: 'Login', component: Login },
  { path: '/logout', exact: true, name: 'Logout', component: Logout },
  { path: '/error/:status', exact: true, name: 'Error', component: Errors },
  { path: '/dashboard/:id', exact: true, name: 'Dashboard', component: DashboardUser },
  { path: '/dashboard/:id', exact: true, name: 'Dashboard Admin', component: DashboardAdmin },
];

export default routes;
