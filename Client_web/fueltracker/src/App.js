import React, {useEffect, useState} from 'react';
import './App.scss';
import {BrowserRouter, Route, Switch} from "react-router-dom";

import Login from "./components/Login";
import DashboardAdmin from "./components/admin/DashboardAdmin";
import DashboardUser from "./components/users/DashboardUser";
import Errors from "./components/Errors";

import PrivateRoute from "./utils/dev/PrivateRoute";
import PublicRoute from "./utils/dev/PublicRoute";

import {getToken, getUserByToken, make_mirror_user, removeUserSession, setUserSession} from './utils/dev/Common';
import {AxiosInstance as axios} from "axios";
import Logout from "./components/Logout";

/*export default function App() {
    const [authLoading, setAuthLoading] = useState(true);

    useEffect(() => {
        const token = getToken();
        if (!token) {
            return;
        }

        axios.get(`http://localhost:4000/verifyToken?token=${token}`).then(response => {
            setUserSession(response.data.token, response.data.user);
            setAuthLoading(false);
        }).catch(error => {
            removeUserSession();
            setAuthLoading(false);
        });
    }, []);

    if (authLoading && getToken()) {
        return <div className="content">Checking Authentication...</div>
    }

    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <div className="header">
                        <NavLink exact activeClassName="active" to="/">Home</NavLink>
                        <NavLink activeClassName="active" to="/login">Login</NavLink><small>(Access without token only)</small>
                        <NavLink activeClassName="active" to="/dashboard-admin">Dashboard</NavLink><small>(Access with token only)</small>
                        <NavLink activeClassName="active" to="/dashboard">Dashboard</NavLink><small>(Access with token only)</small>
                    </div>
                    <div className="content">
                        <Switch>
                            <Route exact path="/" component={Home} />
                            <PublicRoute path="/login" component={Login} />
                            <PrivateRoute path="/dashboard-admin" component={DashboardAdmin} />
                            <PrivateRoute path="/dashboard" component={DashboardUser} />
                        </Switch>
                    </div>
                </div>
            </BrowserRouter>
        </div>
    );
}*/


export default function App() {
    const [authLoading, setAuthLoading] = useState(true);

    useEffect(() => {
        const token = getToken();
        if (!token) {
            return;
        }
        const user = getUserByToken(token);
        if (getUserByToken(token)){
            setUserSession(user.token, user);
            setAuthLoading(false);
        }else {
            removeUserSession();
            setAuthLoading(false);
        }
    }, []);

    if (authLoading && getToken()) {
        return <div className="content">Checking Authentication...</div>
    }

    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <div className="content">
                        <Switch>
                            <PublicRoute exact path="/" component={Login} />
                            <PublicRoute exact path="/login" component={Login} />
                            <Route exact path="/logout" component={Logout} />
                            <Route exact path="/error/:status" component={Errors} />
                            <PrivateRoute path="/dashboard-admin/:id" component={DashboardAdmin} />
                            <PrivateRoute path="/dashboard/:id" component={DashboardUser} />
                        </Switch>
                    </div>
                </div>
            </BrowserRouter>
        </div>
    );
}
