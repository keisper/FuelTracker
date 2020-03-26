import React, {useEffect, useState} from 'react';
import {Link, Redirect} from "react-router-dom";

export default function DashboardUser(props) {
    const [user, setUser] = useState(JSON.parse(sessionStorage.user))

    if(user.role !== "USER")
        return <Redirect to="/error/403"/>

    return (
        <div>
            Welcome User!<br /><br />
            <Link to='/logout'>Logout</Link>

            <br/><br/>

            <h3>Profil de  {user.username}</h3>
            <ul>
                <li><label htmlFor="">Nom : </label><input type="text" value={user.nom}/></li>
                <li><label htmlFor="">Prénom : </label><input type="text" value={user.prenom}/></li>
                <li><label htmlFor="">Nom d'utilisateur : </label><input type="text" value={user.username}/></li>
                <li><label htmlFor="">Nationalité : </label><input type="text" value={user.nationalite}/></li>
                <li><label htmlFor="">Adresse : </label><input type="text" value={user.adresse}/></li>
            </ul>
            <button>Modifier</button>
        </div>
    );
}
