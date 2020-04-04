import React, {useContext} from "react";
import {Button, Col, Modal, Row, Table} from "antd";
import {DataUserContext} from "../../../utils";

export default function Users(props) {
    // const _idUserLogged = useContext(DataSessionContext).getUID();
    const users = useContext(DataUserContext);
    const listUsers = [];
    users.findAll().map(({nom, prenom, id: key, ...rest}) => listUsers.push({key, nom: `${nom} ${prenom}`, ...rest}));

    const columns = [
        {title: 'Nom et prénom', dataIndex: 'nom', key: 'name',},
        {title: "Nom d'utilisateur", dataIndex: 'username', key: 'username',},
        {title: "Email", dataIndex: 'email', key: 'email',},
        {title: "Pays", dataIndex: 'pays', key: 'pays',},
        {title: "Adresse", dataIndex: 'adresse', key: 'adresse',},
        {
            title: "Action", key: 'action', render: () => (<>
                <Button type="primary" style={{marginRight: 16}}>Détails</Button>
                <Button type="danger">Supprimer</Button>
            </>)
        },
    ];
    return (
        <>
            <h2 className="title"><span>FuelTracker | </span>Utilisateurs</h2>
            <div className="app--body">
                <Row justify="end" style={{marginBottom: "20px"}}>
                    <Col><Button className="my-secondary-color" size="large">Ajouter</Button></Col>
                </Row>
                <Table dataSource={listUsers} columns={columns}/>;
            </div>
        </>
    )
}