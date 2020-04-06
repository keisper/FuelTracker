import React, {useState, useEffect, useContext} from "react";
import axios from "axios";
import {Button, Col, Modal, Row, Table} from "antd";

import ModelAddUser from "../../../components/ModalAddUser"


export default function Users(props) {
    const [users, setUsers] = useState([]);
    const [modalAddFormOpened, setModalAddFormOpened] = useState(false);
    useEffect(() => {
        axios.get(`${process.env.REACT_APP_HOST_API_SERVICE}/listerUtilisateur`)
            .then(res => {
                setUsers(
                    res.data.map(({idUtilisateur: key, nom, prenom, adresse, login: username, pays}) =>
                        ({key, nom: `${nom} ${prenom ? prenom : ""}`, adresse, pays, username})
                    )
                )
            })
    }, []);

    const columns = [
        {title: 'Nom et prénom', dataIndex: 'nom', key: 'name',},
        {title: "Nom d'utilisateur", dataIndex: 'username', key: 'username',},
        {title: "Email", dataIndex: 'email', key: 'email',},
        {title: "Pays", dataIndex: 'pays', key: 'pays',},
        {title: "Adresse", dataIndex: 'adresse', key: 'adresse',},
        {
            title: "Action", key: 'action', render: () => (<>
                <Button type="primary" className="my-primary-color" style={{marginRight: 16}}>Détails</Button>
                <Button type="danger">Supprimer</Button>
            </>)
        },
    ];

    const showModalAddUser = () => {
        setModalAddFormOpened(true);
    };

    return (
        <>
            <h2 className="title"><span>FuelTracker | </span>Utilisateurs</h2>
            <div className="app--body">
                <Row justify="end" style={{marginBottom: "20px"}}>
                    <Col><Button type="primary" className="my-secondary-color" onClick={showModalAddUser} size="large">Ajouter</Button></Col>
                </Row>
                <Table dataSource={users} columns={columns}/>;
                <ModelAddUser opened={modalAddFormOpened} setOpened={setModalAddFormOpened}/>
            </div>
        </>
    )
}