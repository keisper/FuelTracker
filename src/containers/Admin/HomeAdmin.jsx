import React, { useState, useContext } from "react";
import {Button} from "antd";
import { MdApps, MdHome, MdPeople, MdNotifications, MdAccountCircle, MdSettings, MdPowerSettingsNew } from "react-icons/md";

import Sidenav from "../../components/Sidenav"
import {DataSessionContext, DataUserContext} from "../../utils";
import {Home, Stations, Users, Messages} from "./pages";
import {BrowserRouter, Switch} from "react-router-dom";
import PrivateRoute from "../../components/PrivateRoute";


export default function HomeAdmin(props) {

    const user = useContext(DataUserContext);

    const [currentPage, setCurrentPage] = useState("home")
    const [listTopBar, setListTopBar] = useState({
        header: [
            { _id: "home", title: "Accueil", component: <MdHome/> },
            { _id: "stations", title: "Station", component: <MdApps/> },
            { _id: "users", title: "Utilisateurs", component: <MdPeople/> },
            { _id: "messages", title: "Messages", component: <MdNotifications/> },
        ],

        footer: [
            { _id: "profile", title: "Profile", component: <MdAccountCircle/> },
            { _id: "setting", title: "Paramètre", component: <MdSettings/> },
        ]
    });

    const renderPage = () => {
        switch (currentPage) {
            case "stations":
                return <Stations/>
            case "users":
                return <Users/>
            case "messages":
                return <Messages/>
            default:
                return <Home/>
        }
    }

    return (
        <div className="app--wrapper">
            <Sidenav {...listTopBar} current={currentPage} setCurrent={setCurrentPage} />
            <div className="app--content">
                {renderPage()}
            </div>
            <BrowserRouter basename="root">
                <Switch>
                    {listTopBar.header.map(
                        ({_id, title, component}, index) => (
                            <PrivateRoute key={`route-root-${_id}`} exact path={title} {...component} />
                        )
                    )}
                </Switch>
            </BrowserRouter>
        </div>
    )
}