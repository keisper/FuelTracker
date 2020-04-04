import React, { useState, useContext } from "react";
// noinspection ES6CheckImport
import {Switch, useRouteMatch} from "react-router-dom";
import { MdApps, MdHome, MdPeople, MdNotifications, MdAccountCircle, MdSettings, MdPowerSettingsNew } from "react-icons/md";

import Sidenav from "../../components/Sidenav"
import { DataSessionContext, DataUserContext} from "../../utils";
import {Home, Stations, Users, Messages, Settings, Profile} from "./pages";

import PrivateRoute from "../../components/PrivateRoute";


export default function HomeAdmin() {

    const _idUserLogged = useContext(DataSessionContext).getUID();
    const userLogged = useContext(DataUserContext).findById(_idUserLogged);
    const { path, url } = useRouteMatch();

    const [currentPage, setCurrentPage] = useState("home");
    const listTopBar= {
        header: [
            { _id: "home", title: "Accueil", url: url, component: <MdHome/> },
            { _id: "stations", title: "Station", url: `${url}/stations`, component: <MdApps/> },
            { _id: "users", title: "Utilisateurs", url: `${url}/users`, component: <MdPeople/> },
            { _id: "messages", title: "Messages", url: `${url}/messages`, component: <MdNotifications/> },
        ],

        footer: [
            { _id: "profile", title: "Profile", url: `${url}/profile`, component: <MdAccountCircle/> },
            { _id: "setting", title: "Paramètre", url: `${url}/setting`, component: <MdSettings/> },
            { _id: "logout", title: "Déconnexion", url: "/logout", component: <MdPowerSettingsNew/>, quit: true},
        ]
    };

    return (
        <div className="app--wrapper">
            <Sidenav {...listTopBar} current={currentPage} setCurrent={setCurrentPage} />
            <div className="app--content" {...userLogged}>
                <Switch>
                    <PrivateRoute exact path={path} component={Home} />
                    <PrivateRoute exact path={`${path}/messages`} component={() => <Messages {...userLogged}/>} />
                    <PrivateRoute exact path={`${path}/profile`} component={() => <Profile {...userLogged}/>} />
                    <PrivateRoute exact path={`${path}/setting`} component={() => <Settings {...userLogged}/>} />
                    <PrivateRoute exact path={`${path}/stations`} component={() => <Stations {...userLogged}/>} />
                    <PrivateRoute exact path={`${path}/users`} component={() => <Users {...userLogged}/>} />
                </Switch>
            </div>
        </div>
    )
}