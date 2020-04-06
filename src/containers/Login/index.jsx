import React, {useState, useEffect, useContext} from "react";
import {DataSessionContext, DataUserContext} from "../../utils";

import {MdPerson, MdPersonOutline, MdLockOutline} from 'react-icons/md'
import {Button, Input, message} from "antd";

import "./Login.css"
import Logo from '../../assets/logo.png'


export default function Login(props) {
    const manageSession = useContext(DataSessionContext);
    const manageUsers = useContext(DataUserContext);

    const [email, setEmail] = useState("");
    const [is_email, setIsEmail] = useState(false);
    const [password, setPassword] = useState("");
    const [ready, setReady] = useState(false);
    const [errorMsg, setErrorMsg] = useState("");

    message.config({top: 60});


    useEffect(() => {
        document.title += " | Connexion";
        if (email !== "" && password.length > 7){
            const emailReg  = new RegExp(/^([\w-.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})/i);
            setIsEmail(emailReg.test(email));
            setReady(true)
        }

        if(errorMsg) {
            message.error(errorMsg, 50);
            setErrorMsg("")
        }

    }, [email, password, errorMsg]);

    const handleSubmit = e => {
        e.preventDefault();
        const {response, message: msg, data} = manageUsers.login([email, is_email], password,  manageSession);
        message.destroy();
        if(response) {
            (data.role === "ADMIN") ? props.history.push(`/root`) : props.history.push(`/home`)
        }else setErrorMsg(msg)
    };


    return (
        <div className="login_wrapper">
            <div className="login_brand">
                <div className="login_brand--left">
                    <a href="https://topinvestici.net/"><img src={Logo} alt="logo"/></a>
                    <div className="login_brand--text">
                        <h2>FuelTracker</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti dolore ducimus eius
                            exercitationem facere nemo reiciendis sint sit suscipit velit.</p>
                    </div>
                </div>
                <form className="login_brand--right" onSubmit={handleSubmit}>
                    <p className="icon--login"><MdPerson/></p>
                    <Input id="username" value={email} onChange={e => {setEmail(e.target.value)}} autoComplete="off" required size="large" placeholder="Email ou nom d'utlisateur" prefix={<MdPersonOutline    />} />
                    <Input id="password" value={password} onChange={e => {setPassword(e.target.value)}} type="password" required autoComplete="off" size="large" placeholder="Mot de passe" prefix={<MdLockOutline />} />
                    <Button htmlType="submit" className="my-secondary-color" size="large" disabled={!ready}>Se connecter</Button>
                    <a href="#">Mot de passe oublié ?</a>
                </form>
            </div>
        </div>
    )
}