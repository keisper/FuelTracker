import React, {useState} from "react";
import {Link, useParams} from 'react-router-dom'

export default function Error(props) {
    const {prevUrl, setPrevUrl} = useState("");
    const {status} = useParams();
    console.log(prevUrl)
    return (
        <div>
            <Link to={props.history}>Retour</Link><br/>
            status {status}
        </div>
    )
}