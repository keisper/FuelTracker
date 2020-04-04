/**
 * @author SK Childéric
 * @version 0.0.2
 * @description Ce module s'occupe de tout l'aspect Données (Interaction avec la base de données)
 */



/**
 * @name Session
 * @class
 * @classdesc Cette classe permet de gérer la session locale de l'utlisateur
 * @type {{getUID: (function(): string), deleteUID: (function(): void), setUID: (function(*=): void), clean: Session.clean}}
 */
const Session = {

    /**
     * @description retourne l'uid de la session storage
     * @return {string}
     */
    getUID: () => sessionStorage.getItem('uid'),


    /**
     * @description modifie le token et l'utilisateur de la session storage
     * */
    setUID: (id) => sessionStorage.setItem('uid', id),


    /**
     * @description supprimer l'uid de la session storage
     * */
    deleteUID: () => sessionStorage.removeItem('uid'),


    /**
     * nettoyer toute la session storage
     * */
    clean: () => {
        this.deleteUID();
        sessionStorage.clear();
    }

}




/**
 * @name User
 * @class
 * @classdesc Cette classe gère les utilisateurs du système (elle sera automatiquement instancié dans le contexte globale de l'application avec DataUserContext)
 */
class User {

    /**
     * @constructor
     * @description cette
     */
    constructor() {
        this.users = [
            {
                id: 1, token: "token 1",
                username: "admin", password: "admin", email:"email@email.com",
                nom: "nom admin", prenom: "prenom admin",
                pays: "Cameroun", adresse: "adresse admin",
                statut: true, role: "ADMIN"
            },

            {
                id: 6, token: "token 6",
                username: "westbook", password: "77539953", email:"westbook90@email.com",
                nom: "SOCGNA", prenom: "Childéric",
                pays: "Cameroun", adresse: "Yaoundé 345125, Nsimeyoung",
                statut: true, role: "ADMIN"
            },

            {
                id: 2, token: "token 2",
                username: "username 2", password: "password 2", email:"email2@email.com",
                nom: "nom 2", prenom: "prenom 2",
                pays: "Cameroun", adresse: "adresse 2",
                statut: true, role: "USER"
            },

            {
                id: 3, token: "token 3",
                username: "username 3", password: "password 3", email:"email3@email.com",
                nom: "nom 3", prenom: "prenom 3",
                pays: "Cameroun", adresse: "adresse 3",
                statut: true, role: "USER"
            },

            {
                id: 4, username: "username 4", password: "password 4", token: "token 4",
                nom: "nom 4", prenom: "prenom 4", pays: "Cameroun", adresse: "adresse 4",
                statut: true, role: "USER"
            },

            {
                id: 5, username: "username 5", password: "password 5", token: "token 5",
                nom: "nom 5", prenom: "prenom 5", pays: "Cameroun", adresse: "adresse 5",
                statut: true, role: "USER"
            },
        ]
    }


    /**
     * Liste tous les utilisateurs du système (Clients comme administrateur)
     * @return {({password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string})[]}
     */
    findAll = () => this.users;


    /**
     * Liste les informations d'un seul utilisateur
     * @param id
     * @return {{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|*}
     */
    findById = id => this.users[this.users.findIndex(elt => elt.id === id)];

    findByToken = token => this.users[this.users.findIndex(elt => elt.token === token)];

    /**
     * Recherche les utilisateurs en fonction du nom d'utlisateur
     * @param username
     * @return {{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|*}
     * @private
     */
    _findByLogin = (username) => this.users[this.users.findIndex(elt => elt.username === username)];


    /**
     * Recherche les utilisateurs en fonction de l'email
     * @param email
     * @return {{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|*}
     * @private
     */
    _findByEmail = (email) => this.users[this.users.findIndex(elt => elt.email === email)];


    /**
     * Connecte l'utilisateur au système, ceci en fonction de nom d'utilisateur ou de l'email
     * @param field (email ou non d'utlisateur)
     * @param is_email
     * @param password
     * @param session
     * @return {{data: ({password: string, role: string, adresse: string, id: number, nom: string, prenom: string, email: string, statut: boolean, token: string, username: string, pays: string}|{password: string, role: string, adresse: string, id: number, nom: string, prenom: string, statut: boolean, username: string, token: string, pays: string}|*), response: boolean, message: string}|{response: boolean, message: string}}
     */
    login = ([field, is_email], password, session) => {
        const userLogged = is_email ? this._findByEmail(field) : this._findByLogin(field);
        if (!!userLogged && userLogged.password === password){
            session.setUID(userLogged.id);
            return {response: true, message: `Bon retour parmi nous ${userLogged.nom}`, data: userLogged}
        }
        return {response: false, message: !!userLogged ? "Mot de passe incorrect" : "Nom d'utilisateur ou Email incorrect"}
    };


    /**
     * Déconnecte l'utilisateur du système
     */
    logout = () => sessionStorage.removeItem('id');

    /**
     * Permet de changer le mot de passe
     * @param email
     */
    passwordReset = email => console.log("Mot de passe changé")
}


export {User, Session}