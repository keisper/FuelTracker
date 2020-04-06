import React, {useContext} from "react";
import {Button, Col, Row, Table} from "antd";
import {DataSessionContext, DataUserContext} from "../../../utils";

export default function Home(props) {
    // const _idUserLogged = useContext(DataSessionContext).getUID();
    const users = useContext(DataUserContext);
    const listUsers = [];



    return (
        <>
            <h2 className="title"><span>FuelTracker | </span>Accueil</h2>
            <div className="app--body">
                <Row justify="end" style={{marginBottom: "20px"}}>
                  <Col><Button className="my-secondary-color" size="large">Ajouter</Button></Col>
                </Row>
            </div>
        </>
    )
}