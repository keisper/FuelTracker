import React from 'react';
import 'antd/dist/antd.css';
import './App.css';
import Home, {HomeAdmin, Login, Station, Error, Logout} from "../containers";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import PrivateRoute from "../components/PrivateRoute";


export default function App() {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={Login} />
                <Route exact path="/login" component={Login} />
                <Route exact path="/logout" component={Logout} />
                <PrivateRoute path="/root" component={HomeAdmin} />
                <PrivateRoute path="/home" component={Home} />
                <PrivateRoute exact path="/station" component={Station} />
                <Route path="*" component={Error} />
            </Switch>
        </Router>
    );
}