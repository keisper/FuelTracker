import React, {useState} from "react";
import {Input} from "reactstrap";

const InputPerso = ({initialValue, type, callback}) => {

    const [value, setValue] = useState(initialValue);

    const handleChange = e => callback ? callback(): setValue(e.currentTarget.value);

    if (!type) type = "text"
    if (!value) setValue("")
    return (
        <Input type={type} value onChange={handleChange}/>
    )
}

export default InputPerso;