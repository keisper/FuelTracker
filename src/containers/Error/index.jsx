import React from "react";
import {useLocation} from "react-router-dom";


export default function Error() {
    const location = useLocation()
    return <p>Page Not Found {location.pathname}</p>
}