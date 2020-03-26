export const users = [
    {
        id: 1, username: "admin", password: "admin", token: "token 1",
        nom: "nom admin", prenom: "prenom admin", nationalite: "camerounaise", adresse: "adresse admin",
        statut: true, role: "ADMIN"
    },

    {
        id: 2, username: "username 2", password: "password 2", token: "token 2",
        nom: "nom 2", prenom: "prenom 2", nationalite: "camerounaise", adresse: "adresse 2",
        statut: true, role: "USER"
    },

    {
        id: 3, username: "username 3", password: "password 3", token: "token 3",
        nom: "nom 3", prenom: "prenom 3", nationalite: "camerounaise", adresse: "adresse 3",
        statut: true, role: "USER"
    },

    {
        id: 4, username: "username 4", password: "password 4", token: "token 4",
        nom: "nom 4", prenom: "prenom 4", nationalite: "camerounaise", adresse: "adresse 4",
        statut: true, role: "USER"
    },

    {
        id: 5, username: "username 5", password: "password 5", token: "token 5",
        nom: "nom 5", prenom: "prenom 5", nationalite: "camerounaise", adresse: "adresse 5",
        statut: true, role: "USER"
    },
]

// return the user data from the session storage
export const getUserById = (id) => {
    const index = users.findIndex(u => u.id === id)
    return users[index]
}
export const getUserByToken = (token) => {
    const index = users.findIndex(u => u.token === token)
    return users[index]
}
export const getUserByLogin = (n, p) => {
    const index = users.findIndex(u => u.username === n && u.password === p)
    return users[index]
}


// return the token from the session storage
export const getToken = () => {
    return sessionStorage.getItem('token') || null;
}

// remove the token and user from the session storage
export const removeUserSession = () => {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('user');
}

// set the token and user from the session storage
export const setUserSession = (token, user) => {
    sessionStorage.setItem('token', token);
    sessionStorage.setItem('user', JSON.stringify(user));
}