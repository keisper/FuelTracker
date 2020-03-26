export default {
  items: [
    {
      name: 'Accueil',
      url: '/dashboard',
      icon: 'icon-home',
    },
    {
      name: 'Notifications',
      url: '/dashboard',
      icon: 'icon-speedometer',
    },
    {
      name: 'Personnes',
      url: '/pages',
      icon: 'icon-star',
      children: [
        {
          name: 'Clients',
          url: '/login',
          icon: 'icon-star',
        },
        {
          name: 'Utilisateurs',
          url: '/register',
          icon: 'icon-star',
        }
      ],
    },
  ],
};
