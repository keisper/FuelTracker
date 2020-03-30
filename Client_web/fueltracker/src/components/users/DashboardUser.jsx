import React, {Suspense, useEffect, useState} from 'react';
import {Link, Redirect} from "react-router-dom";

import Header from "./Header";
import Footer from "../Footer";

import navigation from '../admin/_nav'
import routes from "../../routes"



import {
    AppHeader,
    AppSidebar,
    AppSidebarFooter,
    AppSidebarForm,
    AppSidebarHeader, AppSidebarMinimizer,
    AppSidebarNav2 as AppSidebarNav
} from "@coreui/react";

import AddForm from "../admin/DashboardAdmin";
import {Button, Col, Pagination, PaginationItem, PaginationLink, Row, Table} from "reactstrap";

export default function DashboardUser(props) {
    const [user, setUser] = useState(JSON.parse(sessionStorage.user))

    const loading = () => <div className="animated fadeIn pt-1 text-center">Loading...</div>

    const signOut = (e) => {
        e.preventDefault()
        props.history.push('/logout')
    }

    if(user.role !== "USER")
        return <Redirect to="/error/403"/>

    return (
        <div className="app">
            <AppHeader fixed>
                <Suspense  fallback={loading()}>
                    <Header onLogout={e=>signOut(e)}/>
                </Suspense>
            </AppHeader>
            <div className="app-body">
                <AppSidebar fixed display="lg">
                    <AppSidebarHeader />
                    <AppSidebarForm />
                    <Suspense>
                        <AppSidebarNav navConfig={navigation} {...props} router={routes}/>
                    </Suspense>
                    <AppSidebarFooter />
                    <AppSidebarMinimizer />
                </AppSidebar>

                <main className="main">
                    <div className="container-fluid">
                        <div className="animated fadeIn">
                            <div className="card mt-4">
                                <div className="card-header bg-teal text-white">
                                    <strong>Welcome User!</strong>
                                </div>
                                <div className="card-body">
                                    <form className="">
                                        <h1 className="text-center">Profil de  {user.username}</h1>
                                        <br/><br/>
                                        <Row>
                                            <Col xs="3">

                                            </Col>
                                            <Col xs="6">
                                                <div xs="4" className="mb-3 input-group">

                                                    <div className="input-group-prepend">
                                                <span className="input-group-text">
                                                    Nom
                                                </span>
                                                    </div>
                                                    <input type="text" className="form-control" type="text" value={user.nom}/>
                                                </div>
                                            </Col>
                                            <Col xs="3" className="text-right">

                                            </Col>
                                        </Row>

                                        <Row>
                                            <Col xs="3">

                                            </Col>
                                            <Col xs="6">
                                                <div className="mb-3 input-group">
                                                    <div className="input-group-prepend">
                                                <span className="input-group-text">
                                                    Prénom
                                                </span>
                                                    </div>
                                                    <input type="text" className="form-control" type="text" value={user.prenom}/>
                                                </div>
                                            </Col>
                                            <Col xs="3" className="text-right">

                                            </Col>
                                        </Row>

                                        <Row>
                                            <Col xs="3">

                                            </Col>
                                            <Col xs="6">
                                                <div className="mb-3 input-group">
                                                    <div className="input-group-prepend">
                                                <span className="input-group-text">
                                                    Nationalité
                                                </span>
                                                    </div>
                                                    <input type="text" className="form-control" type="text" value={user.username}/>
                                                </div>
                                            </Col>
                                            <Col xs="3" className="text-right">

                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col xs="3">

                                            </Col>
                                            <Col xs="6">
                                                <div className="mb-3 input-group">
                                                    <div className="input-group-prepend">
                                                <span className="input-group-text">
                                                    Adresse
                                                </span>
                                                    </div>
                                                    <input type="text" className="form-control" type="text" value={user.adresse}/>
                                                </div>
                                            </Col>
                                            <Col xs="3" className="text-right">

                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col xs="3">

                                            </Col>
                                            <Col xs="6">
                                                <div className="mb-3 input-group">
                                                    <div className="input-group-prepend">
                                                <span className="input-group-text">
                                                    Nom d'utilisateur
                                                </span>
                                                    </div>
                                                    <input type="text" className="form-control" type="text" value={user.nationalite}/>
                                                </div>
                                            </Col>
                                            <Col xs="3" className="text-right">

                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col xs="10">

                                            </Col>
                                            <Col xs="2" className="text-right">
                                                <button className="px-4 bg-teal btn btn-success" >Modifier</button>
                                            </Col>
                                        </Row>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </main>

            </div>

        </div>
    );
}
