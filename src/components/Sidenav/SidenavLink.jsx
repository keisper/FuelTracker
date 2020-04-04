import React from "react";
import {NavLink} from "react-router-dom";

export default function ({_id, title, url, component}) {
    return <li><NavLink exact to={url}>{component}</NavLink></li>
}