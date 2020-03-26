import React, { useState } from 'react';
import { Button, Card, CardBody, CardGroup, Col, Container, Form, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap'
import {AxiosInstance as axios} from "axios";
import {getUserByLogin, setUserSession} from "../utils/dev/Common";
import {Link} from "react-router-dom";
import {useFormInput} from "../utils/tools";

/*export default function Login(props) {
    const [loading, setLoading] = useState(false);
    const username = useFormInput('');
    const password = useFormInput('');
    const [error, setError] = useState(null);

    // handle button click of login form
    const handleLogin = () => {
        setError(null);
        setLoading(true);
        axios.post('http://localhost:4000/users/signin', { username: username.value, password: password.value }).then(response => {
            setLoading(false);
            setUserSession(response.data.token, response.data.user);
            props.history.push('/dashboard');
        }).catch(error => {
            setLoading(false);
            if (error.response.status === 401) setError(error.response.data.message);
            else setError("Something went wrong. Please try again later.");
        });
    }

    return (
        <div>
            Login<br /><br />
            <div>
                Username<br />
                <input type="text" {...username} autoComplete="new-password" />
            </div>
            <div style={{ marginTop: 10 }}>
                Password<br />
                <input type="password" {...password} autoComplete="new-password" />
            </div>
            {error && <><small style={{ color: 'red' }}>{error}</small><br /></>}<br />
            <input type="button" value={loading ? 'Loading...' : 'Login'} onClick={handleLogin} disabled={loading} /><br />
        </div>
    );
}*/

export default function Login(props) {
    const [loading, setLoading] = useState(false);
    const username = useFormInput('');
    const password = useFormInput('');
    const [error, setError] = useState(null);

    // handle button click of login form
    const handleLogin = () => {
        setError(null);
        setLoading(true);

        const user = getUserByLogin(username.value, password.value)
        if (user){
            setLoading(false);
            setUserSession(user.token, user);
            if (user.role === "ADMIN")
                props.history.push(`/dashboard-admin/${user.id}`);
            else
                props.history.push(`/dashboard/${user.id}`);
        }else {
            setLoading(false);
            setError("Le nom d'utilisateur ou le mot de passe est incorrect.");
        }
    }

    return (
        <div className="app flex-row align-items-center">
            <Container>
                <Row className="justify-content-center">
                    <Col md="8">
                        <CardGroup>
                            <Card className="p-3">
                                <CardBody>
                                    <Form>
                                        <div className="text-center">
                                            <i className="fa fa-user-circle fa-4x"/>
                                        </div>
                                        <h1 className="text-center">Connexion</h1>
                                        <br/>
                                        {error && <><p className="text-danger">{error}</p></>}
                                        <InputGroup className="mb-3">
                                            <InputGroupAddon addonType="prepend">
                                                <InputGroupText>
                                                    <i className="icon-user"/>
                                                </InputGroupText>
                                            </InputGroupAddon>
                                            <Input type="text" {...username} placeholder="Nom d'utilisateur" autoComplete="username" />
                                        </InputGroup>
                                        <InputGroup className="mb-4">
                                            <InputGroupAddon addonType="prepend">
                                                <InputGroupText>
                                                    <i className="icon-lock"/>
                                                </InputGroupText>
                                            </InputGroupAddon>
                                            <Input type="password" placeholder="Mot de passe" {...password} autoComplete="new-password" />
                                        </InputGroup>

                                        <Row>
                                            <Col xs="6">
                                                <Button color="success" className="px-4 bg-teal" onClick={handleLogin} disabled={loading}>{loading ? 'Loading...' : 'Connexion'}</Button>
                                            </Col>
                                            <Col xs="6" className="text-right">
                                                <Button color="link" className="px-0 text-success">Mot de passe oublié ?</Button>
                                            </Col>
                                        </Row>
                                    </Form>
                                </CardBody>
                            </Card>
                            <Card className="text-white bg-teal py-5 d-md-down-none" style={{ width: '44%' }}>
                                <CardBody className="text-center">
                                    <div>
                                        <h2>FuelTracker</h2>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                                            labore et dolore magna aliqua.</p>
                                    </div>
                                </CardBody>
                            </Card>
                        </CardGroup>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}