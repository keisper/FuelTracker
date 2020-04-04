import React from "react";
import {Redirect} from "react-router-dom";

export default function Logout() {
    sessionStorage.removeItem('uid');
    return <Redirect to="/login"/>
}