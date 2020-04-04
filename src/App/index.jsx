import React from 'react';
import 'antd/dist/antd.css';
import './App.css';
import Home, {HomeAdmin, Login, Station, Error, Logout} from "../containers";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import PrivateRoute from "../components/PrivateRoute";


export default function App() {
    return (
        <BrowserRouter>
            <Switch>
                <Route exact path="/" component={Login} />
                <Route exact path="/login" component={Login} />
                <Route exact path="/logout" component={Logout} />
                <Route exact path="/error/:status" component={Error} />
                <PrivateRoute exact path="/root/" component={HomeAdmin} />
                <PrivateRoute exact path="/home/" component={Home} />
                <PrivateRoute exact path="/station/" component={Station} />
            </Switch>
        </BrowserRouter>
    );
}